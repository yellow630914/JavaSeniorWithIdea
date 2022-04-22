import java.util.Objects;

public class Person implements Comparable<String>{

    private String name;
    int age;
    public int id;

    public Person() {
    }



    private Person(String name){
        this.name = name;
    }

    Person(int age, int id) {
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(int id) {
        this.id = id;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}
