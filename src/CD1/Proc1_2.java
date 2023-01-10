package CD1;
import java.util.Arrays;

class Proc1_2 {
    public String solution (int [][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int nx, ny, x = 0, y = 0, d = 1;
        int cnt = 0;

        while (k>cnt){
            cnt++;
            nx = x + dx[d];
            ny = y + dy[d];
            if(nx>=n||nx<0||ny<0||ny>=n||board[nx][ny]==1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;

        }
        answer[0] = x;

        answer[1] = y;

        return Arrays.toString(answer);

    }
    public static void main(String []args){

       Proc1_2 T = new Proc1_2();
        int[][] arr = {{0, 0, 0, 0,0},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,0,1,0,1},
                {0,0,0,0,0}};
        System.out.println(T.solution(arr,10));

    }
}