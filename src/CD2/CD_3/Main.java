package CD2.CD_3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution{
    public int solution (int []arr,int m){
        int answer=0,sum=0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            sum += x;
            if (sum == m)
                answer++;

            if (map.containsKey(sum - m))
                answer += map.get(sum - m);

            map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return answer;

    }
    public static void main(String []args){
        Solution T = new Solution();
        int[] arr  = {1, 2, 3, -3, 1, 2};
        System.out.println(T.solution(arr,3));

    }
}