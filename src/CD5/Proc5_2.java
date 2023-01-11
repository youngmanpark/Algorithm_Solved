package CD5;

import javax.swing.*;
import java.util.Arrays;

public class Proc5_2 {
    public String[] solution(int[] nums) {
        String[] answer = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int t = 1;
            n--;
            for (int j = 1; ; j++) {
                if (n >= 9 * t)
                    n = n - (9 * t);
                else {
                    int len = (j + 1) / 2;
                    int[] res = new int[100];
                    String pal = "";
                    res[0] = 1;
                    for (int k = 0; k < len; k++) {
                        res[k] += (n / t);
                        pal += String.valueOf(res[k]);
                        n = n % t;
                        t = t / 10;
                    }

                    for (int k = len - 1 - (j % 2); k >= 0; k--) {
                        pal += String.valueOf(res[k]);
                    }
                    answer[i] = pal;
                    break;

                }
                if (j % 2 == 0)
                    t = t * 10;

            }

        }
        return answer;

    }

    public static void main(String[] args) {
        Proc5_2 T = new Proc5_2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 12, 24})));
    }
}
