package CD4;

import java.util.Arrays;

public class Proc4_1 {
    public int solution(int[]nums){

        int answer = 0;

        Arrays.sort(nums);
        int right_idx = nums.length - 1;
        int left_idx = 0;

        while (right_idx >= left_idx) {
            if (nums[right_idx] + nums[left_idx] > 5) {
                answer++;
                right_idx--;

            } else {
                answer++;
                left_idx++;
                right_idx--;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Proc4_1 T = new Proc4_1();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));

    }
}
