package OftenClass;

/*
     int length()：返回字符串的長度： return value.length
     char charAt(int index)： 返回某索引處的字符return value[index]
     boolean isEmpty()：判斷是否是空字符串：return value.length == 0
     String toLowerCase()：使用默認語言環境，將 String 中的所有字符轉換為小寫
     String toUpperCase()：使用默認語言環境，將 String 中的所有字符轉換為大寫
     String trim()：返回字符串的副本，忽略前導空白和尾部空白
     boolean equals(Object obj)：比較字符串的內容是否相同
     boolean equalsIgnoreCase(String anotherString)：與equals方法類似，忽略大小寫
     String concat(String str)：將指定字符串連接到此字符串的結尾。等價於用“+”
     int compareTo(String anotherString)：比較兩個字符串的大小
     String substring(int beginIndex)：返回一個新的字符串，它是此字符串的從beginIndex開始截取到最後的一個子字符串。
     String substring(int beginIndex, int endIndex) ：返回一個新字符串，它是此字符串從beginIndex開始截取到endIndex(不包含)的一個子字符串。

 */

import org.junit.Test;


public class StringMethods1 {
    @Test
    public void StringTest1(){
        String s1 = "HelloWorld";
        //返回字符串的長度
        System.out.println(s1.length());
        //返回某索引處的字符
        System.out.println(s1.charAt(0));
        //判斷是否是空字符串
        System.out.println(s1.isEmpty());
        //使用默認語言環境，將 String 中的所有字符轉換為小寫
        System.out.println(s1.toLowerCase());
        //使用默認語言環境，將 String 中的所有字符轉換為大寫
        System.out.println(s1.toUpperCase());

        String s3 = "  Hel  lo  W or ld  ";
        String s3AfterTrim = s3.trim();
        //返回字符串的副本，忽略前導空白和尾部空白
        System.out.println(s3AfterTrim);
    }

    @Test
    public void StringTest2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        //比較字符串的內容是否相同
        System.out.println(s1.equals(s2));
        //與equals方法類似，忽略大小寫
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "123";
        String s4 = "456";
        //指定字符串連接到此字符串的結尾。等價於用“+”
        System.out.println(s3.concat(s4));

        String s5 = "abc";
        String s6 = "abe";
        //比較兩個字符串的大小
        System.out.println(s5.compareTo(s6));

        //返回一個新的字符串，它是此字符串的從beginIndex開始截取到最後的一個子字符串。
        String s7 = "ThisIsTandoMaya";
        String s8 = s7.substring(6);
        System.out.println(s8);
        //返回一個新字符串，它是此字符串從beginIndex開始截取到endIndex(不包含)的一個子字符串。
        String s9 = s7.substring(6,11);
        System.out.println(s9);

    }
}
