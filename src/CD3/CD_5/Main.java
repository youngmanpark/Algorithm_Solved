package CD3.CD_5;

import java.util.*;

class Solution {

    public int solution(int[] nums, int k) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length + 1;
        while(left<=right){
            int mid = (left + right) / 2;
            if (nums[mid] == k) {
                answer = mid + 1;
                break;

            }
            if(nums[mid]>k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return answer;

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{23, 87, 65, 12, 57, 32, 99, 81},32));
    }
}
