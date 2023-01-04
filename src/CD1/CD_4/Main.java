package CD1.CD_4;


import java.util.Arrays;

class Solution{
    public String solution (int c, int r, int k){
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int nx, ny,x=0,y=0, d = 1;
        int arr[][] = new int[c][r];

        arr[0][0] = 1;
        int cnt = 1;
        while (k>cnt){

            nx = x + dx[d];
            ny = y + dy[d];

            if(nx>=c||nx<0||ny<0||ny>=r||arr[nx][ny]==1) {
                d = (d + 1) % 4;
                continue;
            }

            arr[x][y] = 1;
            cnt++;
            x = nx;
            y = ny;



        }

            answer[0] = x+1;

            answer[1] = y+1;



        return Arrays.toString(answer);

    }
    public static void main(String []args){
        Solution T = new Solution();

        System.out.println(T.solution(6,5,12));

    }
}