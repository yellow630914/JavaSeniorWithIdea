/*
    轉換流:
        转换流提供了在字节流和字符流之间的转换
        Java API提供了两个转换流：
             InputStreamReader：将InputStream转换为Reader
             OutputStreamWriter：将Writer转换为OutputStream
         字节流中的数据都是字符时，转成字符流操作更高效。
         很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能。

 */

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {

    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("Necronomicon.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

        char[] cbuf = new char[16];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.println(str);

        }

        isr.close();
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis1 = new FileInputStream("Necronomicon.txt");
        FileOutputStream fis2 = new FileOutputStream("NecronomiconISO.txt");

        InputStreamReader isr = new InputStreamReader(fis1,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fis2,"ISO8859-15");

        char[] cbuf = new char[16];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        isr.close();
        osw.close();
    }
}
