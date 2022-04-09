/*
    處理流的之一:
    BufferedInputStream
    BufferedOutputStream
    BufferedReader
    BufferedWriter

    此流能夠提高節點流的效率:
        此流內部提供一個緩衝區,提供數據的一個緩存,
        以此加速流的效率。

 */

import org.junit.Test;

import java.io.*;

public class BufferStreamTest {

    //使用緩衝流,複製非字符檔案
    @Test
    public void BufferedStreamTest(){
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.實例化File類的物件
            File file = new File("surtr.jpg");
            File target = new File("morOneSurtr.jpg");
            //2.提供具體的流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(target);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.讀數據
            byte[] buffer = new byte[5];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的關閉
            //要求先關閉外層的流,再關內層的流
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
            //關閉外層的流能一起關閉內層的流。
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */

        }
    }

    public void copyFileWithBuffered(String srcPath,String targetPath){
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.實例化File類的物件
            File file = new File(srcPath);
            File target = new File(targetPath);
            //2.提供具體的流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(target);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.讀數據
            byte[] buffer = new byte[5];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的關閉
            //要求先關閉外層的流,再關內層的流
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void TestSpeedBuffered(){
        long start = System.currentTimeMillis();

        String src = "surtr.jpg";
        String target = "morOneSurtr.jpg";
        copyFileWithBuffered(src,target);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
