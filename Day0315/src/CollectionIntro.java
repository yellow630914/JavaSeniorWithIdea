import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
    一、集合的概述

    1.集合與數組都是對多個數據進行儲存操作的結構,簡稱Java容器。
    此指存儲是內存層面,不涉及持久化存儲。

    数组在内存存储方面的特点：
        数组初始化以后，长度就确定了。
        数组声明的类型，就决定了进行元素初始化时的类型
    数组在存储数据方面的弊端：
        数组初始化以后，长度就不可变了，不便于扩展
        数组中提供的属性和方法少，不便于进行添加、删除、插入等操作，且效率不高。同时无法直接获取存储元素的个数
        数组存储的数据是有序的、可以重复的。---->存储数据的特点单一

    二、Java 集合可分为 Collection 和 Map 两种体系
        Collection接口：单列数据，定义了存取一组对象的方法的集合
        https://imgur.com/p0tCHlA
            List：元素有序、可重复的集合
            Set：元素无序、不可重复的集合
         Map接口：双列数据，保存具有映射关系“key-value对”的集合
        https://imgur.com/rqIv5cN


    三、Collection常用方法
        add(e):增添e元素
        size():獲取元素個數
        addAll(C):將C集合添加到另一個集合
        clear():清空集合元素
        isEmpty():判斷當前集合是否為空
        
        
        
        


 */
public class CollectionIntro {



}
