/*

    为什么使用 Lambda 表达式
    Lambda 是一个匿名函数，我们可以把 Lambda 表达式理解为是一段可以
    传递的代码（将代码像数据一样进行传递）。使用它可以写出更简洁、更
    灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了
    提升。
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我愛明日方舟");
            }
        };
        r1.run();

        System.out.println("====================");

        Runnable r2 = () -> {
            System.out.println("我愛英雄聯盟");
        };
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12,55);
        System.out.println(compare1);

        System.out.println("====================");

        Comparator<Integer> com2 = (o1, o2) -> {
            return Integer.compare(o1,o2);
        };

        int compare2 = com2.compare(52,98);
        System.out.println(compare2);

        System.out.println("====================");

        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com3.compare(5982,978);
        System.out.println(compare3);
    }
    /*
    Lambda的使用
    1.舉例: (o1,o2) -> Integer.compare(o1,o2);
    2.格式:
        -> : Lambda操作符
        ->左邊: Lambda型參列表(接口中抽象方法的型參列表)
        ->右邊: Lambda體 (接口中重寫方法的方法體)
    3.具體使用的6種情況:(見test3)

    4.Lambda表達式的本質: 作為接口的實例
     */
    @Test
    public void test3(){
        //情況一: 無參、無返回值
        Runnable r2 = () -> System.out.println("我愛艾爾登法還");
        r2.run();

        //情況二: 帶參、無返回值
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("我愛菈妮");

        //情況三: 數據類型可以省略,因為可以由編譯器推斷,稱為"類型推斷"
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("為拉妮,我變成狼人模樣");

        //情況四: 一參
        Consumer<String> con3 = s -> {
            System.out.println(s);
        };
        con3.accept("我愛梅琳娜");

        //情況五: 多參,多語句,且返回
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("我愛顛火");
            return Integer.compare(x,y);
        };
        System.out.println(comparator.compare(651165,684165));

        //情況六: 方法體只有一條語句時,return與大括號都可以省略
        Consumer<String> con4 = s -> System.out.println(s);
        con4.accept("妳個木頭人");
    }

}
