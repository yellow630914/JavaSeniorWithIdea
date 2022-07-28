import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    @Test
    public void test(){
        int[] nums = {1,1,5,5,6,9,6,4,9,3,2,4,2};

        System.out.println(singleNumberMap(nums));
    }


    //使用排序
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i+=2) {
            Arrays.sort(nums);
            if((i - 1) == nums.length && nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    //使用XOR去解
    public int singleNumberXOR(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    //使用Map
    public int singleNumberMap(int[] nums) {
        //Map<num中的對應數,對應數目前的count>
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            //取得對應數的count
            Integer count = map.get(i);
            //如果count為null ++count
            count = count == null ? 1 : ++count;
            //將對應數與count,put上map
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            //找到count = 1的值
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
}
