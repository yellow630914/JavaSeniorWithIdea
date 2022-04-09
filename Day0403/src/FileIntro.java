/*
    File類的使用:
        File類中的一個物件即是一個文件或資料夾
        File類聲明在java.io下
        File類涉及到文件與資料夾的創建、刪除、重命名、修改時間、文件大小。
         並未涉及到文件的讀取與寫入,如需要則必須使用IO流來完成
        後續File類的物件常作為參數傳到IO流的構造器當中。


 */


import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileIntro {
    /*
        創建File物件:
          構造器: public File(String pathname)
                以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果
                pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
                     绝对路径：是一个固定的路径,从盘符开始
                     相对路径：是相对于某个位置开始
                 public File(String parent,String child)
                以parent为父路径，child为子路径创建File对象。
                 public File(File parent,String child)
                根据一个父File对象和子文件路径创建File对象

     */
    @Test
    public void test1(){
        //相對路徑指定文件
        File file1 = new File("hello.txt");
        //絕對路徑指定文件
        File file2 = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403\\src\\hello.txt");
        System.out.println("========================相對路徑指定文件========================");
        System.out.println(file1);
        System.out.println("========================絕對路徑指定文件========================");
        System.out.println(file2);

        //指定資料夾
        System.out.println("========================指定資料夾========================");
        File file3 = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea","Day0403");
        System.out.println(file3);

        //從其他File物件指定資料夾後,指定文件。
        System.out.println("========================從其他File物件指定資料夾後,指定文件。========================");
        File file4 = new File(file3,"src\\hello.txt");
        System.out.println(file4);

    }


    /*
     File类的获取功能
         public String getAbsolutePath()：获取绝对路径
         public String getPath() ：获取路径
         public String getName() ：获取名称
         public String getParent()：获取上层文件目录路径。若无，返回null
         public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
         public long lastModified() ：获取最后一次的修改时间，毫秒值

         public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
         public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
         File类的重命名功能
         public boolean renameTo(File dest):把文件重命名为指定的文件路径

     */
    @Test
    public void test2(){
        //相對路徑指定文件
        File file1 = new File("hello.txt");
        //絕對路徑指定文件
        File file2 = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403\\src\\hi.txt");

        //當文件存在時(相對路徑)
        System.out.println("========================當文件存在時(相對路徑)========================");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        //當文件不存在時(絕對路徑)
        System.out.println("========================當文件不存在時(絕對路徑)========================");
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3(){
        File file1 = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403");

        String[] fileList = file1.list();

        //遍歷資料夾下所有文件與資料夾
        System.out.println("========================遍歷資料夾下所有文件與資料夾========================");
        for (String str:
             fileList) {
            System.out.println(str);
        }

        File[] files = file1.listFiles();

        System.out.println("========================遍歷資料夾下所有文件與資料夾========================");
        for (File file:
                files) {
            System.out.println(file);
        }
    }
    /*
     File类的判断功能
         public boolean isDirectory()：判断是否是文件目录
         public boolean isFile() ：判断是否是文件
         public boolean exists() ：判断是否存在
         public boolean canRead() ：判断是否可读
         public boolean canWrite() ：判断是否可写
         public boolean isHidden() ：判断是否隐藏

     */
    @Test
    public void test4(){
        File file = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403\\hello.txt");
        File folder = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403");

        System.out.println("========================判断是否是文件目录========================");
        System.out.println(file.isDirectory());
        System.out.println("========================判断是否是文件========================");
        System.out.println(file.isFile());
        System.out.println("========================判断是否存在========================");
        System.out.println(file.exists());
        System.out.println("========================判断是否可读========================");
        System.out.println(file.canRead());
        System.out.println("========================判断是否可写========================");
        System.out.println(file.canWrite());
        System.out.println("========================判断是否隐藏========================");
        System.out.println(file.isHidden());

        System.out.println("\n\n\n");

        System.out.println("========================判断是否是文件目录========================");
        System.out.println(folder.isDirectory());
        System.out.println("========================判断是否是文件========================");
        System.out.println(folder.isFile());
        System.out.println("========================判断是否存在========================");
        System.out.println(folder.exists());
        System.out.println("========================判断是否可读========================");
        System.out.println(folder.canRead());
        System.out.println("========================判断是否可写========================");
        System.out.println(folder.canWrite());
        System.out.println("========================判断是否隐藏========================");
        System.out.println(folder.isHidden());

    }

    /*
     File类的创建功能
         public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
         public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
        如果此文件目录的上层目录不存在，也不创建。
         public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
            注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
            路径下。

      File类的删除功能
         public boolean delete()：删除文件或者文件夹
            删除注意事项：
            Java中的删除不走回收站。
            要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录

     */
    @Test
    public void test5() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("創建成功!");
        }else{
            file1.delete();
            System.out.println("刪除成功!");
        }
    }

    @Test
    public void test6() throws IOException {
        File folder = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403\\test");
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("創建成功!");
        }else{
            folder.delete();
            System.out.println("刪除成功!");
        }
    }

    @Test
    public void test7() throws IOException {
        File folder = new File("C:\\Users\\NF\\Documents\\GitHub\\JavaSeniorWithIdea\\Day0403\\test\\inTest");
        if(!folder.exists()){
            folder.mkdirs();
            System.out.println("創建成功!");
        }else{
            folder.delete();
            System.out.println("刪除成功!");
        }
    }
}
