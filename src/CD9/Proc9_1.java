package CD9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Proc9_1 {
    public int solution(int n ,int [][]flights,int s,int e,int k) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }
        int[] cost = new int[n];
        Arrays.fill(cost, 1000000);
        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1],x[2]});//출발지 목적지 간선정보
        }
        Queue<int []> Q = new LinkedList();
        Q.offer(new int[]{s, 0});
        int L=0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] p = Q.poll();
                int now = p[0];//현재 정점
                int nowCost = p[1];//현재 정점에서의 cost
                for (int[] x : graph.get(now)) {
                    int next = x[0]; //다음 목적지
                    int nextCost = x[1]; //다음 목적지 까지의 cost
                    if (cost[next] > nowCost + nextCost) {
                        cost[next] = nowCost + nextCost;
                        Q.offer(new int[]{next,cost[next]});
                        System.out.println(next+" "+cost[next]);
                    }
                }
            }
            System.out.println(Q.size());
            L++;
            if(L>k) break;

        }
        answer = cost[e];
        return answer;

    }
    public static void main(String[] args) {
        Proc9_1 T = new Proc9_1();
        System.out.println(T.solution(5,new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}},0,3,1));
    }
}
