import org.junit.Test;

import java.io.*;

/*

    1.對於文本文件(.txt,.java,.c,.cpp),使用字符流處理。
    2.對於非文本文件(.jpg,.mp3,.mp4,.doc,.ppt),使用字節流處理。

 */

public class FileIOStreamTest {
    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        try {
            //1.實例化File類的物件
            File file = new File("hello.txt");//當前Module
            //2.提供具體的流
            fileInputStream = new FileInputStream(file);
            //3.讀數據
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的關閉
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.實例化File類的物件
            File file = new File("surtr.jpg");
            File target = new File("morOneSurtr.jpg");
            //2.提供具體的流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(target);
            //3.讀數據
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的關閉
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //4.流的關閉
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String srcPath,String targetPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.實例化File類的物件
            File file = new File(srcPath);
            File target = new File(targetPath);
            //2.提供具體的流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(target);
            //3.讀數據
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的關閉
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //4.流的關閉
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopy(){
        long start = System.currentTimeMillis();

        String src = "surtr.jpg";
        String target = "morOneSurtr.jpg";
        copyFile(src,target);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
