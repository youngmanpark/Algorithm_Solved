package CD4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Proc4_6 {
        public int solution(int n, int[][] trains, int[][] bookings){
            int answer=0;
            int[] sum = new int[n+1];
            for(int[] x : trains){
                sum[x[0]] += x[2];
                sum[x[1]] -= x[2];
            }
            for(int i = 1; i <= n; i++){
                sum[i] += sum[i-1];
            }
            int bN = bookings.length;
            Arrays.sort(bookings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            LinkedList<Integer> nums = new LinkedList<>();
            int ix = 0;
            for(int i = 1; i <= n; i++){
                while(!nums.isEmpty() && nums.peek() == i){
                    answer++;
                    nums.pollFirst();
                }
                while(ix < bN && bookings[ix][0] == i){
                    nums.add(bookings[ix][1]);
                    ix++;
                }
                Collections.sort(nums);
                while(nums.size() > sum[i]){
                    nums.pollLast();
                }
            }
            return answer;
        }

        public static void main(String[] args){
            Proc4_6 T = new Proc4_6();
            System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
            System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        }
}
