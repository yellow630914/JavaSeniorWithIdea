package OftenClass;

/*
    關於StringBuffer與StringBuilder的使用

 */

import org.junit.Test;

public class StringBufferAndStringBuilder {
    /*
    StringBuffer與StringBuilder的異同
    String:不可變的字符序列;底層用final char[]儲存
    StringBuffer:可變的字符序列,線程安全的,效率低;底層用char[]儲存
    StringBuilder:可變的字符序列,線程不安全的,效率高;底層用char[]儲存

    源碼分析:
    String str = new String();//new char[0];
    String str1 = new String("abc");//new char[]{'a','b','c'}

    StringBuffer sb = new StringBuffer();//new char[16];
    System.out.println(sb.length())  //out: 0   //StringBuffer只會返回非null的長度
    sb.append('a');//value[0] = 'a';
    sb.append{'b'};//value[1] = 'b';

    StringBuffer sb1 = new StringBuffer("abc");//new char[] value = new char["abc".length() + 16]

     */

    @Test
    public void StringBufferTest(){
        String str1 = "abc";
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');

        System.out.println("StringBuffer:" + sb1);
    }
    @Test
    public void Cross2(){
        int i = 53;
        System.out.println(i << 2);
    }

    /*
    StringBuffer append(xxx)：提供了很多的append()方法，用於進行字符串拼接
    StringBuffer delete(int start,int end)：刪除指定位置的內容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替換為str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把當前字符序列逆轉
    public int indexOf(String str)
    public String substring(int start,int end)
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char ch)
     */

    @Test
    public void StringBufferMethods(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        System.out.println(s1);
        s1.insert(2,false); //
        s1.reverse(); //11ceslafba
        System.out.println(s1);
        System.out.println(s1.length());
    }
    /*
    String與StringBuffer與StringBuilder的效率比較:
    從高到低:StringBuilder > StringBuffer >>>>>>>>>>>>>>>>>> String

     */
    @Test
    public void StringStringBufferStringBuilder(){
        long start = 0L;
        long end = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //開始比對
        start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer的執行時間: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder的執行時間: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text += i;
        }
        end = System.currentTimeMillis();
        System.out.println("String的執行時間: " + (end - start));
    }


}
