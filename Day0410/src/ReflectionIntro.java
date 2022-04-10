/*
Java Reflection:
    Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期
    借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内
    部属性及方法。
    加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（一个
    类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可
    以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看
    到类的结构，所以，我们形象的称之为：反射

     Java反射机制提供的功能
        在运行时判断任意一个对象所属的类
        在运行时构造任意一个类的对象
        在运行时判断任意一个类所具有的成员变量和方法
        在运行时获取泛型信息
        在运行时调用任意一个对象的成员变量和方法
        在运行时处理注解
        生成动态代理

    反射相关的主要API:
         java.lang.Class:代表一个类
         java.lang.reflect.Method:代表类的方法
         java.lang.reflect.Field:代表类的成员变量
         java.lang.reflect.Constructor:代表类的构造器
         … …



 */


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionIntro {
    //反射之前,對於Person的操作
    @Test
    public void test1(){
        Person p1 = new Person("Amiya",17);

        p1.setAge(19);
        System.out.println(p1);

        //在Person類外部,不可以通過Person類的對象調用其內部私有結構
    }

    //透過反射
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通過反射,創建Person類的對向
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Amiya",12);
        Person p = (Person)obj;
        System.out.println(p);
        //2.通過反射,調用對象的指定屬性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        //3.調用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("=====================調用私有結構=====================");
        //通過反射可以調用類的私有結構
        Constructor consS = clazz.getDeclaredConstructor(String.class);
        consS.setAccessible(true);
        Person p1 = (Person) consS.newInstance("Kalsit");
        System.out.println(p1);

        //通過反射調用類的私有屬性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"M3");
        System.out.println(p1);

        //調用私有方法
        Method SShow = clazz.getDeclaredMethod("secretShow");
        SShow.setAccessible(true);
        SShow.invoke(p1);
    }

    //疑問: 通過直接new的方式或反射的方式都可以調用公共結構,開發中使用哪種?
    //建議: 使用new。

    //疑問: 何時使用反射?
    //建議: 反射的特徵有動態性,適合當不確定要造的類時,可以使用反射。

    //疑問: 反射機制之於封裝性是否矛盾?如何看待兩種技術?
    //建議: 不矛盾。凡事皆有特例,但不建議。

}

class Person{
    private String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    void show(){
        System.out.println("n=" + name + "," + "a=" + age);
    }

    private void secretShow(){
        System.out.println(name + "是SB");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
