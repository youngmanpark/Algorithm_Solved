package CD7;

import java.util.LinkedList;
import java.util.Queue;

public class Proc7_5 {
    public int solution(int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 ||board[i][j]==3) {
                    Q.offer(new int[]{i, j});
                    int[][] ch = new int[n][m];
                    ch[i][j] = 1;
                    int L = 0;
                    while (!Q.isEmpty()) {
                        int len = Q.size();
                        L++;
                        for (int r = 0; r < len; r++) {
                            int[] cur = Q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) {
                                    if (ch[nx][ny] == 0) {
                                        ch[nx][ny] = 1;
                                        dist[nx][ny] += L;
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int answer = 100;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]== 4 && dist[i][j] > 0) answer = Math.min(answer,dist[i][j]);
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }



    public static void main(String[] args) {
        Proc7_5 T = new Proc7_5();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 1, 0, 0},
        {0, 2, 1, 1, 3, 0, 4, 0},
        {0, 0, 1, 4, 1, 1, 1, 0}}));
    }

}
