import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SortStreamTest {
    @Test
    public void test1(){
        //sorted:产生一个新流，其中按自然顺序排序
        System.out.println("=======================sorted()=======================");
        List<Integer> integerList = Arrays.asList(12,85,-825,-58,85,-612,-584,548,89,236,57,-52,363,48);
        integerList.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com):产生一个新流，其中按比较器顺序排序
        System.out.println("=======================sorted(Comparator com)=======================");
        List<Person> personList = PersonDate.getPersonList();
        personList.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);

    }
}
