package CD5;


import java.util.HashMap;

public class Proc5_1 {
    public int solution(int[] nums) {
        int answer = 0;
        int[] nH = new int[2];
        int sum = 0;
//        nH[0] = 1;
        for (int x : nums) {
            sum += x;
            if (sum % 2 == 1) answer++;
            if (sum % 2 == 1)
                answer += nH[0];
            else answer += nH[1];
            nH[sum % 2] += 1;
        }
        return answer;

    }

    public static void main(String[] args) {
        Proc5_1 T = new Proc5_1();
        System.out.println(T.solution(new int[]{1, 3, 5}));
    }
}
