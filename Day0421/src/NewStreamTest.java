import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewStreamTest {
    //1.通過集合創建Stream
    @Test
    public void test1(){
        List<Person> personList = PersonDate.getPersonList();

        //Stream<E> stream():返回一個順序流
        Stream<Person> stream = personList.stream();

        //Stream<E> parallelStream():返回一個併行流
        Stream<Person> paraStream = personList.parallelStream();
    }

    //2.通過Array創建Stream
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //調用中的 Arrays 的静态方法 stream() 可以获取数组流:
        IntStream stream = Arrays.stream(arr);

        Person p1 = new Person("Tom",18,1001);
        Person p2 = new Person("Ama",17,1002);
        Person[] people = new Person[]{p1,p2};
        Stream<Person> personStream = Arrays.stream(people);
    }

    //3.通過Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
    }

    //4.通過Stream的無限流
    @Test
    public void test4(){
        // 迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        // 生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(() -> (int)(Math.random()*10)).limit(20).forEach(System.out::println);
    }
}
