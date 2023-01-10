package CD3;

import java.util.*;

class Proc3_4 {

    public int solution(int[] board, long k) {
        int answer=0;
        int rest= board.length;
        ArrayList<Integer> sT = new ArrayList<>();
        sT.add(0, 0);
        for(int i=1;i<board.length+1;i++) {
            sT.add(i, board[i - 1]);
        }
        Collections.sort(sT);

        for (int i=1;i<sT.size();i++) {
            int cho = rest * (sT.get(i) - sT.get(i - 1));
            if(k<cho) {
                k = k % rest;
                int cnt=0;
                for (int j = 0; j < board.length; j++) {
                    if (board[j] >= sT.get(i)) {
                        if(cnt==k)
                            return  j+1;
                        cnt++;
                    }
                }
            }
            else {
                k -= cho;
                rest--;
            }
        }

        return -1 ;

    }

    public static void main(String[] args) {
        Proc3_4 T = new Proc3_4();
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7},30));
    }
}
