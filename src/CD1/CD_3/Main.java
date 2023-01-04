package CD1.CD_3;

class Solution{
    public int solution (int [][] board){
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int nx1, ny1,nx2, ny2, x1 = 0, y1 = 0,x2=0,y2=0, d1 = 0,d2=0;

        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if(board[i][j]==2) {
                    x1 = i; y1 = j;
                }
                if(board[i][j]==3){
                    x2 = i; y2 = j;
                }
            }
        }

        int cnt = 0;


        while (true){
            boolean ischanged1=true;
            boolean ischanged2=true;
            cnt++;
            nx1 = x1 + dx[d1];
            ny1 = y1 + dy[d1];

            nx2 = x2 + dx[d2];
            ny2 = y2 + dy[d2];
            if(nx1>=10||nx1<0||ny1<0||ny1>=10||board[nx1][ny1]==1) {
                d1 = (d1 + 1) % 4;
                ischanged1 = false;

            }
            if(nx2>=10||nx2<0||ny2<0||ny2>=10||board[nx2][ny2]==1) {
                d2 = (d2 + 1) % 4;
                ischanged2 = false;

            }

            if (ischanged1){

                x1 = nx1;
                y1 = ny1;
            }
            if(ischanged2){
                x2 = nx2;
                y2 = ny2;
            }

            if(x1==x2&&y1==y2||cnt>10000){
                break;
            }


        }


        return cnt;

    }
    public static void main(String []args){
        Solution T = new Solution();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(T.solution(arr));

    }
}