package CD4;

import java.util.*;

public class Proc4_5 {
    public int solution(int n, int[][] meetings) {
        int answer = 0;
        int[] cnt = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            rooms.add(i);
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] x : meetings) {
            while (!pq.isEmpty() && pq.peek()[0] <= x[0]) rooms.add(pq.poll()[1]);
            int[] tmp;
            if (!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                cnt[room]++;
                pq.add(new int[]{x[1], room});
            } else {
                tmp = pq.poll();
                cnt[tmp[1]]++;
                pq.add(new int[]{tmp[0] + x[1] - x[0], tmp[1]});
            }

        }
        int max=0;

        for (int i = 0; i < n; i++  ) {
            max = Math.max(max, cnt[i]);
            if(max<cnt[i]){
                max = cnt[i];
                answer = i;
            }
        }
        for(int i=0;i<cnt.length;i++){
            if(cnt[i] == max) {
                answer = i;
                break;

            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Proc4_5 T = new Proc4_5();
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14},{15, 20}}));

    }
}
