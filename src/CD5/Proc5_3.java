package CD5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Proc5_3 {
    public int solution(int []nums,int k) {
        int answer = 0;
        Arrays.sort(nums);
        int sum = 0;
        int left=0;
        for (int right = 0; right<nums.length;right++) {
            sum += nums[right];
            while (nums[right] * (right - left +1) > sum + k) {
                sum -= nums[left];
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }


        return answer;

    }
    public static void main(String[] args) {
        Proc5_3 T = new Proc5_3();
        System.out.println(T.solution(new int[]{1,2,4,7},5));
    }
}
