package CD3.CD_3;


import java.util.*;

class Solution {

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++  ) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a, b) -> a - b);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i)+" "+col.get(i));
            answer += Math.abs(x - row.get(i));
            answer += Math.abs(y - col.get(i));
        }


        return answer;

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1},{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1,0,0,0,1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}}));
        System.out.println(T.solution(new int[][]{{1, 0,0, 0, 1, 1}, {0, 1, 0 ,0,1,0}, {0, 1,0, 0, 0, 0},{0, 0, 0, 0,1, 0}, {0, 0, 0, 0, 0,1},{1, 0, 0, 0, 1, 1}}));
    }
}
