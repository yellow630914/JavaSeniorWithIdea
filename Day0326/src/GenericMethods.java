import org.junit.Test;

/*
    =======================================泛型方法=======================================
     方法，也可以被泛型化，不管此时定义在其中的类是不是泛型类。在泛型方法中可以定义泛型参数，此时，参数的类型就是传入数据的类型。
     泛型方法的格式：
        [访问权限] <泛型> 返回类型 方法名([泛型标识 参数名称]) 抛出的异常
     泛型方法是可以是static的
     泛型方法声明泛型时也可以指定上限(在12.5中讲)
 */

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    @Test
    public void test1(){
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};

        List<Integer> list = this.copyFromArrayToList(arr);
        //泛型方法在調用時指明泛型類型
        System.out.println(list);
    }
    //這是泛型方法
    public <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for (E e:
             arr) {
            list.add(e);
        }
        return list;
    }
}
