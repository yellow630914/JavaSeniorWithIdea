
@MyAnnotation
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person() {
    }

    Person(int age, int id) {
        this.age = age;
        this.id = id;
    }

    @MyAnnotation(value = "ccc")
    private Person(int id) {
        this.id = id;
    }

    @MyAnnotation
    private String show(){
        return "我的名字" + name;
    }

    public int display(){
        return age+id;
    }

    @Override
    public int compareTo(String o) {
        return 1;
    }

    @Override
    public void info() {
        System.out.println("人類");
    }
}
