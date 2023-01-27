package CD11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Proc11_5 {
    class Solution {
        public long[] solution(int[][] program) {

            long[] answer = new long [11];
            int n=program.length;
            ArrayList<Integer> res =new ArrayList<>();
            LinkedList<int []> programs =new LinkedList<>();
            for(int i=0;i<n;i++){
                programs.add(new int []{program[i][0],program[i][1],program[i][2]});
            }
            programs.sort((a,b)->a[1]-b[1]);
            PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
            long curT=0;
            while(!programs.isEmpty()||!pq.isEmpty()){
                if(pq.isEmpty())
                    curT=Math.max(curT,programs.peek()[1]);
                while(!programs.isEmpty()&&programs.peek()[1]<=curT){
                    int []x=programs.pollFirst();
                    pq.offer(new int []{x[0],x[1],x[2]});
                }
                int []ex=pq.poll();
                answer[ex[0]]+=(curT-ex[1]);
                curT=curT+ex[2];
            }
            answer[0]=curT;

            return answer;
        }
    }
}
