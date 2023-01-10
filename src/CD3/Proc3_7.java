package CD3;

import java.util.*;
class Proc3_7 {
    public int Count(int[] nums, int dist){//배치할 말 마리수
        int cnt = 1;//한마리 박아두고 시작
        int prev = nums[0];//첫번쩨 박아둔 말
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - prev >= dist){//다음 마굿간과 처음 박아둔 마굿간의 거리 비교 시 최대거리(mid)보다 클시
                cnt++;//마구간에 말 박아둠
                prev = nums[i];//전의 말을 다음 마구간으로 박아둠
            }
        }
        return cnt;
    }
    public int solution(int[] nums, int c){
        int answer = 0;
        Arrays.sort(nums);//좌표값 순서대로 정렬
        int left = 1;//1고정
        int right = nums[nums.length - 1];// 배열의 최대값

        while(left <= right){ // 이분 탐색 시작
            int mid = (left + right) / 2;

            if(Count(nums, mid) >= c){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args){
        Proc3_7 T = new Proc3_7();
        System.out.println(T.solution(new int[]{5, 12, 34, 16, 18, 23, 29, 15}, 7));
    }
}