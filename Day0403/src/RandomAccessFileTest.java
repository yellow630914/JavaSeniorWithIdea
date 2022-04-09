/*
    RandomAccessFile的使用:
    1.直接繼承於,java.lang.Object類,實現DataInput和DataOutput接口
    2.可作為一個輸入流也可作為一個輸出流
    3.如果寫出的文件存在,則由開頭逐Byte覆蓋;若不存在則創建文件

 */

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {

    /*
        r: 以只读方式打开
        rw：打开以便读取和写入
        rwd:打开以便读取和写入；同步文件内容的更新
        rws:打开以便读取和写入；同步文件内容和元数据的更新

     */

    @Test
    public void test() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            //1.create stream
            randomAccessFile1 = new RandomAccessFile(new File("surtr.jpg"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("muchSurtr.jpg"),"rw");
            //2.read and write
            byte[] buffer = new byte[64];
            int len;
            while ((len = randomAccessFile1.read(buffer)) != -1){
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.close
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile randomAccessFile1 = new RandomAccessFile("hello.txt","rw");


        randomAccessFile1.seek(4);//將指針指向4的位置
        randomAccessFile1.write("hello world".getBytes(StandardCharsets.UTF_8));

        randomAccessFile1.close();
    }

}
