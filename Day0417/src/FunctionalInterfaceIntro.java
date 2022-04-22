/*

    什么是函数式(Functional)接口
         只包含一个抽象方法的接口，称为函数式接口。
         你可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda 表达式
        抛出一个受检异常(即：非运行时异常)，那么该异常需要在目标接口的抽
        象方法上进行声明）。
         我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检
        查它是否是一个函数式接口。同时 javadoc 也会包含一条声明，说明这个
        接口是一个函数式接口。
         在java.util.function包下定义了Java 8 的丰富的函数式接口

 */


@FunctionalInterface
public interface FunctionalInterfaceIntro {
    void methods1();
}
