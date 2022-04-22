import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceStreamTest {
    @Test
    public void test1() {

        System.out.println("====================reduce(T identity, BinaryOperator b)====================");
        //可以将流中元素反复结合起来，得到一个值。返回 T。
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer sum = list.stream().reduce(0,Integer::sum);
        System.out.println(sum);

        System.out.println("====================reduce(T identity, BinaryOperator b)====================");
        //可以将流中元素反复结合起来，得到一个值。返回 T。
        //總年齡平均
        List<Person> personList = PersonDate.getPersonList();
        Stream<Integer> ageStream = personList.stream().map(Person::getAge);
        Optional<Integer> sumOfAge = ageStream.reduce(Integer::sum);
        System.out.println((double)(sumOfAge.get())/personList.size());

    }
}
