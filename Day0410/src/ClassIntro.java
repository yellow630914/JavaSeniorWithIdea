/*
關於java.lang.Class的理解
    1.類的加載過程:
        程序經過javac.exe命令後,會產生一個或多個字節碼文件(.class結尾)
        接著我們使用java.exe命令對某個字節碼文件解釋運行。相當於將字節碼文件加載到內存中。
        此過程被稱為類的加載。加載到內存的類,我們稱之為運行時類,作為Class的一個實例。
    2.換句話說,Class的實例就對應著一個運行時類。
    3.加載到內存的運行時類,會緩存一段時間。在此時間內,我們可以通過不同方式來獲取此運行時類。

    哪些类型可以有Class对象？
    （1）class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
    （2）interface：接口
    （3）[]：数组
    （4）enum：枚举
    （5）annotation：注解@interface
    （6）primitive type：基本数据类型
    （7）void
 */

import org.junit.Test;

import java.lang.annotation.ElementType;

public class ClassIntro {
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一： 調用運行時類的屬性: .class
        Class <Person>clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二: 通過運行時類的對象,調用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三: Class的靜態方法: forName(String classPath)
        Class clazz3 = Class.forName("Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        //方式四: 使用類的加載器
        ClassLoader classLoader = ReflectionIntro.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("Person");
        System.out.println(clazz4);
    }

    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
