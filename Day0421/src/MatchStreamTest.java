import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class MatchStreamTest {
    @Test
    public void test1(){
        List<Person> personList = PersonDate.getPersonList();

        System.out.println("====================allMatch(Predicate p)====================");
        //allMatch(Predicate p) 检查是否匹配所有元素
        //幹員是否都小於50歲?
        boolean allMatch = personList.stream().allMatch(e -> e.getAge() < 50);
        System.out.println(allMatch);


        System.out.println("====================anyMatch(Predicate p)====================");
        //anyMatch(Predicate p) 检查是否至少匹配一个元素
        //幹員是否至少一個小於50歲?
        boolean anyMatch = personList.stream().anyMatch(e -> e.getAge() < 50);
        System.out.println(anyMatch);


        System.out.println("====================noneMatch(Predicate p)====================");
        //noneMatch(Predicate p) 检查是否没有匹配所有元素
        //幹員是否都沒有大於50歲?
        boolean noneMatch = personList.stream().noneMatch(e -> e.getAge() > 50);
        System.out.println(noneMatch);


        System.out.println("====================findFirst()====================");
        //findFirst() 返回第一个元素
        Optional<Person> first = personList.stream().findFirst();
        System.out.println(first);


        System.out.println("====================findAny()====================");
        //findAny() 返回当前流中的任意元素
        Optional<Person> any = personList.stream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2(){
        List<Person> personList = PersonDate.getPersonList();

        System.out.println("====================count()====================");
        //count() 返回流中元素总数
        //年齡大於22歲的幹員有幾個?
        long count = personList.stream().filter(e -> e.getAge()> 22).count();
        System.out.println(count);

        System.out.println("====================anyMatch(Comparator c)====================");
        //max(Comparator c) 返回流中最大值
        //羅德島誰最老?
        Optional<Person> maxAgePerson = personList.stream().max((e1, e2) -> {
            return Integer.compare(e1.getAge(),e2.getAge());
        });
        System.out.println(maxAgePerson);

        System.out.println("====================min(Comparator c)====================");
        //min(Comparator c) 返回流中最小值
        //羅德島誰最可愛?
        Optional<Person> minAgePerson = personList.stream().min((e1, e2) -> {
            return Integer.compare(e1.getAge(),e2.getAge());
        });
        System.out.println(minAgePerson);

        System.out.println("====================forEach(Consumer c)====================");
        //forEach(Consumer c)
        personList.stream().filter(e -> e.getAge()> 22).forEach(System.out::println);
        //内部迭代(使用 Collection 接口需要用户去做迭代，
        //称为外部迭代。相反，Stream API 使用内部迭
        //代——它帮你把迭代做了)
    }
}
