import java.util.ArrayList;
import java.util.List;

public class PersonDate {
    public static List<Person> getPersonList(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Amiya",18,1001));
        personList.add(new Person("Kal'sit",527,1002));
        personList.add(new Person("THorns",29,1003));
        personList.add(new Person("Surtr",25,1004));
        personList.add(new Person("Chen",26,1005));
        personList.add(new Person("Black",33,1006));
        personList.add(new Person("Mudrock",21,1007));
        personList.add(new Person("Eunectes",20,1008));
        personList.add(new Person("Suzuran",13,1009));
        personList.add(new Person("Exusiai",24,1010));
        personList.add(new Person("Eyjafjalla",27,1011));
        personList.add(new Person("Kroos",19,1012));
        personList.add(new Person("Sussurro",22,1013));


        return personList;
    }
}
