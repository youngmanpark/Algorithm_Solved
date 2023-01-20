package CD8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Proc8_5 {
    public int[] solution(int[][] tasks) {
        int n = tasks.length;
        LinkedList<int[]> programs = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int curT = 0;
        while (!programs.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty())
                curT = Math.max(curT, programs.peek()[0]);
            while (!programs.isEmpty() && programs.peek()[0] <= curT) {
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] e = pq.poll();
            curT = curT + e[0];
            res.add(e[1]);
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Proc8_5 T = new Proc8_5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {4, 2}, {3, 1}})));
    }
}
