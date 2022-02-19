package OftenClass;

/*
     String replace(char oldChar, char newChar)：返回一個新的字符串，它是通過用 newChar 替換此字符串中出現的所有 oldChar 得到的。
     String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替換序列替換此字符串所有匹配字面值目標序列的子字符串。
     String replaceAll(String regex, String replacement) ： 使用給定的replacement 替換此字符串所有匹配給定的正則表達式的子字符串。
     String replaceFirst(String regex, String replacement) ： 使用給定的replacement 替換此字符串匹配給定的正則表達式的第一個子字符串。
     boolean matches(String regex)：告知此字符串是否匹配給定的正則表達式。
     String[] split(String regex)：根據給定正則表達式的匹配拆分此字符串。
     String[] split(String regex, int limit)：根據匹配給定的正則表達式來拆分此字符串，最多不超過limit個，如果超過了，剩下的全部都放到最後一個元素中。

 */

import org.junit.Test;

public class StringMethods3 {

    @Test
    public void StringTest5(){
        String str1 = "那壺不開提那壺";
        //返回一個新的字符串，它是通過用 newChar 替換此字符串中出現的所有 oldChar 得到的。
        String s1 = str1.replace("壺","盧");
        System.out.println(str1);
        System.out.println(s1);

        System.out.println("******************************");

        String str2 = "12Hello34World";
        //使用給定的replacement 替換此字符串所有匹配給定的正則表達式的子字符串。
        String s2 = str2.replaceAll("\\d",",");
        System.out.println(s2);

        System.out.println("******************************");

        String str3 = "12345";
        //告知此字符串是否匹配給定的正則表達式。
        boolean m1 = str3.matches("\\d+");
        System.out.println(m1);
        String tel = "0928123123";
        //判斷是否為台灣手機
        boolean m2 = tel.matches("09\\d{8}");
        System.out.println(m2);

        System.out.println("******************************");

        String str4 = "you just have to say that you're fine but you're not really fine";
        //根據給定正則表達式的匹配拆分此字符串。
        String[] strArray = str4.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }
}
