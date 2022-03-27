/*
    =======================================為什麼要有泛型?=======================================
     泛型：标签
     举例：
         中药店，每个抽屉外面贴着标签
         超市购物架上很多瓶子，每个瓶子装的是什么，有标签
     泛型的设计背景
    集合容器类在设计阶段/声明阶段不能确定这个容器到底实际存的是什么类型的
    对象，所以在JDK1.5之前只能把元素类型设计为Object，JDK1.5之后使用泛型来
    解决。因为这个时候除了元素的类型不确定，其他的部分是确定的，例如关于
    这个元素如何保存，如何管理等是确定的，因此此时把元素的类型设计成一个
    参数，这个类型参数叫做泛型。Collection<E>，List<E>，ArrayList<E> 这个<E>就
    是类型参数，即泛型。

    =======================================泛型的概念=======================================
     所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类
    型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，
    继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实
    际的类型参数，也称为类型实参）。
     从JDK1.5以后，Java引入了“参数化类型（Parameterized type）”的概念，
    允许我们在创建集合时再指定集合元素的类型，正如：List<String>，这表明
    该List只能保存字符串类型的对象。
     JDK1.5改写了集合框架中的全部接口和类，为这些接口、类增加了泛型支持，
    从而可以在声明集合变量、创建集合对象时传入类型实参。


    =======================================集合中泛型的使用=======================================
    1.集合接口或集合類的泛型化都在jdk5.0。
    2.在實例化集合類時,可以指定泛型類型。
    3.指明完後,在集合中凡是定義類或接口時,內部結構中使用到泛型的位置,都指定為實例化時的泛型類型。
        EX.add(E e) ----> 實例化以後:add(Integer e)
    4.泛型必須是類,若要使用基本數據類型,可使用包裝類。
    5.如果實例化時沒有指定泛型類型,則默認為Object類型。




 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericIntro {
    @Test
    public  void test1(){
        ArrayList list = new ArrayList();
        //需求: 存放學生成績
        list.add(89);
        list.add(52);
        list.add(95);
        list.add(73);
        //問題一: 類型不安全
        list.add("Tom");

        for (Object score:
             list) {
            //問題二: 強轉時,可能會發生ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型: ArrayList
    @Test
    public  void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(89);
        list.add(52);
        list.add(95);
        list.add(73);
        //編譯時,就會進行類型檢查,保證數據安全。

        for (Integer score:
             list) {
            System.out.println(score);
        }
    }

    //在集合中使用泛型: HashMap
    @Test
    public  void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("001",13);
        map.put("002",56);
        map.put("003",9);
        map.put("004",16);

        //Entry是一個內部的接口,所以在調用時需透過Map
        Set<Map.Entry<String,Integer>> set = map.entrySet();

        for (Map.Entry<String,Integer> entry:
             set) {
            System.out.println(entry);
        }
    }

}
