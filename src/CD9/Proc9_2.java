package CD9;

import java.util.*;

public class Proc9_2 {
    public int solution(int[][] routes, int s, int e) {
        int answer = 0;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new HashSet<Integer>());
                graph.get(routes[i][j]).add(i);
            }
        }
        Queue<Integer> Q = new LinkedList();
        Q.offer(s);
        int L = 0;

        int[] ch = new int[routes.length];
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int curStop = Q.poll();
                for (int line : graph.get(curStop)) {
                    if(ch[line]==1 ) continue;
                    ch[line] = 1;
                    for (int stop : routes[line]) {
                        if(stop==e) return L;
                        Q.offer(stop);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Proc9_2 T = new Proc9_2();
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7, 9, 11}, {10, 3, 14}, {8, 5, 6}, {2, 7, 13}, {10, 8, 2, 17}, {14, 5, 2, 12}}, 1, 12));

    }
}
