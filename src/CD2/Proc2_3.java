package CD2;


import java.util.HashMap;

class Proc2_3 {
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
        Proc2_3 T = new Proc2_3();
        int[] arr  = {2, 5, 3, 4, 2, 3};
        System.out.println(T.solution(arr,3));

    }
}