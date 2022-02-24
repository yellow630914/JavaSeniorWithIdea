package OftenClass;

/*
    Java的比較器:
        在Java中物件與物件之間只能用==或!=比較,但實際上我們有物件之間的排序需求,
        此時我們就會用到Comparable與Comparator兩個接口。

    一, Comparable接口
        1.像String、包裝類等實現了Comparable接口,重寫了compareTo()方法,給出比較兩個物件的規則。
        2.重寫compareTo(obj)的規則:
            如當前物件this大於型參物件obj,則返回正整數。
            如當前物件this小於型參物件obj,則返回負整數。
            如當前物件this等於型參物件obj,則返回零。
        3.對於自訂義類來說,如果需要排序我們可以使用Comparable接口,重寫compareTo()

    二, Comparator接口
        1.當元素的類型沒有實現java.lang.Comparable接口而又不方便修改代碼，
        或者實現了java.lang.Comparable接口的排序規則不適合當前的操作，那
        麼可以考慮使用 Comparator 的對象來排序。
        2.重寫compare(Object o1,Object o2)方法，比較o1和o2的大小：如果方法返
        回正整數，則表示o1大於o2；如果返回0，表示相等；返回負整數，表示o1小於o2。


 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

    /*
        方式一：自然排序：java.lang.Comparable
            Comparable 的典型實現：(默認都是從小到大排列的)
                String：按照字符串中字符的Unicode值進行比較
                Character：按照字符的Unicode值來進行比較
                數值類型對應的包裝類以及BigInteger、BigDecimal：按照它們對應的數值大小進行比較
                Boolean：true 對應的包裝類實例大於 false 對應的包裝類實例
                Date、Time等：後面的日期時間比前面的日期時間大
     */

    @Test
    public void ComparableTest(){
        String[] arr = new String[]{"CC","BB","ZZ","FF","WW","AA"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    //排序自訂義物件
    @Test
    public void ComparableTestGoods(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("Realme GT NEO2",10000);
        arr[1] = new Goods("iPhone15",30000);
        arr[2] = new Goods("ROG PHONE5",40000);
        arr[3] = new Goods("Mi K40",12000);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
        方式二：定制排序：java.util.Comparator
             當元素的類型沒有實現java.lang.Comparable接口而又不方便修改代碼，
            或者實現了java.lang.Comparable接口的排序規則不適合當前的操作，那
            麼可以考慮使用 Comparator 的對象來排序，強行對多個對象進行整體排
            序的比較。
             重寫compare(Object o1,Object o2)方法，比較o1和o2的大小：如果方法返
            回正整數，則表示o1大於o2；如果返回0，表示相等；返回負整數，表示
            o1小於o2。
             可以將 Comparator 傳遞給 sort 方法（如 Collections.sort 或 Arrays.sort），
            從而允許在排序順序上實現精確控制。
             還可以使用 Comparator 來控制某些數據結構（如有序 set或有序映射）的
            順序，或者為那些沒有自然順序的對象 collection 提供排序。

     */
    @Test
    public void ComparatorTest(){
        String[] arr = new String[]{"CC","BB","ZZ","FF","WW","AA"};
        Arrays.sort(arr,new Comparator(){

            //從大到小
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }else {
                    throw new RuntimeException("傳入的數據類型不一致");
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void ComparatorTestGoods(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("Realme GT NEO2",10000);
        arr[1] = new Goods("iPhone15",30000);
        arr[2] = new Goods("ROG PHONE5",40000);
        arr[3] = new Goods("Mi K40",12000);

        Arrays.sort(arr,new Comparator(){
            //改用名稱排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods goods1 = (Goods)o1;
                    Goods goods2 = (Goods)o2;
                    return goods1.getName().compareTo(goods2.getName());
                }else{
                    throw new RuntimeException("傳入的數據類型不一致");
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}

class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //規定兩物件比較規則
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            //按照價格排序
            Goods goods = (Goods)o;
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
                return 0;
            }
        }else{
            throw new RuntimeException("傳入的數據類型不一致");
        }
    }
}
