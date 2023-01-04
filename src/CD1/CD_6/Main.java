package CD1.CD_6;


import java.util.Arrays;

class Solution{
    public int solution (int []keypad, String pwd){
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int x=0,y=0;
        int[][] pad = new int[3][3];
        int[][] check = new int[10][10];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }
        for (int i = 0; i < 10; i++) {
            Arrays.fill(check[i],2);
            check[i][i] = 0;
        }
        int from,to;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                from = pad[i][j];
                for (int k = 0; k<8;k++) {//인접한 8방향
                    x = i + dx[k];
                    y = j + dy[k];
                    if (x >= 0&&y>=0&&x<3&&y<3) {
                        to = pad[x][y];
                        check[from][to] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < pwd.length(); i++) {
            answer += check[(int) pwd.charAt(i - 1) - 48][(int) pwd.charAt(i) - 48];
        }


        return answer;

    }
    public static void main(String []args){
        Solution T = new Solution();
        int[] arr = {2, 5, 3, 7, 1, 6, 4, 9, 8};
        System.out.println(T.solution(arr,"7596218"));

    }
}