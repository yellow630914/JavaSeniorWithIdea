package OftenClass;



import org.junit.Test;

public class StringIntro {
/*
    String的使用:
        String字符串,使用一對""來表示
        1.String聲明為final,不可被繼承。
        2.String實現Serializable接口,表示字符串是支持序列化的。
                實現Comparable接口,表示String可以比較大小。
        3.String內部定義了final char[] value用於儲存字符串。
        4.String:代表不可變的字符序列。簡稱不可變性。
            體現:1.當字符串重新賦值時,需要在常量池中新建一個value,無法在原有value去改變。
                2.當對現有字符串進行連接時也需要重新新建一個value,無法在原有value去改變。
                3.當String的replace()方法修改字符或字符串時,也必須重新新建一個value,無法在原有value去改變。
        5.通過字面量的方式(區別於new)給一個字符串賦值,此時的字符串值聲明在翅蝠串常量池中。
        6.字符串常量池中是不會存儲相同內容的字符串的。

*/

    @Test
    public void unChangeble(){
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);

        s1 = "hello";

        System.out.println(s1 == s2);

        System.out.println("**********************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println(s2);

        System.out.println("**********************");



    }

    /*
    String的實例化方式
       方式一:通過字面意義上定義
       方式二:透過new + 構造器定義

     */

    @Test
    public void instanceOfString(){
        //s1與s2聲明在方法區的字符串常量池
        String s1 = "java";
        String s2 = "java";

        //s3與s4聲明在堆空間中,後指向常量池。
        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
    }




}
