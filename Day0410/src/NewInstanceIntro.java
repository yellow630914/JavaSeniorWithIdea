/*

    通過反射创建运行时类的对象

 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class NewInstanceIntro {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //有了Class对象，能做什么？
        Class<Person> clazz = Person.class;
        /*
            创建类的对象：调用Class对象的newInstance()方法
                要 求： 1）类必须有一个无参数的构造器。
                       2）类的构造器的访问权限需要足够
         */
//        已過時
//        Person p1 = clazz.newInstance("Aurora",22);

        Constructor<Person> personConstructorCons = clazz.getDeclaredConstructor(String.class,int.class);

        Person p1 = personConstructorCons.newInstance("Aurora",22);




        System.out.println(p1);

    }


    //反射動態性的體現
    @Test
    public void test2(){
        for (int i = 0;i < 10;i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";

            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "Person";
                    break;
            }
            try {
                Object obj = createClass(classPath);
                System.out.println(obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Object createClass(String classPath) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(classPath);
        Constructor cons = clazz.getConstructor();
        return cons.newInstance();
    }
}
