/*
    DAO: Data(base) access object

 */


import org.junit.Test;

import java.util.List;

public class DAOTest{
    @Test
    public void test1(){
        DAO<Integer> dao = new DAO<>();

    }
}


class DAO<T> {
    //添加一條紀錄
    public void add(T t){

    }
    //刪除一條紀錄
    public boolean delete(T t){
        return false;
    }
    //修改一條紀錄
    public void update(int index,T t){

    }
    //查詢一條紀錄
    public T getIndex(int index){
        return null;
    }
    //查詢多條紀錄
    public List<T> getForList(int index){
        return null;
    }
    //取得表中數值的泛型方法
    public <E> E getValue(){
        return null;
    }
}
class Students{//DataBase表

}

class StudentsDAO<Students> extends DAO<Students>{//只能操作Students表的DAO

}
