package top.marken.test.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author makun
 * @project test001
 * @description 日期处理学习，启动类
 * @date 2022/08/16 11:22:59
 * version 1.0
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime future = LocalDateTime.of(2022,9,3,18,30);
        Duration duration = Duration.between(time,future);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:SSS");
        String timeStr = dtf.format(time);
        String futureStr = dtf.format(future);

        System.out.println(timeStr);
        System.out.println(futureStr);

        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }
}
