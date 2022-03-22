/*

    註解的使用:

        1.从 JDK 5.0 开始
        2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加
        载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
        可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代
        码分析工具、开发工具和部署工具可以通过这些补充信息进行验证
        或者进行部署。
        3.Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方
        法, 成员变量, 参数, 局部变量的声明, 这些信息被保存在 Annotation
        的 “name=value” 对中。


        Annotation
        示例一:生成文档相关的注解
        示例二:在编译时进行格式检查(JDK内置的三个基本注解)
            @Override: 限定重写父类方法, 该注解只能用于方法
            @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
            @SuppressWarnings: 抑制编译器警告
        示例三：跟踪代码依赖性，实现替代配置文件功能



        自訂義註解
            1.定义新的 Annotation 类型使用 @interface 关键字
            2.如果只有一个参数成员，建议使用参数名为value
            3.可以在定义 Annotation 的成员变量时为其指定初始值, 指定成员变量的初始值可使用 default 关键字
            4.没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation


        元註解:JDK 的元 Annotation 用于修饰其他 Annotation 定义

        JDK5.0提供了4个标准的meta-annotation类型，分别是：
            Retention:用于指定该 Annotation 的生命周期(SOURCE/CLASS(默認)/RUNTIME)
            Target:用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
            Documented:用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
            Inherited:被它修饰的 Annotation 将具有继承性。


        JDK8.0後的功能:
            1.可重複註解
            2.類型註解
                TYPE_PARAMETER,TYPE_USE


 */


public class AnnotationIntro {
}

@MyAnnotation("hello")
class Person{
    private String name;
    private int age;

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

    public void walk(){

    }
}

class Student extends Person{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void walk() {
        super.walk();
    }
}
