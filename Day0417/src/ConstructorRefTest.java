import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    @Test
    public void test1(){
        //構造器引用
        Supplier<Person> p1 = () -> new Person();
        System.out.println(p1.get());
        System.out.println("====================構造器引用====================");
        Supplier<Person> p2 = Person::new;
        System.out.println(p2.get());
    }
    @Test
    public void test2(){
        //Function<T,R>
        Function<Integer,Person> cons1 = id -> new Person(id);
        Person p1 = cons1.apply(1052);
        System.out.println(p1);
        System.out.println("====================構造器引用====================");
        Function<Integer,Person> cons2 = Person::new;
        Person p2 = cons2.apply(1053);
        System.out.println(p2);
    }
    @Test
    public void test3(){
        //BiFunction<T,U,R>
        BiFunction<Integer,Integer,Person> cons1 = (age,id) -> new Person(age,id);
        Person p1 = cons1.apply(15,1052);
        System.out.println(p1);
        System.out.println("====================構造器引用====================");
        BiFunction<Integer,Integer,Person> cons2 = Person::new;
        Person p2 = cons2.apply(18,1053);
        System.out.println(p2);
    }



}
