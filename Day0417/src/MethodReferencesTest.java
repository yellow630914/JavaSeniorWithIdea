/*

    方法引用(Method References)
         当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
         方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就
        是Lambda表达式，也就是函数式接口的一个实例，通过方法的名字来指向
        一个方法，可以认为是Lambda表达式的一个语法糖。
         要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的
        方法的参数列表和返回值类型保持一致！
         格式：使用操作符 “::” 将类(或对象) 与 方法名分隔开来。
         如下三种主要使用情况：
             对象::实例方法名
             类::静态方法名
             类::实例方法名

 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferencesTest {

    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Karsa");

        System.out.println("=========================");

        Consumer<String> con2 = System.out::println;
        con2.accept("簡單的Karsa");
    }

    //对象::实例方法名
    @Test
    public void test2(){
        Person p1 = new Person("Rookie",22,001);

        System.out.println("===============供給型===============");
        //Supplier<String> name = () -> p1.getName();
        Supplier<String> name =  p1::getName;
        System.out.println(name.get());
    }

    //类::静态方法名
    @Test
    public void test3(){
        //Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(516,518));
    }
    @Test
    public void test4(){

        System.out.println("===============函數型===============");
        //Function<Double,Long> func = d -> Math.round(d);
        Function<Double,Long> func1 = Math::round;
        System.out.println(func1.apply(56.88));

    }

    //类::实例方法名
    @Test
    public void test5(){
        Comparator<String> strCom = (s1,s2) -> s1.compareTo(s2);
        System.out.println(strCom.compare("abc","abd"));

        System.out.println("=========================");

        Comparator<String> strComVerFR = String::compareTo;
        System.out.println(strComVerFR.compare("abd","aba"));
    }
}
