/*
    Optional 类:
         到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。
        以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，
        Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代
        码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。
         Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表
        这个值存在。或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不
        存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
         Optional类的Javadoc描述如下：这是一个可以为null的容器对象。如果值存在
        则isPresent()方法会返回true，调用get()方法会返回该对象。


    Optional提供很多有用的方法，这样我们就不用显式进行空值检测:
         创建Optional类对象的方法：
             Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
             Optional.empty() : 创建一个空的 Optional 实例
             Optional.ofNullable(T t)：t可以为null
         判断Optional容器中是否包含对象：
             boolean isPresent() : 判断是否包含对象
             void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer
              接口的实现代码，并且该值会作为参数传给它。
         获取Optional容器的对象：
             T get(): 如果调用对象包含值，返回该值，否则抛异常
             T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
             T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由
              Supplier接口实现提供的对象。
             T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返
              回，否则抛出由Supplier接口实现提供的异常。

 */


import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    // Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    // Optional.empty() : 创建一个空的 Optional 实例
    // Optional.ofNullable(T t)：t可以为null
    @Test
    public void test1(){
        System.out.println("====================Optional.of(T t)====================");
        Person p1 = new Person();
        Optional<Person> personOptional1 = Optional.of(p1);
        System.out.println(personOptional1);

        System.out.println("====================Optional.ofNullable(T t)====================");
        Person p2 = null;
        Optional<Person> personOptional2 = Optional.ofNullable(p2);
        System.out.println(personOptional2);
    }

    // boolean isPresent() : 判断是否包含对象
    // void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
    @Test
    public void test2(){
        System.out.println("====================Optional.isPresent()====================");
        Person p1 = new Person("Shi",18,61);
        Optional<Person> personOptional1 = Optional.of(p1);
        System.out.println(personOptional1.isPresent());
        System.out.println("====================Optional.ifPresent(Consumer<? super T> consumer)====================");
        personOptional1.ifPresent(e -> System.out.println("我的名字是" + e.getName()));
    }
    // T get(): 如果调用对象包含值，返回该值，否则抛异常
    // T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
    // T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
    // T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
    @Test
    public void test3(){
        System.out.println("====================Optional.get()====================");
        Person p1 = new Person("Shi",18,61);
        Optional<Person> personOptional = Optional.of(p1);
        System.out.println(personOptional.get());

        System.out.println("====================Optional.orElse(T other)====================");
        Optional<Person> personOptional1 = Optional.empty();
        System.out.println(personOptional1.orElse(new Person("查無此人",0,0)));

        System.out.println("====================Optional.orElseGet(Supplier<? extends T> other)====================");
        System.out.println(personOptional1.orElseGet(()-> new Person("查無此人",0,0)));

        System.out.println("====================Optional.orElseThrow(Supplier<? extends X> exceptionSupplier)====================");
        System.out.println(personOptional1.orElseThrow(()-> new RuntimeException("查無此人")));


    }
}
