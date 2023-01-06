package CD3.CD_6;

import java.util.*;

class Solution {

    public int Count(int[]nums,int len  ){
        int cnt = 0;
        for(int x:nums){
            cnt += Math.floor(x / len);
        }
        return cnt;

    }
    public int solution(int[] nums, int k) {
        int answer = 0;
        int left = 1;
        int right =  Arrays.stream(nums).max().getAsInt();

        while(left<=right){
            int mid = (left + right) / 2;
            if (Count(nums,mid) >= k) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return answer;

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{802, 743, 457, 539},11));
    }
}
