package CD7;

import java.util.LinkedList;
import java.util.Queue;

public class Proc7_1 {


    public int solution(int[]pool,int a,int b ,int home){
        int answer = 0;
        Queue<int[]> Q = new LinkedList<>();
        int[][] ch = new int[10000][10000];
        ch[0][1] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0});
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                if(cur[0]==home) return L;
                int nx = cur[0] + a;
                if (nx <= 10001 && ch[0][nx] == 0) {
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if (nx >= 0 && ch[1][nx] == 0 && cur[1] == 0) {
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Proc7_1 T = new Proc7_1();
        System.out.println(T.solution(new int[]{11,7,20},3,2,10));
    }
}
