package CD10;

import java.util.LinkedList;
import java.util.Queue;

public class Proc10_3 {
    public int solution(String []s){
        int answer=0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = s.length;
        int m = s[0].length();
        char[][]map=new char[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = s[i].charAt(j);
                map[i][j] = c;
                if(c>=97&& c<=122)
                    cnt++;
            }
        }
        int keys = (1 << cnt)-1;
        Queue<int[]> Q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][keys + 1];
        Q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int L = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for(int i=0;i<size;i++) {
                int[] cur = Q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];

                    if (x >= n || y >= m ||x<0 ||y<0 ||map[x][y]=='#')
                        continue;

                    char c = map[x][y];
                    int ks = addkey(cur[2], c);

                    if(ks==keys)
                        return L + 1;

                    if (visited[x][y][ks])
                        continue;

                    if(c>=65 && c<=90 &&!unlock(cur[2],c))
                        continue;

                    visited[x][y][ks] = true;
                    Q.offer(new int[]{x, y,ks});
                }
            }
            L++;

        }
        return -1;
    }

    private boolean unlock(int keys, int c) {
        int index = c - 65;
        return (keys & (1 << index)) > 0;
    }

    private int addkey(int keys, int c) {
        if (c >= 97 && c <= 122) {
            int index = c - 97;
            return keys | (1 << index);
        }
        return keys;
    }

    public static void main(String[] args) {
        Proc10_3 T = new Proc10_3();
        System.out.println(T.solution(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));

    }
}
