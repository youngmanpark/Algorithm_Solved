package CD4;

import java.util.ArrayList;

public class Proc4_3 {
    public int solution(int[]plantTime,int[]growTime) {
        int answer = 0;
        int n = plantTime.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++ ){
            list.add(new int[]{plantTime[i],growTime[i]});
        }
        list.sort((a,b)->b[1]-a[1]);

//        int[][] arr = new int[plantTime.length][2];
//        for (int i = 0; i<plantTime.length;i++) {
//            arr[i][0] = plantTime[i];
//            arr[i][1] = growTime[i];
//        }
//        Arrays.sort(list,(a,b)->b[1]-a[1]);

        int start = 0, end = 0;
        for(int[]x:list){
            end = start + x[0] + x[1];
            answer = Math.max(answer, end);
            start += x[0];
        }
        return answer;

    }

    public static void main(String[] args) {
        Proc4_3 T = new Proc4_3();
        System.out.println(T.solution(new int[]{1,3,2},new int[]{2,3,2}));

    }
}
