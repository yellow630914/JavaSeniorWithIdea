/*
    2.通配符的使用
    通配符:?
    類A是類B的父類,G<A>與G<B>是並列關係,G<?>可做為二者的共同父類。

    3.有限制條件的通配符
         <? extends Number> (无穷小 , Number]
        只允许泛型为Number及Number子类的引用调用
         <? super Number> [Number , 无穷大)
        只允许泛型为Number及Number父类的引用调用
         <? extends Comparable>
        只允许泛型为实现Comparable接口的实现类的引用调用
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WildcardIntro {
    @Test
    public void test1(){
        List<Object> objectList = null;
        List<String> stringList = null;

        List<?> list = null;


        //類A是類B的父類,G<A>與G<B>是並列關係,G<?>可做為二者的共同父類。
        list = objectList;
        list = stringList;

        stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        //添加: 對於List<?>不能向其添加數據,除了null
        //list.add(null);
        //讀取:可以正常讀取
        list = stringList;
        this.print(list);
    }
    public void print(List<?> list){
        for (Object obj:
             list) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        List<? extends Person>list1 = null;
        List<? super Person>list2 = null;

        List<Employees> employeesList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        list1 = employeesList;
        list1 = personList;
        //list1 = objectList;  高於範圍

        //list2 = employeesList;  低於範圍
        list2 = personList;
        list2 = objectList;

        //讀取
        list1 = employeesList;
        Object obj = list1.get(0);//obj足夠大
        Person person = list1.get(0);//person也足夠大
        //Employees employees = list1.get(0); 因通配符判斷employees可能出現錯誤

        //寫入
        list2 = personList;

        //list2.add(new Object()); Object類太大,可能放不下
        list2.add(new Person()); //Person類足夠小
        list2.add(new Employees()); //Employees類也足夠小
    }
}

class Person{

}

class Employees extends Person{

}
