/*
    List接口概述
     鉴于Java中数组用来存储数据的局限性，我们通常使用List替代数组
     List集合类中元素有序、且可重复，集合中的每个元素都有其对应的顺序索引。
     List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据
    序号存取容器中的元素。
     JDK API中List接口的实现类常用的有：ArrayList、LinkedList和Vector。

    ArrayList,LinkedList,Vector三者的異同?
    同:三個類都是實現了List接口,可以存儲有序的可重複的數據。
    不同:
        ArrayList:線程不安全的,效率較高。底層使用Object[]存儲。
        LinkedList:對於頻繁的插入刪除操作,使用此類效率更高。底層使用雙向鍊表存儲。
        Vector:線程安全的,效率較低。底層使用Object[]存儲。


    List接口的常用方法:
     List除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来操作集合元素的方法。
       *void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
       *Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
       *Object remove(int index):移除指定index位置的元素，并返回此元素
       *Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合


    增:add(obj)
    刪:remove(index) / remove(obj)
    查:get(index)
    改:set(index,obj)
    插:add(index,obj)
    長度:size()
    遍歷:foreach


 */


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListIntro {
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add(5);
        arrayList.add("ccc");
        arrayList.add(false);

        System.out.println(arrayList);

        System.out.println("==============add==============");
        arrayList.add(1,"insertTo1");
        System.out.println(arrayList);

        System.out.println("==============addAll==============");
        List list = Arrays.asList(1,2,3);
        arrayList.addAll(list);
        System.out.println(arrayList);

        System.out.println("==============get==============");
        System.out.println(arrayList.get(0));

    }

    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add(5);
        arrayList.add("ccc");
        arrayList.add(false);

        System.out.println("==============indexOf==============");
        int whereIsCcc = arrayList.indexOf("ccc");
        System.out.println(whereIsCcc);

        System.out.println("==============lastIndexOf==============");
        arrayList.add("ccc");
        int wheeIsLastCcc = arrayList.lastIndexOf("ccc");
        System.out.println(wheeIsLastCcc);

        System.out.println("==============remove==============");
        Object obj = arrayList.remove(0);
        System.out.println(arrayList);
        System.out.println("刪除了:" + obj);

        System.out.println("==============set==============");
        arrayList.set(1,"ddd");
        System.out.println(arrayList);

        System.out.println("==============subList==============");
        List subList1 = arrayList.subList(1,3);//左閉右開
        System.out.println(subList1);//返回1,2
    }
}
