//package CD11;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Proc11_1 {
//    public int[] solution(int[] arrival, int[] state) {
//        int t = 0;
//
//        Queue<Integer> enterQ = new LinkedList<>();
//        Queue<Integer> exitQ = new LinkedList<>();
//
//        int n, prev = -1;
//        int[] answer = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            if (enterQ.isEmpty() && exitQ.isEmpty() && t++) {
//
//                return answer;
//            }
//            while (i < n && arrival[i] <= t) {
//                if (state[i] ==)
//                    enterQ.offer(i);
//                else exitQ.offer(i);
//                i++;
//            }
//            if (prev == -1) {
//                if (!exitQ.isEmpty()) {
//                    answer[exitQ.poll()] = t;
//                    prev = 1;
//                } else if (!enterQ.isEmpty()) {
//                    answer[enterQ.offer(i)] = t;
//                    prev = 0;
//                }
//            } else if (prev == 0) {
//                if (!enterQ.isEmpty()) {
//                    answer[enterQ.poll()] = t;
//                    prev = 0;
//                }else {
//                    answer[exitQ.poll()] = t;
//                    prev = 1;
//                }
//            }else {
//                if (!exitQ.isEmpty()) {
//                    answer[exitQ.poll()] = t;
//                    prev = 1;
//                }else {
//                    answer[enterQ.poll()] = t;
//                    prev = 0;
//                }
//            }
//            cnt++;
//            if(cnt==n)
//                break;
//        }
//        return answer;
//
//    }
//
//    public static void main(String[] args) {
//        Proc11_1 T = new Proc11_1();
//        System.out.println(T.solution(new int[]{0, 1, 1, 1, 2, 3, 7}, new int[]{1, 0, 0, 1, 0, 1, 1}));
//    }
//}
