import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapStreamTest {
    @Test
    public void test1(){
        //map(Function f): 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //練習:單獨獲取長度小於7的姓名
        List<Person> personList = PersonDate.getPersonList();
        Stream<String> nameStream = personList.stream().map(Person::getName);
        nameStream.filter(name -> name.length() < 7).forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        //若要將字串內的字符皆打印出來,要打開2次
        System.out.println("=======================map=======================");
        list.stream().map(MapStreamTest::fromStringToStream).forEach(System.out::println);
        System.out.println("==============================================");
        list.stream().map(MapStreamTest::fromStringToStream).forEach(s -> s.forEach(System.out::println));

        //使用flatMap則可直接攤平元素
        //flatMap(Function f):接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        System.out.println("=======================flatMap=======================");
        list.stream().flatMap(MapStreamTest::fromStringToStream).forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c:
             str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
