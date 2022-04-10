import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderIntro {
    @Test
    public void test1(){
        //自訂義類,使用系統加載器
        ClassLoader classLoader1 = ClassIntro.class.getClassLoader();
        System.out.println(classLoader1);
        //系統類加載器的getParent():擴展類加載器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        //調用擴展類加載器的getParent():無法獲取引導類加載器
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);

        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader4);

    }
    /*
    Properties: 用於讀取配置文件

     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("pros.properties");
        pros.load(fis);

//        ClassLoader classLoader = ClassIntro.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("Day0410\\pros.properties");
//        pros.load(is);

        String user = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("user:" + user + ",password:" + password);
    }
}
