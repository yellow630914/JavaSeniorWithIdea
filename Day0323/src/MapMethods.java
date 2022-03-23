
/*

     添加、刪除、修改操作：
         Object put(Object key,Object value)：將指定key-value添加到(或修改)當前map對像中
         void putAll(Map m):將m中的所有key-value對存放到當前map中
         Object remove(Object key)：移除指定key的key-value對，並返回value
         void clear()：清空當前map中的所有數據
     元素查詢的操作：
         Object get(Object key)：獲取指定key對應的value
         boolean containsKey(Object key)：是否包含指定的key
         boolean containsValue(Object value)：是否包含指定的value
         int size()：返回map中key-value對的個數
         boolean isEmpty()：判斷當前map是否為空
         boolean equals(Object obj)：判斷當前map和參數對象obj是否相等
     元視圖操作的方法：
         Set keySet()：返回所有key構成的Set集合
         Collection values()：返回所有value構成的Collection集合
         Set entrySet()：返回所有key-value對構成的Set集合

 */

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMethods {
    @Test
    public void test1(){
        Map map = new HashMap();
        System.out.println("=======================Object put(key,value)=======================");
        map.put("021",5);
        map.put("052",15);
        map.put("043",25);
        map.put("004",6);
        map.put("021",9); //修改
        System.out.println(map);

        System.out.println("=======================void putAll(Map m)=======================");
        Map map1 = new HashMap();
        map.put("001",88);
        map.put("005",9);
        map.putAll(map1);
        System.out.println(map);

        System.out.println("=======================Object remove(Object key)=======================");
        Object value = map.remove("001");
        System.out.println(map);
        System.out.println(value);

        System.out.println("=======================void clear()=======================");
        map.clear();
        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("021",5);
        map.put("052",15);
        map.put("043",25);
        map.put("004",6);

        System.out.println("=======================Object get(Object key)=======================");
        System.out.println(map.get("021"));

        System.out.println("=======================boolean containsKey(Object key)=======================");
        boolean isKeyExist = map.containsKey("43");
        System.out.println(isKeyExist);

        System.out.println("=======================boolean containsValue(Object value)=======================");
        boolean isValueExist = map.containsValue(5);
        System.out.println(isValueExist);

        System.out.println("=======================int size()=======================");
        System.out.println(map.size());

        System.out.println("=======================boolean isEmpty()=======================");
        System.out.println(map.isEmpty());

        System.out.println("=======================boolean equals(Object obj)=======================");
        Map map1 = new HashMap();
        map1.put("021",5);
        map1.put("043",25);
        System.out.println(map.equals(map1));

    }

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("021",5);
        map.put("052",15);
        map.put("043",25);
        map.put("004",6);


        System.out.println("=======================Set keySet()=======================");
        Set set = map.keySet();

        for (Object key:
             set) {
            System.out.println(key);
        }


        System.out.println("=======================Collection values()=======================");
        Collection values = map.values();

        for (Object value:
             values) {
            System.out.println(value);
        }

        System.out.println("=======================Set entrySet()=======================");
        Set entrySet = map.entrySet();

        for (Object entry:
                entrySet) {
            System.out.println(entry);
        }
    }
}
