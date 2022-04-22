/*
    Java內建四大函數式接口

    消費型接口 Consumer<T>    void accept(T t)
    供給型街口 Supplier<T>    T get()
    函數型接口 Function<T,R>  R apply(T t)
    斷定型接口 Predicate<T>   boolean test(T t)

 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JavaFunctionalInterface {
    public void Con(double money, Consumer<Double> con){
        con.accept(money);
    }
    public List<String> filterString(List<String> list, Predicate<String>pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s:
             list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
    @Test
    public void test1(){
        System.out.println("===============消費型===============");
        Con(300,money -> System.out.println("這杯水花了我" + money + "元"));

        System.out.println("===============判斷型===============");
        List<String> list = Arrays.asList("Kal'tsit","Sussurro","Warfarin","Ptilopsis","Perfumer","Gavial");
        List<String> filterList = filterString(list, s -> s.contains("o"));
        System.out.println(filterList);

    }

}
