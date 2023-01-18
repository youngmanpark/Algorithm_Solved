package CD_8;

import java.util.HashSet;

public class Proc8_1 {
    public int solution(int []nums){
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        for (int x : set) {
            int cnt = 0;
            if(set.contains(x-1)) continue;
            while (set.contains(x)) {
                x++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        Proc8_1 T = new Proc8_1();
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
    }
}
