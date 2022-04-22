import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class GetStructWithClass {
    @Test
    public void test1(){
        Class clazz = Person.class;

        System.out.println("==========================屬性(getFields)==========================");
        //獲取屬性結構
        //public Field[] getFields(): 返回此Class对象所表示的类或接口的public的Field。
        Field[] fields = clazz.getFields();
        for (Field f:
             fields) {
            System.out.println(f);
        }
        System.out.println("==========================屬性(getDeclaredFields)==========================");
        //public Field[] getDeclaredFields(): 返回此Class对象所表示的类或接口的全部Field。(不包含父類的)
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field f:
             declaredField) {
            System.out.println(f);
        }
        System.out.println("==========================屬性結構==========================");
        for (Field f:
                declaredField) {
            System.out.print("權限修飾符:" + Modifier.toString(f.getModifiers()));
            System.out.print(", 類型:" + f.getType());
            System.out.println(", 名稱:" + f.getName());
        }
    }

    @Test
    public void test2() {
        Class clazz = Person.class;

        System.out.println("==========================方法(getMethods)==========================");
        // public Method[] getMethods(): 返回此Class对象所表示的类或接口的public的方法
        Method[] methods = clazz.getMethods();
        for (Method method:
             methods) {
            System.out.println(method);
        }
        System.out.println("==========================方法(getDeclaredMethods)==========================");
        // public Method[] getDeclaredMethods(): 返回此Class对象所表示的类或接口的全部方法(不包含父類)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method:
                declaredMethods) {
            System.out.println(method);
        }
        System.out.println("==========================方法細節==========================");
        for (Method method:
                declaredMethods) {
            System.out.print("註解: " + method.getAnnotations());
            System.out.print(", 修饰符: " + Modifier.toString(method.getModifiers()));
            System.out.print(", 返回值: " + method.getReturnType());
            System.out.println(", 名稱: " + method.getName());
            System.out.print(", 参数: " + method.getParameterTypes());
            System.out.println(", 异常信息" + method.getExceptionTypes());
        }
    }

    @Test
    public void test3(){
        Class clazz = Person.class;

        System.out.println("==========================getConstructors()==========================");
        Constructor[] constructors = clazz.getConstructors();

        for (Constructor c:
             constructors) {
            System.out.println(c);
        }

        System.out.println("==========================getDeclaredConstructors()==========================");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c:
                declaredConstructors) {
            System.out.println(c);
        }
    }

    @Test
    public void test4(){
        Class clazz = Person.class;

        System.out.println("==========================父類==========================");
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        System.out.println("==========================帶泛的父類==========================");
        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);

        System.out.println("==========================父類的泛型==========================");
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
        //獲取泛型類型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type t:
        actualTypeArguments) {
            System.out.println(t);
        }

    }
    
    @Test
    public void test5(){
        Class clazz = Person.class;
        System.out.println("==========================接口==========================");
        Class[] interfaces = clazz.getInterfaces();
        for (Class i:
             interfaces) {
            System.out.println(i);
        }
        System.out.println("==========================父類的接口==========================");
        Class[] superInterfaces = clazz.getSuperclass().getInterfaces();
        for (Class i:
                superInterfaces) {
            System.out.println(i);
        }
    }

    @Test
    public void test6(){
        Class clazz = Person.class;
        System.out.println("==========================Package==========================");
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    @Test
    public void test7(){
        Class clazz = Person.class;
        System.out.println("==========================註解==========================");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a:
             annotations) {
            System.out.println(a);
        }
    }
}
