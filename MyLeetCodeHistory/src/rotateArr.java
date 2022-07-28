import org.junit.Test;

import java.util.Arrays;

public class rotateArr {
    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public void rotate(int[] nums, int k) {
        int[] tempNums = Arrays.copyOf(nums,nums.length);
        int delta = k%nums.length;
        for(int i = 0;i < nums.length;i++){
            if(i + delta >= nums.length){
                nums[delta - ((nums.length)-i)] = tempNums[i];
            }else{
                nums[i + delta] = tempNums[i];
            }
        }
        return;
    }
}
