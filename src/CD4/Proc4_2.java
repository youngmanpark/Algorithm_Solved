package CD4;

import java.util.ArrayList;
import java.util.Map;

public class Proc4_2 {
    public int solution(int[][]nums){
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] x : nums) {
            list.add(new int[]{x[0],2});
            list.add(new int[]{x[1],1});
        }
        list.sort((a,b)->a[0]==b[0]? a[1]-b[1]:a[0]-b[0]);

        int cnt = 0;
        for(int[] x:list){
            if(x[1]==2) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;

    }

    public static void main(String[] args) {
        Proc4_2 T = new Proc4_2();
        System.out.println(T.solution(new int[][]{{0, 10}, {12, 25}, {5, 15}}));

    }
}
