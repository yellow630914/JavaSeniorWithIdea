
/*
    其他流的應用:
        1.標準流輸入、輸出流
        2.打印流
        3.數據流

 */

import org.junit.Test;

import java.io.*;
import java.util.Locale;

public class OtherIOTest {

    /*

    1.標準流輸入、輸出流
         System.in和System.out分别代表了系统标准的输入和输出设备
         默认输入设备是：键盘，输出设备是：显示器
         System.in的类型是InputStream
         System.out的类型是PrintStream，其是OutputStream的子类FilterOutputStream 的子类
         重定向：通过System类的setIn，setOut方法对默认设备进行改变。
             public static void setIn(InputStream in)
             public static void setOut(PrintStream out)

     */

    /*
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     */
    //必須使用main才能輸入
    @Test
    public void test1() {
        System.out.println("請輸入e或exit退出:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            while ((s = br.readLine()) != null){
                if("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)){
                    System.out.println("安全退出!");
                    break;
                }

                System.out.println("-->" + s.toUpperCase());
                System.out.println("繼續輸入:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*

    2.打印流
        实现将基本数据类型的数据格式转化为字符串输出

        打印流：PrintStream和PrintWriter
             提供了一系列重载的print()和println()方法，用于多种数据类型的输出
             PrintStream和PrintWriter的输出不会抛出IOException异常
             PrintStream和PrintWriter有自动flush功能
             PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。
             System.out返回的是PrintStream的实例


     */

    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

}
