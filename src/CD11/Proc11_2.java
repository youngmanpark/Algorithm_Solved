package CD11;

import java.util.PriorityQueue;

public class Proc11_2 {
    public int solution(int[][]board, int []s, int []e) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{s[0], s[1], 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]][cur[1]] = true;

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int x = cur[0];
                int y = cur[1];
                int len = cur[2];

                while (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 0) {//공이 쭉굴러가기
                    x += dir[0];
                    y += dir[1];
                    len++;
                    if (x == e[0] && y == e[1])
                        return len;
                }

                x -= dir[0];
                y -= dir[1];
                len--;

                if (!visited[x][y]) {
                    pq.offer(new int[]{x, y, len});

                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Proc11_2 T = new Proc11_2();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
    }
}
