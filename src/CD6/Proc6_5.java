package CD6;

import java.util.Arrays;

public class Proc6_5 {
    int[][] p, h, y, g, answer;
    int cnt = 0;
    boolean flag = false; //찾아는지
    public int find(int i, int j){//그룹 찾기
        return (i / 3) * 3 + (j / 3);
    }
    public void DFS(int L, int[][] board){
        if(flag) return;
        if(L == cnt){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    answer[i][j] = board[i][j];
                }
            }
            flag = true;
        }
        else{
            int xx = p[0][L];
            int yy = p[1][L];
            int gg = find(xx, yy);
            for(int i = 1; i <= 9; i++){
                if(h[xx][i] == 0 && y[yy][i] == 0 && g[gg][i] == 0) //행과 열과 그룹에 포함 체크
                    h[xx][i] = y[yy][i] = g[gg][i] = 1; //행과 열과 그룹에 대해 방문처리
                    board[xx][yy] = i; //해당 자리에 대해 숫자 집어넣기
                    DFS(L + 1, board);
                    h[xx][i] = y[yy][i] = g[gg][i] = 0;
                    board[xx][yy] = 0;
                }
            }
        }

    public int[][] solution(int[][] board){
        p = new int[2][100]; //빈공간 좌표
        h = new int[10][10]; //행
        y = new int[10][10]; //열
        g = new int[10][10]; //그룹
        answer = new int[9][9];
        for(int i = 0; i < 9; i++){//전체를 돌면서
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0){ //해당자리가 0이면
                    p[0][cnt] = i; //빈공간 좌표 행
                    p[1][cnt++] = j; //빈공간 좌표 열
                }
                else{ //해당 자리가 0이 아니면
                    h[i][board[i][j]] = 1; //행의 해당숫자에 1로 체크
                    y[j][board[i][j]] = 1; //열의 해당숫자에 1로 체크
                    g[find(i, j)][board[i][j]] = 1; //그룹의 해당 숫자 카운팅
                }
            }
        }
        DFS(0, board);
        return answer;
    }
    public static void main(String[] args) {
        Proc6_5 T = new Proc6_5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{0, 2, 3, 0, 5, 0, 7, 8, 9},
                {0, 5, 6, 0, 8, 9, 1, 0, 3},
                {0, 8, 9, 1, 0, 3, 0, 5, 6},
                {0, 1, 0, 0, 6, 0, 8, 9, 0},
                {3, 0, 5, 0, 9, 7, 0, 1, 4},
                {0, 9, 7, 0, 1, 0, 0, 6, 5},
                {5, 3, 0, 6, 0, 2, 9, 7, 8},
                {6, 0, 2, 9, 0, 8, 5, 3, 1},
                {9, 0, 8, 0, 3, 0, 6, 0, 2}})));
    }
}
