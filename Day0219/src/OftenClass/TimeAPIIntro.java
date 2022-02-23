package OftenClass;

/*
    與時間相關的JavaAPI

    1. java.lang.System類
        System類提供的public static long currentTimeMillis()用來返回當前時
        間與1970年1月1日0時0分0秒之間以毫秒為單位的時間差。
         此方法適於計算時間差。

 */

import org.junit.Test;

import java.util.Date;

public class TimeAPIIntro {
    @Test
    public void currentTimeMillisTest(){
        long time = System.currentTimeMillis();
        System.out.println("從1970年1月1日距今經過:" + time + "毫秒");
    }

    /*
    2. java.util.Date類
        表示特定的瞬間，精確到毫秒

    |---java.util.Date
           |---java.sql.Date

    1.兩個構造器的使用
        >Date():物件創建的時間。
        >Date(long ms):距1970年1月1日00:00後ms毫秒的時間。

    2.兩個方法的使用
        >toString():把此 Date 對象轉換為以下形式的 String： dow mon ddhh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)，zzz是時間標準。
        >getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以來此 Date 對象表示的毫秒數。

     */
    @Test
    public void JavaDateTest(){
        Date dateWithJava = new Date();
        System.out.println(dateWithJava.toString());

        System.out.println(dateWithJava.getTime());
    }

    /*
    SQL的時間與JAVA時間格式不一樣

    如何將sql.Date轉換成util.Date?

     */

    @Test
    public void SQLDateTest(){
        java.sql.Date dateWithSQL = new java.sql.Date(3406040316559L);
        System.out.println(dateWithSQL); //1972-01-25

        Date dateWithJava = new Date();
        System.out.println(dateWithJava);
        //sql.Date轉換成util.Date
        java.sql.Date dateWithSQL2 = new java.sql.Date(dateWithJava.getTime());

    }

}
