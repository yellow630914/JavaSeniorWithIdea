import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetIntro {

    /*
    1.向TreeSet中添加的數據要求是同類型提供的。
    2.此類需要提供排序的方法:自然排序(類實現Comparable接口)或定製排序(使用Comparator比較類)。
    3.自然排序中,比較兩物件的標準改為:compareTo(),而非equals()。
    4.自然排序中,比較兩物件的標準改為:compare(),而非equals()。
     */

    @Test
    public void test1(){
        TreeSet treeSet = new TreeSet();

        treeSet.add(new User("001",5));
        treeSet.add(new User("002",10));
        treeSet.add(new User("003",28));
        treeSet.add(new User("004",1));
        treeSet.add(new User("005",9));
        treeSet.add(new User("006",3));
        treeSet.add(new User("007",55));
        treeSet.add(new User("008",21));
        treeSet.add(new User("009",15));

        for (Object user:
             treeSet) {
            System.out.println(user);
        }

    }

    @Test
    public void test2(){
        //依照點數多寡的比較器
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getPoint(),u2.getPoint());
                }else{
                    throw new RuntimeException();
                }
            }
        };

        //將比較器放入
        TreeSet treeSet = new TreeSet(com);

        treeSet.add(new User("001",5));
        treeSet.add(new User("002",10));
        treeSet.add(new User("003",28));
        treeSet.add(new User("004",1));
        treeSet.add(new User("005",9));
        treeSet.add(new User("006",3));
        treeSet.add(new User("007",55));
        treeSet.add(new User("008",21));
        treeSet.add(new User("009",15));

        for (Object user:
             treeSet) {
            System.out.println(user);
        }
    }


}
