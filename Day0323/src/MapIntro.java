/*
    Map接口概述
         Map与Collection并列存在。用于保存具有映射关系的数据:key-value
         Map 中的 key 和 value 都可以是任何引用类型的数据
         Map 中的 key 用Set来存放，不允许重复，即同一个 Map 对象所对应
        的类，须重写hashCode()和equals()方法
         常用String类作为Map的“键”
         key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到
        唯一的、确定的 value
         Map接口的常用实现类：HashMap、TreeMap、LinkedHashMap和
        Properties。其中，HashMap是 Map 接口使用频率最高的实现类
        HashMap的底層使用:數組+鍊表(jdk7前)
                         數組+鍊表+紅黑樹(jdk8後)


        HashMap:是Map的主要實現類,線程不安全,效率高:可以存儲null的key與value
            LinkedHashMap:保證在遍歷map時可以依照添加順序遍歷。
        TreeMap:保證按照添加的key-value對進行排序,實現遍歷順序。底層使用紅黑樹。
        Hashtable:是Map的古老實現類,線程安全,效率低:不能存儲null的key與value。
            Properties:常用來處理配置文件。key和value都是String類型。


        Map的結構理解:
            Map中的key:無序的,不可重複的,使用Set存儲所有key。 ----> key所在的類要重寫equals()與hashCode()
            Map中的value:無序的,可重複的,使用collection存儲所有value。 -----> value所在類要重寫equals()
            一個鍵值對(entry):key-value構成一個Entry物件。
            Map中的Entry:無序的,不可重複的,使用Set存儲所有entry。


        =================================HashMap的底層實現原理==================================
        jdk7之前:
            HashMap map = new HashMap();
            在實例化後,底層創造了一個長度為16的Entry[] table
            ....
            map.put(keyN,valueN):
            ====================================put的流程=====================================
            首先,調用keyN所在類的hashCode()決定此Entry在數組中的存放位置。
            如果此位置上的數據為空,此時keyN-valueN添加成功。----------------------情況一
            若此位置存在其他數據(多個以鏈表存在),比較這些數據與keyN的哈希值:
                keyN與其他數據皆不同:添加成功。---------------------------------情況二
                keyN與其他數有相同:調用equals()比較:
                    兩者不同:添加成功。----------------------------------------情況三
                    兩者相同:用valueN去替換keyN(相同者)的value值。---------------情況四

            情況二三時:keyN-valueN和原來的數據以鏈表方式存儲。
            ....
            在不斷添加的過程中,會涉及到擴容問題,默認的擴容方式會擴容到原來的2倍。

        jdk8之後與之前的不同處:
            1.new HashMap():底層沒有創建一個長度為16的數組。
            2.jdk8底層使用Node[],而非Entry[]。
            3.首次使用put()時,創建長度為16的Node[]。
            4.jdk7底層結構只有:數組+鏈表。
              jdk8中結構有:數組+鏈表+紅黑樹。
              當在Node[]中有一個位置的鏈表元素>8,且Node[]長度>64時,
              此位置上的所有數據改用紅黑樹存儲。(更方便於查詢)

              ===============================HashMap源碼中的重要常量=============================
                DEFAULT_INITIAL_CAPACITY : HashMap的默認容量，16
                MAXIMUM_CAPACITY ： HashMap的最大支持容量，2^30
                DEFAULT_LOAD_FACTOR：HashMap的默認加載因子
                TREEIFY_THRESHOLD：Bucket中鍊錶長度大於該默認值，轉化為紅黑樹
                UNTREEIFY_THRESHOLD：Bucket中紅黑樹存儲的Node小於該默認值，轉化為鍊錶
                MIN_TREEIFY_CAPACITY：桶中的Node被樹化時最小的hash表容量。 （當桶中Node的
                數量大到需要變紅黑樹時，若hash表容量小於MIN_TREEIFY_CAPACITY時，此時應執行
                resize擴容操作這個MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4
                倍。 ）
                table：存儲元素的數組，總是2的n次冪
                entrySet：存儲具體元素的集合
                size：HashMap中存儲的鍵值對的數量
                modCount：HashMap擴容和結構改變的次數。
                threshold：擴容的臨界值，= 容量*填充因子
                loadFactor：填充因子





 */
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapIntro {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put("021",5);
        map.put("052",15);
        map.put("043",25);
        map.put("004",6);

        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new LinkedHashMap();
        map.put("021",5);
        map.put("052",15);
        map.put("043",25);
        map.put("004",6);

        System.out.println(map);
    }
}
