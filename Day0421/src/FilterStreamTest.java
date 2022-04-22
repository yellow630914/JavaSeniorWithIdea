import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class FilterStreamTest {
    @Test
    public void test1(){
        List<Person> personList = PersonDate.getPersonList();
        //filter(Predicate p):接收 Lambda ， 从流中排除某些元素
        Stream<Person> personStream = personList.stream();

        System.out.println("=================filter=================");
        //排除25歲以上的幹員
        personStream.filter(e -> e.getAge() > 25).forEach(System.out::println);

        System.out.println("=================limit=================");
        //limit(long maxSize): 截斷流
        personList.stream().limit(3).forEach(System.out::println);

        System.out.println("=================skip=================");
        //skip(long n): 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        personList.stream().skip(3).forEach(System.out::println);


        System.out.println("=================distinct()=================");
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        personList.add(new Person("Kazemaru",20,1014));
        //distinct(): 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        //重複的定義:通過流的hashCode()與equals()判斷
        personList.stream().distinct().forEach(System.out::println);



    }



}
