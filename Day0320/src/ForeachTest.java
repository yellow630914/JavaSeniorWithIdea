/*
    使用 foreach 循环遍历集合元素
         Java 5.0 提供了 foreach 循环迭代访问 Collection和数组。
         遍历操作不需获取Collection或数组的长度，无需使用索引访问元素。
         遍历集合的底层调用Iterator完成操作。
         foreach还可以用来遍历数组。

 */

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForeachTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add(5);
        collection.add("ccc");
        collection.add(false);

        //for(元素類型 局部變數 : 目標物件)
        for (Object coll : collection) { //底層仍然使用迭代器
            System.out.println(coll);
        }
    }
}
