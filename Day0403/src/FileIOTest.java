import org.junit.Test;

import java.io.*;


public class FileIOTest {
    /*
        將day0403下的hello.txt讀入,並輸出到控制台

        1.read():返回一個字符。如果達到末尾,返回-1
        2.異常處理:為保證流一定可以進行關閉操作。需使用try-catch-finally處理
        3.讀入文件必須存在,否則會報FileNotFoundException。
     */

    @Test
    public void testRead1() {
        FileReader fileReader = null;
        try {
            //1.實例化File類的物件
            File file = new File("hello.txt");//當前Module
            //2.提供具體的流
            fileReader = new FileReader(file);

            //3.數據的讀入
            //read():返回一個字符。如果達到末尾,返回-1
            int data = fileReader.read();
            while (data != -1){
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    //4.流的關閉
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read()操作升級:使用read重載方法
    @Test
    public void testRead2(){
        FileReader fileReader = null;
        try {
            //1.實例化File類的物件
            File file = new File("hello.txt");//當前Module
            //2.提供具體的流
            fileReader = new FileReader(file);
            //3.數據的讀入
            char[] fileChar = new char[5];
            int len;
            while ((len = fileReader.read(fileChar)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(fileChar[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    //4.流的關閉
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    從內存寫出數據倒硬盤中的文件

    1.如果不存在:在輸出過程中會創建文件
      如果存在:FileWriter(file,false)/FileWriter(file)構造器的流:會覆蓋文件。
              FileWriter(file,true)構造器的流:會在原有文件基礎上追加內容。

     */
    @Test
    public void testWrite(){
        FileWriter fileWriter = null;
        try {
            //1.實例化File類的物件
            File file = new File("hello1.txt");//當前Module
            //2.提供具體的流
            fileWriter = new FileWriter(file);

            //3.寫出操作
            fileWriter.write("I write here!\n");
            fileWriter.write("I create here!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    //4.流的關閉
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testReadAndWrite(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //1.實例化File類的物件
            File srcFile = new File("hello.txt");
            File targetFile = new File("hello1.txt");

            //2.提供具體的流
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(targetFile);

            //3.讀入與寫出操作
            char[] fileChar = new char[5];
            int len;
            while ((len = fileReader.read(fileChar)) != -1){
                fileWriter.write(fileChar,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的關閉
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
