/*
    1.泛型在繼承方面的體現



 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //類A是類B的父類,但List<A>與List<B>是並列關係。
        List<Object> objectList = null;
        List<String> stringList = null;

        //此時objectList與stringList沒有父子關係
        //objectList = stringList;
    }
    @Test
    public void test2(){
        List<String> stringList = null;
        ArrayList<String> stringArrayList = null;

        //類A是類B的父類,A<G>與B<G>依然是父子關係
        stringList = stringArrayList;
    }
}
