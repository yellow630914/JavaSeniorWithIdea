/*

    三、Collection常用方法
        add(e):增添e元素
        size():獲取元素個數
        addAll(C):將C集合添加到另一個集合
        clear():清空集合元素
        isEmpty():判斷當前集合是否為空
        contains():判斷集合中是否包含參數物件(比對時調用equals方法)
        containsAll():比對集合與集合之間
        remove()：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素。
        removeAll(Collection coll)：取当前集合的差集
        retainAll(Collection c)：把交集的结果存在当前集合中，不影响參數c
        toArray():轉換成Array
        hashCode():获取集合对象的哈希值
        iterator():返回迭代器对象，用于集合遍历

 */


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethods {

    @Test
    public void test1(){
        Collection collection = new ArrayList();

        //add(Object e):添加元素e
        collection.add(1);
        collection.add("aaa");

        //size:獲取元素個數
        System.out.println(collection.size());

        //addAll():將集合添加到另一個集合
        Collection collection1 = new ArrayList();
        collection1.add("bb");
        collection1.add("cc");
        collection1.addAll(collection1);
        System.out.println(collection1);

        //clear:清空集合元素
        collection1.clear();

        //isEmpty():判斷當前集合是否為空
        System.out.println(collection1.isEmpty());
    }


    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add(5);
        collection.add("ccc");
        collection.add(false);

        //contains():判斷集合中是否包含參數物件
        boolean contains = collection.contains("aaa");
        System.out.println(contains);

        Collection collection1 = new ArrayList();
        collection1.add("aaa");
        collection1.add(5);

        //containsAll():比對集合與集合之間
        System.out.println(collection.containsAll(collection1));
        collection1.add(123);
        System.out.println(collection.containsAll(collection1));
    }

    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add(5);
        collection.add("ccc");
        collection.add(false);

        //remove()：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素。
        //刪除成功會返回boolean值
        collection.remove("aaa");
        System.out.println(collection);

        Collection collection1 = new ArrayList();
        collection1.add("aaa");
        collection1.add(5);
        collection1.add(6);

        //removeAll(Collection coll)：取当前集合的差集
        collection.removeAll(collection1);
        System.out.println(collection);

    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add(5);
        collection.add("ccc");
        collection.add(false);

        Collection collection1 = new ArrayList();
        collection1.add("aaa");
        collection1.add(5);
        collection1.add(6);

        //retainAll(Collection c)：把交集的结果存在当前集合中，不影响參數c
        collection.retainAll(collection1);
        System.out.println(collection);

        collection1.retainAll(collection);
        //boolean equals(Object obj):集合是否相等
        System.out.println(collection.equals(collection1));
        //hashCode():获取集合对象的哈希值
        System.out.println(collection.hashCode());
        //toArray
        Object[] collectionArray = collection1.toArray();

        for (int i = 0; i < collectionArray.length; i++) {
            System.out.println(collectionArray[i]);
        }
    }

}