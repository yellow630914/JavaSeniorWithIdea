import org.junit.Test;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test(){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //Ver 抄來的
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0; //當s的長度等於0,返回0
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); //用於放置待比對的char,key值是char,value是座標
        int max = 0; //放置最大的不重複字串的長度
        int left = 0; //慢慢向右限縮的指針
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){ //先測定map中是否有相同於char[i]的值
                //若有,將指針移到前一個與char[i]同值的座標加一位,代表計算max的起始點重置了
                //例如:abca,移到第2個a時觸發此行,因此將left移到第一個a的右邊
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i); //將char[i]放入map中
            //left可以看做起始點,i看作現在的位置,i-left+1是代表left到i位置時的不重複字串長度,如果比max還大,則刷新max
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
