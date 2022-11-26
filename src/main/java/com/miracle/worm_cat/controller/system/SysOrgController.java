package com.miracle.worm_cat.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.worm_cat.common.constant.BaseConstant;
import com.miracle.worm_cat.common.constant.CacheKeys;
import com.miracle.worm_cat.common.domain.CheckResult;
import com.miracle.worm_cat.common.response.RespResult;
import com.miracle.worm_cat.common.utils.RedisUtil;
import com.miracle.worm_cat.controller.system.dto.OrgParam;
import com.miracle.worm_cat.domain.system.SysOrg;
import com.miracle.worm_cat.dto.system.organization.OrgOptsDTO;
import com.miracle.worm_cat.mapper.system.SysOrgMapper;
import com.miracle.worm_cat.service.system.SysOrgService;
import com.miracle.worm_cat.validate.AddGroup;
import com.miracle.worm_cat.validate.UpdateGroup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: Miracle-
 * time: 2022/11/21 18:54
 */
@RestController
@RequestMapping(value = "/system-mgr/sys-org")
public class SysOrgController {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SysOrgMapper orgMapper;

    @Resource
    private SysOrgService orgService;

    /**
     * 获取父级部门组织选项
     */
    @PostMapping(value = "orgOptsData")
    public RespResult<List<OrgOptsDTO>> optsData(@RequestParam(value = "flush", defaultValue = "false") Boolean flush) {
        List<OrgOptsDTO> orgOptsList;
        if (flush) {
            orgOptsList = orgMapper.orgOptsData(0);
            orgChildren(orgOptsList);
            redisUtil.set(CacheKeys.ORG_SELECT_KEY, orgOptsList);
        } else {
            boolean exists = redisUtil.exists(CacheKeys.ORG_SELECT_KEY);
            if (exists) {
                orgOptsList = (List<OrgOptsDTO>) redisUtil.get(CacheKeys.ORG_SELECT_KEY);
            } else {
                orgOptsList = orgMapper.orgOptsData(0);
                orgChildren(orgOptsList);
                redisUtil.set(CacheKeys.ORG_SELECT_KEY, orgOptsList);
            }
        }
        return RespResult.success(orgOptsList);
    }

