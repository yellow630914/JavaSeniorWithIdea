package OftenClass;


/*
    3. java.text.SimpleDateFormat類

     Date類的API不易於國際化，大部分被廢棄了，java.text.SimpleDateFormat類是一個不與語言環境有關的方式來格式化和解析日期的具體類。
     它允許進行格式化：日期文本、解析：文本日期

 */

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    /*
        -兩個操作:
             格式化：
                 SimpleDateFormat() ：默認的模式和語言環境創建對象
                 public SimpleDateFormat(String pattern)：該構造方法可以用參數pattern指定的格式創建一個對象，該對象調用：
                 public String format(Date date)：方法格式化時間對象date
             解析：
                 public Date parse(String source)：從給定字符串的開始解析文本，以生成一個日期。
         */
    @Test
    public void testSimpleDateFormat(){
        //實例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化: 日期 ---> 字串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析: 格式化的逆過程,字串 ----> 日期
        String str = "2077/1/01 上午2:06";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //********************
        System.out.println("********************");
        //可以自訂義格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        //格式化
        String format1 = sdf.format(date);
        System.out.println(format1);
        //解析
        try {
            Date date2 = sdf.parse("2077/2/08 上午11:55");
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
