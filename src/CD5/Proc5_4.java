package CD5;

import java.util.Arrays;

public class Proc5_4 {
    public int solution(int []cost,int m) {
        int answer = 0;
        int sum = 0;
        int left=0;
        for (int right = 0; right<cost.length;right++) {
            sum += cost[right];
            while (sum>m) {
                sum -= cost[left];
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }


        return answer;

    }
    public static void main(String[] args) {
        Proc5_4 T = new Proc5_4();
        System.out.println(T.solution(new int[]{0, 150, 100, 0, 150, 0, 70, 140},350));
    }
}
