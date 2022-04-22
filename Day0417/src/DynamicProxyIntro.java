/*
    代理设计模式的原理:
    使用一个代理将对象包装起来, 然后用该代理对象取代原始对象。任何对原
    始对象的调用都要通过代理。代理对象决定是否以及何时将方法调用转到原
    始对象上。
     之前为大家讲解过代理机制的操作，属于静态代理，特征是代理类和目标
    对象的类都是在编译期间确定下来，不利于程序的扩展。同时，每一个代
    理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。最
    好可以通过一个代理类完成全部的代理功能。

    动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时
    根据需要动态创建目标类的代理对象。
    动态代理使用场合:
        调试
        远程方法调用
    动态代理相比于静态代理的优点：
        抽象角色中（接口）声明的所有方法都被转移到调用处理器一个集中的方法中
        处理，这样，我们可以更加灵活和统一的处理众多的方法。

 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyIntro {
    public static void main(String[] args) {
        //h1:被代理類
        Human h1 = new Human();
        //proxyInstance:代理類對象
        Intelligent proxyInstance = (Intelligent) ProxyFactory.getProxyInstance(h1);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.think("人類");
    }
}

interface Intelligent{
    String getBelief();

    void think(String type);
}

/*

    要實現動態代理,需要解決的問題?
    Q1:如何動態的創建被代理類的對象?
    Q2:如何調用被代理類中,與代理類同名的方法?

 */

class ProxyFactory{
    //解決Q1,返回代裡類的對象
    public static Object getProxyInstance(Object obj){
        //解決Q2,綁定彼此的方法
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

//被代理類
class Human implements Intelligent{

    @Override
    public String getBelief() {
        return "Civilization";
    }

    @Override
    public void think(String type) {
        System.out.println(type + "思維");
    }
}

class IntelUtil{
    public void method1(){
        System.out.println("============通用1============");
    }

    public void method2(){
        System.out.println("============通用2============");
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    //當我們通過代理類對象,調用方法a時,就會自動的調用如下方法: invoke();
    //將被代理類要執行的方法a的功能就聲明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        IntelUtil util = new IntelUtil();

        util.method1();
        //當要代理類調用方法時,會到method去找,需要綁定被代理類(obj)
        Object returnValue = method.invoke(obj,args);
        util.method2();
        return returnValue;
    }
}
