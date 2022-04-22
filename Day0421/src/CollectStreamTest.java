import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectStreamTest {
    @Test
    public void test1(){

        System.out.println("====================collect(Collectors.toList)====================");
        //取得年齡大於22的List
        List<Person> personList = PersonDate.getPersonList();
        List<Person> bigPerson = personList.stream().filter(e -> e.getAge()>22).collect(Collectors.toList());
        bigPerson.forEach(System.out::println);


        System.out.println("====================collect(Collectors.toSet)====================");
        //取得年齡大於22的List
        Set<Person> teen = personList.stream().filter(e -> e.getAge()<22).collect(Collectors.toSet());
        teen.forEach(System.out::println);
    }
}
