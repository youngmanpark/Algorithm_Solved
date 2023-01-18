package CD_8;

import java.util.LinkedList;
import java.util.Queue;

public class Proc8_4 {
    public int getTime(String s) {
        int HH, MM;
        HH = Integer.parseInt(s.split(":")[0]);
        MM = Integer.parseInt(s.split(":")[1]);
        return HH * 60 + MM;


    }
    public int solution(int []laser,String []enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for (int i=0;i<n;i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0]=a;
            inList[i][1]=b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]); //레이저 번호
        int fT = inList[0][0]; //끝나는 시간
        int pos = 1;

        for (int t = fT; t<getTime("20:00");t++) {
            if (pos < n && t == inList[pos][0]) {
                if(inList[pos][0]>fT) fT = inList[pos][0]; //이조건 중요
                Q.offer(inList[pos][1]);
                pos++;
            }

            if(t==fT&&!Q.isEmpty()) {
                int idx = Q.poll();
                fT += laser[idx];
            }

            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        Proc8_4 T = new Proc8_4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15},new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3",
                "15:10 0", "15:20 3", "15:22 1", "15:23 0",
                "15:25 0"}));
    }
}