    /**
     * 判断组织名获取组织代码是否重复
     */
    @PostMapping(value = "checkExist")
    public RespResult<CheckResult> checkOrgExist(SysOrg org) {
        CheckResult checkRes = new CheckResult(false, "");
        boolean needCheckCode = !StringUtils.isEmpty(org.getOrgCode());
        boolean needCheckName = !StringUtils.isEmpty(org.getOrgName());
        boolean needCheckSortNo = null != org.getSortNo() && org.getSortNo() > 0;
        LambdaQueryWrapper<SysOrg> wrapper = new LambdaQueryWrapper<>();
        if (null == org.getId()) {
            if (needCheckCode) {
                wrapper.eq(SysOrg::getOrgCode, org.getOrgCode());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "部门代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysOrg::getOrgName, org.getOrgName());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "部门名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysOrg::getSortNo, org.getSortNo())
                        .eq(SysOrg::getpId, org.getpId());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        } else {
            if (needCheckCode) {
                wrapper.eq(SysOrg::getOrgCode, org.getOrgCode())
                        .ne(SysOrg::getId, org.getId());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "部门代码重复");
                }
                wrapper.clear();
            }
            if (needCheckName) {
                wrapper.eq(SysOrg::getOrgName, org.getOrgName())
                        .ne(SysOrg::getId, org.getId());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "部门名称重复");
                }
                wrapper.clear();
            }
            if (needCheckSortNo) {
                wrapper.eq(SysOrg::getSortNo, org.getSortNo())
                        .eq(SysOrg::getpId, org.getpId())
                        .ne(SysOrg::getId, org.getId());
                int count = orgService.count(wrapper);
                if (count > 0) {
                    checkRes = new CheckResult(true, "排序号重复");
                }
                wrapper.clear();
            }
        }
        return RespResult.success(checkRes);
    }

    /**
     * 部门组织新增
     */
    @PostMapping(value = "orgAddData")
    public RespResult<String> orgAddData(@RequestBody @Validated({AddGroup.class}) SysOrg org,
                                         HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(org).getData();
        if (existResult.getOk()) {
            return RespResult.success(existResult.getMsg());
        }

        //2.填充权限码
        Integer pId = org.getpId();
        if (pId == 0) {
            org.setScopeKey("1");
        } else {
            SysOrg pOrg = orgMapper.selectById(pId);
            if (null != pOrg) {
                org.setScopeKey(pOrg.getScopeKey());
            }
        }

        //2.添加创建人和更新人
        org.setCreatorId(userid);
        org.setCreatorName(nickname);
        org.setUpdaterId(userid);
        org.setUpdaterName(nickname);

        orgService.save(org);
        optsData(true);
        return RespResult.success();
    }

    /**
     * 部门组织删除
     */
    @DeleteMapping(value = "orgDeleteData")
    public RespResult<String> orgDeleteData(@RequestBody List<Integer> ids,
                                            @RequestParam("remark") String remark,
                                            HttpServletRequest request) {
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        LambdaUpdateWrapper<SysOrg> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(SysOrg::getOrgRemark, nickname.concat("(删除): ").concat(remark))
                .in(SysOrg::getId, ids);
        orgService.update(updateWrapper);
        int effectRows = orgMapper.deleteBatchIds(ids);
        if (effectRows > 0) {
            optsData(true);
        }
        return RespResult.success();
    }

    /**
     * 部门组织修改
     */
    @PutMapping(value = "orgUpdateData")
    public RespResult<String> orgUpdateData(@RequestBody @Validated({UpdateGroup.class}) SysOrg org,
                                            HttpServletRequest request) {
        Long userid = Long.valueOf(request.getParameter(BaseConstant.USER_ID));
        String nickname = request.getParameter(BaseConstant.USER_NICKNAME);

        //1.校验是否重复
        CheckResult existResult = checkOrgExist(org).getData();
        if (existResult.getOk()) {
            return RespResult.success(existResult.getMsg());
        }

        //2.填充权限码
        SysOrg oldOrg = orgMapper.selectById(org.getId());
        Integer pId = org.getpId();
        if (!oldOrg.getpId().equals(org.getpId())) {
            if (pId == 0) {
                org.setScopeKey("1");
            } else {
                SysOrg pOrg = orgMapper.selectById(pId);
                if (null != pOrg) {
                    org.setScopeKey(pOrg.getScopeKey());
                }
            }
        }

        //3.添加更新人
        org.setUpdaterId(userid);
        org.setUpdaterName(nickname);
        org.setVersion(oldOrg.getVersion());

        int effectRows = orgMapper.updateById(org);
        if (effectRows > 0) {
            optsData(true);
        }
        return RespResult.success();
    }

    /**
     * 获取部门组织列表数据
     */
    @PostMapping(value = "orgPageData")
    public RespResult<Page<SysOrg>> orgPageData(@RequestBody OrgParam param) {
        Page<SysOrg> orgPage = new Page<>(param.getCurrent(), param.getSize());
        LambdaQueryWrapper<SysOrg> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isBlank(param.getOrgCode()), SysOrg::getOrgCode, param.getOrgCode());
        wrapper.like(!StringUtils.isBlank(param.getOrgName()), SysOrg::getOrgName, param.getOrgName());
        if (null != param.getOrgStatus()) {
            wrapper.eq(param.getOrgStatus().size() == 1, SysOrg::getOrgStatus, param.getOrgStatus().get(0));
            wrapper.in(param.getOrgStatus().size() > 1, SysOrg::getOrgStatus, param.getOrgStatus());
        }
        wrapper.in(null != param.getPidCascade(), SysOrg::getpId, param.getPidCascade());
        wrapper.ge(null != param.getCreateTimeStart(), SysOrg::getCreateTime, param.getCreateTimeStart());
        wrapper.lt(null != param.getCreateTimeEnd(), SysOrg::getCreateTime, param.getCreateTimeEnd());
        if (!StringUtils.isBlank(param.getOrgNames())) {
            String[] splitRes = param.getOrgNames().split(" ");
            wrapper.in(SysOrg::getOrgName, Arrays.asList(splitRes));
        }
        wrapper.orderByDesc(SysOrg::getCreateTime);
        return RespResult.success(orgService.page(orgPage, wrapper));
    }

    /**
     * 递归获取部门组织选项
     */
    private void orgChildren(List<OrgOptsDTO> data) {
        for (OrgOptsDTO datum : data) {
            List<OrgOptsDTO> children = orgMapper.orgOptsData(datum.getValue());
            if (null == children || children.size() == 0) {
                datum.setChildren(new ArrayList<>());
            } else {
                orgChildren(children);
                datum.setChildren(children);
            }
        }
    }

}
