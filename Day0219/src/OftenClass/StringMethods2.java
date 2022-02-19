package OftenClass;

/*
     boolean endsWith(String suffix)：測試此字符串是否以指定的後綴結束
     boolean startsWith(String prefix)：測試此字符串是否以指定的前綴開始
     boolean startsWith(String prefix, int toffset)：測試此字符串從指定索引開始的子字符串是否以指定前綴開始
     boolean contains(CharSequence s)：當且僅當此字符串包含指定的 char 值序列時，返回 true
     int indexOf(String str)：返回指定子字符串在此字符串中第一次出現處的索引
     int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出現處的索引，從指定的索引開始
     int lastIndexOf(String str)：返回指定子字符串在此字符串中最右邊出現處的索引
     int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最後一次出現處的索引，從指定的索引開始反向搜索
    注：indexOf和lastIndexOf方法如果未找到都是返回-1
 */

import org.junit.Test;

public class StringMethods2 {
    @Test
    public void StringTest3(){
        String s1 = "helloworld";
        //測試此字符串是否以指定的後綴結束
        boolean b1 = s1.endsWith("rld");
        System.out.println(b1);

        //測試此字符串是否以指定的前綴開始
        boolean b2 = s1.startsWith("He");
        System.out.println(b2);

        //測試此字符串從指定索引開始的子字符串是否以指定前綴開始
        boolean b3 = s1.startsWith("llo",2);
        System.out.println(b3);

        //當且僅當此字符串包含指定的 char 值序列時，返回 true
        boolean b4 = s1.contains("lo"); //kmp
        System.out.println(b4);
    }
    @Test
    public void StringTest4(){
        String s1 = "IAmIdiot";

        //返回指定子字符串在此字符串中第一次出現處的索引
        int i1 = s1.indexOf("I");
        System.out.println(i1);

        //返回指定子字符串在此字符串中第一次出現處的索引，從指定的索引開始
        int i2 = s1.indexOf("I",1);
        System.out.println(i2);

        //返回指定子字符串在此字符串中最右邊出現處的索引
        int i3 = s1.lastIndexOf("I");
        System.out.println(i3);

        //返回指定子字符串在此字符串中最後一次出現處的索引，從指定的索引開始反向搜索
        int i4 = s1.lastIndexOf("I",2);
        System.out.println(i4);
    }


}

