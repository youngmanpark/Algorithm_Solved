
package CD3.CD_1;

import java.util.*;
class Solution {
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length];
		int[][] res = new int[nums.length][2];
		for(int i = 0; i < nums.length; i++){
			int cnt = 0;
			int tmp = nums[i];
			while(tmp > 0){ //2로 나누어 (2진수이니)0이될때까지  진행하면 나머지들의 개수가 곧 1의 개수
				cnt += (tmp % 2);
				tmp = tmp / 2;
			}
			res[i][0] = cnt;
			res[i][1] = nums[i];
		}
		Arrays.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		for(int i = 0; i < res.length; i++){
			answer[i] = res[i][1];
		}
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();

        System.out.println(Arrays.toString(T.solution(new int[]{5,6,7,8,9})));
	}
}
