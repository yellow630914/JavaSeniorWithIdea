import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    @Test
    public void test(){
        System.out.println(isValid("()"));
    }

    //Ver 1
    public boolean isValid(String s) {
        int l = s.length();
        //若s長度奇數代表不可能閉合。
        if(l % 2 == 1){
            return false;
        }

        char[] chars = s.toCharArray();

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            //檢測第一個是否是右括號
            if(i == 0 && map.containsKey(s.charAt(i))) return false;

            //取得i位的值
            char c = s.charAt(i);

            //當是左括號時,直接放入
            if(!map.containsKey(c)){
                stack.push(c);
            }
            //右括號的情況
            else{
                //當stack中為空,或stack的最外層無法與c相匹配,代表無法閉合。
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                //若匹配則將最外層的左括號彈出
                stack.pop();
            }
        }
        //當stack中的左括號全部彈出,代表完全匹配。
        return stack.isEmpty();

    }
}
