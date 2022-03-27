/*
    集合的工具類Collections:
        Collections 是一个操作 Set、List 和 Map 等集合的工具类
        Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
        还提供了对集合对象设置不可变、对集合对象实现同步控制等方法


        排序操作：（均为static方法）
            reverse(List)：反转 List 中元素的顺序
            shuffle(List)：对 List 集合元素进行随机排序
            sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
            sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
            swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

        查找、替换
            Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
            Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
            Object min(Collection)
            Object min(Collection，Comparator)
            int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
            void copy(List dest,List src)：将src中的内容复制到dest中
            boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值


 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionsIntro {
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(5);
        arrayList.add(-6);
        arrayList.add(89);
        System.out.println(arrayList);

        System.out.println("============reverse(List)============");
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        System.out.println("============shuffle(List)============");
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        System.out.println("============sort(List)============");
        Collections.sort(arrayList);
        System.out.println(arrayList);

        System.out.println("============swap(List，int， int)============");
        Collections.swap(arrayList,1,2);
        System.out.println(arrayList);

        System.out.println("============Object max(Collection)============");
        System.out.println(Collections.max(arrayList));

        System.out.println("============Object min(Collection)============");
        System.out.println(Collections.min(arrayList));

        System.out.println("============int frequency(Collection，Object)============");
        System.out.println(Collections.frequency(arrayList,5));

        System.out.println("============void copy(List dest,List src)============");
        ArrayList dest = new ArrayList();
        dest.add("abc");
        dest.add("ggc");
        dest.add("ggc");
        dest.add("ggc");
        dest.add("ggc");
        dest.add("ggc");

        Collections.copy(dest,arrayList);

        System.out.println(dest);
    }
}
