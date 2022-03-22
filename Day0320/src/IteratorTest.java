import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    使用 Iterator 接口遍历集合元素
     Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
     GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元
    素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。类似于“公
    交车上的售票员”、“火车上的乘务员”、“空姐”。


 */

public class IteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add(5);
        collection.add("ccc");
        collection.add(false);

        Iterator iterator = collection.iterator();

        //測定下一個元素是否存在
        while(iterator.hasNext()){
            //指向下一個元素
            System.out.println(iterator.next());
        }

        iterator = collection.iterator();

        while(iterator.hasNext()){
            Object obj = iterator.next();
            if ("aaa".equals(obj)) {
                //刪除當前指針的元素
                iterator.remove();
            }
        }

        System.out.println("*****************************************");

        iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
