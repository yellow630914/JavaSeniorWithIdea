
@MyAnnotation
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person() {
    }

    private Person (String name){
        this.name = name;
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
    private String show(String who){
        return who + "說" + name + "是SB";
    }

    public int display(){
        return age+id;
    }

    private static void about(){
        System.out.println("我是隱密靜態虛空方法");
    }

    @Override
    public int compareTo(String o) {
        return 1;
    }

    @Override
    public void info() {
        System.out.println("人類");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
