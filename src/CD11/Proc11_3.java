package CD11;

import java.util.Arrays;

public class Proc11_3 {
    public int[] solution(int[]enter, int[] exit) {
        int n = enter.length;
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }
        int[] enterIdx = new int[n];
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }
        int[] enterT = new int[n];
        int[] exitT = new int[n];

        int cnt = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Proc11_3 T = new Proc11_3();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
    }
}
