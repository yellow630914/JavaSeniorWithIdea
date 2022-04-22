import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    //第一版

    @Test
    public void test(){
        String[] strs = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int minStrLength = 201;

        //找到最小長度的String
        if(minStrLength == 201){
            for (String str:
                    strs) {
                if(str.length() < minStrLength) minStrLength = str.length();
            }
        }


        List<Character> commonStr = new ArrayList<>();
        for (int i = 0; i < minStrLength; i++) {
            //以第一個strs的第i個字符為基點
            char commonChar = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                //測定其他strs第i個位置的字符是否相同
                if(strs[j].charAt(i) == commonChar){
                    continue;
                }else{
                    //若發現不相同,輸出已確定相同的前綴
                    return charListToString(commonStr);
                }
            }
            //若皆相同則將字符加入相同的前綴
            commonStr.add(commonChar);
        }
        return charListToString(commonStr);
    }

    private static String charListToString(List<Character> characterList){
        StringBuffer stringBuffer = new StringBuffer();
        for (Character c:
             characterList) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
