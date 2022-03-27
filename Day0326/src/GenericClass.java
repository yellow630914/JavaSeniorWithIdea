/*
    =======================================如何自定義泛型=======================================
    1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：
        <E1,E2,E3>
    2. 泛型类的构造器如下：public GenericClass(){}。
        而下面是错误的：public GenericClass<E>(){}
    3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
    4. 泛型不同的引用不能相互赋值。
        >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有
        一个ArrayList被加载到JVM中。
    5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。经验：泛型要使用一路都用。要不用，一路都不要用。
    6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
    7. jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>();
    8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
    9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态属性的类型、非静态方法的参数类型、非静态方法的返回值类型。
        但在静态方法中不能使用类的泛型。
    10. 异常类不能是泛型的
    11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
        参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
    12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
         子类不保留父类的泛型：按需实现
             没有类型 擦除
             具体类型
         子类保留父类的泛型：泛型子类
             全部保留
             部分保留

    结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自
    己的泛型


 */

import org.junit.Test;

public class GenericClass {
    @Test
    public void test1(){
        //這裡沒有指明泛型類型,則此泛型為Object類型
        //如果在聲明時類是帶著泛型的,那建議在實例化時要指名泛型類型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //實例化時指名泛型類型。
        Order<String> stringOrder = new Order<String>();

        stringOrder.setOrderT("String");
        //stringOrder.setOrderT(123);
    }
    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由於子類在繼承帶泛型父類時,指明了泛型類型了,所以在此不需要再次指明。
        subOrder.setOrderT(123);
    }

    @Test
    public void test3(){
        SubOrderGeneric<String> subOrderGeneric = new SubOrderGeneric<String>();
        //子類在繼承帶泛型父類時,未指明泛型類,並繼承其泛型,所以在此可以指明。
        subOrderGeneric.setOrderT("Gen");
    }
}

class SubOrder extends Order<Integer>{

}

class SubOrderGeneric<T> extends Order<T>{

}

class Order<T>{
    String orderName;
    int orderId;

    //類的內部就可以使用類的泛型

    T orderT;

    public Order(){};

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
