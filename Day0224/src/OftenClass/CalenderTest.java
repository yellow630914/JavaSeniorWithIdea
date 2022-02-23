package OftenClass;

/*
    4. java.util.Calendar(日曆)類
     Calendar是一個抽象基類，主用用於完成日期字段之間相互操作的功能。
     獲取Calendar實例的方法
         使用Calendar.getInstance()方法  (常用)
         調用它的子類GregorianCalendar的構造器。

 */

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {
    @Test
    public void testCalendar(){
        //1.實例化
        Calendar calendar = Calendar.getInstance();
        //2.常用方法

        //get()
        System.out.println("這個月的第X天: " + calendar.get(Calendar.DAY_OF_MONTH)); //取得這個月的第X天
        System.out.println("這一周的第X天: " + calendar.get(Calendar.DAY_OF_WEEK)); //取得這一周的第X天

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,25); //設定為這個月的第X天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-1); //增加減少時間
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime():Calendar類 ---> Date類
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date類 ---> Calendar類
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(Calendar.DAY_OF_MONTH);
    }

}
