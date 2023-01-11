package CD4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Proc4_6 {
        public int solution(int n, int[][] trains, int[][] bookings){
            int answer=0;
            int[] sum = new int[n+1];
            for(int[] x : trains){ //기차 정보를 통해 내리는 구간 확인해서 인원수 더하기
                sum[x[0]] += x[2];//탑승구간 인원만큼 더하기
                sum[x[1]] -= x[2];//하차 구간 인원만큼 뺴기
            }
            for(int i = 1; i <= n; i++){//누적합을 해서 각 구간마다 총 최대 탑승인원 구하기
                sum[i] += sum[i-1];
            }

            Arrays.sort(bookings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 정렬
            LinkedList<Integer> nums = new LinkedList<>();
            int ix = 0;
            for(int i = 1; i <= n; i++){
                while(!nums.isEmpty() && nums.peek() == i){// i번역에서 내릴사람
                    answer++;
                    nums.pollFirst();
                }
                while(ix < bookings.length && bookings[ix][0] == i){//i번역에ㅓ 탈사람
                    nums.add(bookings[ix][1]);
                    ix++;
                }
                Collections.sort(nums);// 정렬 후
                while(nums.size() > sum[i]){//열차 최대탑승인원 보다 많을 경우 젤 늦게 내리는 사람 뺴기
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
