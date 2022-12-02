##### 1.时间转为时间戳
```text
LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
```
##### 2.Mysql中整型转为datetime类型
```mysql
SELECT FROM_UNIXTIME(ROUND(create_time / 1000)) FROM sys_org WHERE id = 1;
```
##### 3.时间与时间戳的转换
```java
public class Hello {
    public static void main(String[] args) {
        long nowTimestamp = System.currentTimeMillis();
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDate nowDate = LocalDate.now();
        //1.时间戳转为`LocalDateTime`
        LocalDateTime localDateTime = Instant.ofEpochMilli(nowTimestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        //2.时间戳转为`LocalDate`
        LocalDate localDate = Instant.ofEpochMilli(nowTimestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        //3.`LocalDateTime`转为时间戳
        long timestampFromLocalDateTime = nowDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        //4.`LocalDate`转为时间戳
        long timestampFromLocalDate = nowDate.atStartOfDay().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
}
```