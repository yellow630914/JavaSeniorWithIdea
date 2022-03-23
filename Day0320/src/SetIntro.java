/*
    Set 接口概述
         Set接口是Collection的子接口，set接口没有提供额外的方法
         Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
         Set 判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法

        Set的兩大特性:
            1.無序性:不等於隨機性,存儲數據不會按照添加順序排列,而是依照hash值排列。

            2.不可重複性:檢驗是否重複時,調用的是equals()。

        二、添加元素的過程,以HashSet為例:
             当向 HashSet 集合中存入一个元素时，HashSet 会调用该对象的 hashCode() 方法
            来得到该对象的 hashCode 值，然后根据 hashCode 值，通过某种散列函数决定该对象
            在 HashSet 底层数组中的存储位置。（这个散列函数会与底层数组的长度相计算得到在
            数组中的下标，并且这种散列函数计算还尽可能保证能均匀存储元素，越是散列分布，
            该散列函数设计的越好）
             如果两个元素的hashCode()值相等，会再继续调用equals方法，如果equals方法结果
            为true，添加失败；如果为false，那么会保存该元素，但是该数组的位置已经有元素了，
            那么会通过链表的方式继续链接。
            如果两个元素的 equals() 方法返回 true，但它们的 hashCode() 返回值不相
            等，hashSet 将会把它们存储在不同的位置，但依然可以添加成功。


    HashSet:作為Set接口的主要實現類,線程不安全的,可以儲存null值。

    LinkedHashSet:作為HashSet的子類,遍歷內部數據時,可以依照添加順序遍歷。

    TreeSet:可以按照添加的對象的指定屬性,進行排序。


 */


import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SetIntro {
    @Test
    public void test1(){
        System.out.println("==================HashSet==================");

        Set set = new HashSet();
        set.add(5);
        set.add("aaa");
        set.add(false);
        set.add(new User("001",5));
        set.add("ccc");
        set.add(null);

        for (Object obj:
             set) {
            System.out.println(obj);
        }




    }


    @Test
    public void test2(){
        System.out.println("==================LinkedHashSet==================");


        Set set = new LinkedHashSet();
        set.add(5);
        set.add("aaa");
        set.add(false);
        set.add(new User("001",5));
        set.add("ccc");
        set.add(null);

        for (Object obj:
                set) {
            System.out.println(obj);
        }


    }


}


class User implements Comparable{
    String ID;
    int point;

    public User(String ID, int point) {
        this.ID = ID;
        this.point = point;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return point == user.point && Objects.equals(ID, user.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, point);
    }

    @Override
    public String toString() {
        return "User:"+ this.hashCode() + "{" +
                "ID='" + ID + '\'' +
                ", point=" + point +
                '}';
    }


    //依照ID排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            int compare = this.ID.compareTo(user.ID);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.point,user.point);
            }
        }else{
            throw new RuntimeException("輸入類型不匹配");
        }
    }
}
