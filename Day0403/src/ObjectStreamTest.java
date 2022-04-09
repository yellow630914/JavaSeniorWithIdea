/*
    對象流:
         ObjectInputStream和ObjectOutputSteam
             用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
            以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

         序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
         反序列化：用ObjectInputStream类读取基本类型数据或对象的机制

         ObjectOutputStream和ObjectInputStream不能序列化static和transient修
        饰的成员变量

        對象的序列化:
            对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
            而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
            输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
            来的Java对象
            序列化的好处在于可将任何实现了Serializable接口的对象转化为字节数据，
            使其在保存和传输时可被还原
            序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返
            回值都必须实现的机制，而 RMI 是 JavaEE 的基础。因此序列化机制是
            JavaEE 平台的基础
            如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可
            序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。
            否则，会抛出NotSerializableException异常
            Serializable
            Externalizable

 */

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {
    @Test
    public void transObject(){
        Person p1 = new Person("Amiya",17);
        //序列化
        testObjectOutputStream(p1.getName(),p1);
        //反序列化(順便print)
        testObjectInputStream(p1.name + ".dat");
    }

    /*
    序列化過程:將內存中的JAVA對象保存到硬盤或通過網路傳輸出去
    使用ObjectOutputStream實現
     */
    public void testObjectOutputStream(String docPath,Object obj){

        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream(docPath + ".dat"));
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化過程:將硬盤或網路中的JAVA對象還原到內存中
     */
    public void testObjectInputStream(String targetPath){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(targetPath));
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

/*
    若想序列化必須滿足以下需求:
    1.實現Serializable接口
    2.需要當前類提供一個全局常量
    3.除了類本身要實現Serializable接口外,也要保證其屬性是可序列化的

    補充:ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量

 */

class Person implements Serializable{
    public static final long serialVersionUID = 456485318612L;

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
