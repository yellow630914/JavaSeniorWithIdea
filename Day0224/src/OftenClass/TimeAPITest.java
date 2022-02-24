package OftenClass;

/*


 */

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class TimeAPITest {

//    LocalDate,LocalTime,LocalDateTime的使用
    @Test
    public void LocalTest(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate: " + localDate);
        System.out.println("localTime: " + localTime);
        System.out.println("localDateTime: " + localDateTime);

        //of():設定指定時間。沒有偏移。
        LocalDateTime localDateTime1 = LocalDateTime.of(2077,10,30,11,55,23);
        System.out.println("用of()設定: " + localDateTime1);

        //getXXX():取得特定數值
        System.out.println("用get取得: " + localDateTime.getDayOfMonth());

        //withXXX():返回一個新的時間
        System.out.println("withXXX()的示範: ");
        LocalDate localDate1 = localDate.withDayOfMonth(28);
        System.out.println(localDate);
        System.out.println(localDate1);

        //plusXXX
        System.out.println("plusXXX()的示範: ");
        LocalTime localTime1 = localTime.plusHours(3);
        System.out.println(localTime);
        System.out.println(localTime1);
    }

    /*
        Instant：時間線上的一個瞬時點。這可能被用來記錄應用程序中的事件時間戳。
    */

    @Test
    public void InstantTest(){
        //GMT:+00:00
        Instant instant = Instant.now();
        System.out.println(instant);//2022-02-24T18:01:21.349887500Z

        //用OffsetDateTime偏移至GMT:+08:00
        OffsetDateTime GMT8Instant = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(GMT8Instant);

        //totoEpochMilli()取得自1970/01/01 00:00:00開始後的毫秒數  ---> Date類的getInstant()
        long milli = instant.toEpochMilli();
        System.out.println(milli);
    }
    /*
        java.time.format.DateTimeFormatter 類：該類提供了三種格式化方法： 類似simpleDateFormat
     */

    @Test
    public void DateTimeFormatterTest(){
        //此類定義了三種標準格式:
        //ISO_LOCAL_DATE_TIME
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化: 日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter1.format(localDateTime);
        System.out.println(localDateTime); //2022-02-25T02:19:49.305647800
        System.out.println(str1); //2022-02-25T02:19:49.3056478

        //解析: 字符串 --> 日期
        formatter1.parse(str1);
        TemporalAccessor TempTime = formatter1.parse("2077-02-25T02:16:53.7381606");
        System.out.println(TempTime); //{},ISO resolved to 2077-02-25T02:16:53.738160600



        //ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter2.format(LocalDateTime.now());
        System.out.println(str2);  //2022年2月25日 上午2:19:49




        //自定義的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str3 = formatter3.format(LocalDateTime.now());
        System.out.println(str3); //2022-02-25 02:25:35
        //解析
        TemporalAccessor accessor = formatter3.parse("2077-02-09 05:23:25");
        System.out.println(accessor);


    }

}
