import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

public class ArrayRefTest {
    //數組引用
    @Test
    public void test1(){
        Function<Integer,String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("====================數組引用====================");

        Function<Integer,String[]> func2 = String[] :: new;
        String[] arr2 = func2.apply(5);
        System.out.println(Arrays.toString(arr2));
    }
}
