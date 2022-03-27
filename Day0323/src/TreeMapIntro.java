/*
    向TreeMap添加的key-value,要求key必須是同一個類
    因為要按照key進行:自然排序,定制排序


 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapIntro {
    //自然排序
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        User u1 = new User("001",65);
        User u2 = new User("005",123);
        User u3 = new User("025",59);
        User u4 = new User("006",6);

        treeMap.put(u1,18);
        treeMap.put(u2,21);
        treeMap.put(u3,25);
        treeMap.put(u4,19);

        Set treeMapSet = treeMap.entrySet();

        for (Object obj:
             treeMapSet) {
            System.out.println(obj);
        }

    }

    @Test
    public void test2(){


        TreeMap map = new TreeMap(new Comparator() {
            public int compare(Object u1, Object u2) {
                if(u1 instanceof User && u2 instanceof User){
                    User user1 = (User)u1;
                    User user2 = (User)u2;
                    return user1.getID().compareTo(user2.getID());
                }else{
                    throw new RuntimeException("傳入的數據類型不一致");
                }
        }   });
        User u1 = new User("001",65);
        User u2 = new User("005",123);
        User u3 = new User("025",59);
        User u4 = new User("006",6);
        map.put(u1,18);
        map.put(u2,21);
        map.put(u3,25);
        map.put(u4,19);

        Set mapSet = map.entrySet();

        for (Object obj:
                mapSet) {
            System.out.println(obj);
        }

    }


}

class User implements Comparable{
    String ID;
    int point;

    public User(String ID, int point) {
        this.ID = ID;
        this.point = point;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return point == user.point && Objects.equals(ID, user.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, point);
    }

    @Override
    public String toString() {
        return "User:"+ this.hashCode() + "{" +
                "ID='" + ID + '\'' +
                ", point=" + point +
                '}';
    }


    //依照ID排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            int compare = this.ID.compareTo(user.ID);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.point,user.point);
            }
        }else{
            throw new RuntimeException("輸入類型不匹配");
        }
    }
}