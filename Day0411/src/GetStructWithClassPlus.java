import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetStructWithClassPlus {
    @Test
    public void test1() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;

        //創建對象
        Constructor personCons = clazz.getConstructor();
        Person p = (Person) personCons.newInstance();

        System.out.println("==========================獲取指定屬性==========================");
        System.out.println("--------------------------public--------------------------");
        Field id = clazz.getField("id");
        id.set(p,7);
        System.out.println(p);

        System.out.println("--------------------------default--------------------------");
        Field age = clazz.getDeclaredField("age");
        age.set(p,5);
        System.out.println(p);

        System.out.println("--------------------------private--------------------------");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Anya");
        System.out.println(p);

    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;

        //創建對象
        Constructor personCons = clazz.getConstructor();
        Person p = (Person) personCons.newInstance();

        System.out.println("==========================獲取指定方法==========================");
        System.out.println("--------------------------private String--------------------------");
        /*
        Method getDeclaredMethod(String 方法名,參數1類型,參數2類型,....)
         */
        Method method1 = clazz.getDeclaredMethod("show",String.class);
        method1.setAccessible(true);

        /*
        Object invoke(Object obj, Object …  args):
        说明：
            1.Object 对应原方法的返回值，若原方法无返回值，此时返回null
            2.若原方法若为静态方法，此时形参Object obj可为null
            3.若原方法形参列表为空，则Object[] args为null
            4.若原方法声明为private,则需要在调用此invoke()方法前，显式调用
            方法对象的setAccessible(true)方法，将可访问private的方法。
         */
        String str = (String) method1.invoke(p,"Amiya");
        System.out.println(str);

        System.out.println("--------------------------private static void--------------------------");
        Method method2 = clazz.getDeclaredMethod("about");
        method2.setAccessible(true);

        Object obj = method2.invoke(null);
        //Object obj = method2.invoke(Person.class); 兩者皆可
        System.out.println(obj);
    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;

        System.out.println("==========================獲取指定構造器==========================");

        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person silverAsh = (Person) declaredConstructor.newInstance("SilverAsh");
        System.out.println(silverAsh);
    }
}
