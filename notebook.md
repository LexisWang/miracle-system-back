##### 1.时间转为时间戳
```text
LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
```
##### 2.Mysql中整型转为datetime类型
```mysql
SELECT FROM_UNIXTIME(ROUND(create_time / 1000)) FROM sys_org WHERE id = 1;
```