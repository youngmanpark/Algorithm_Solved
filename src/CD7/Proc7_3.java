//package CD7;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Proc7_3 {
//    public int solution(int[][] board) {
//        int[][] ch = new int[2][200001];
//        Queue<int[]> Q = new LinkedList<>();
//        int[][] dist = new int[7][7];
//        Q.offer(new int[]{0, 0});
//        int L = 0;
//        while (!Q.isEmpty()) {
//            int len = Q.size();
//            L++;
//            for (int i = 0; i < len; i++) {
//                int[] p = Q.poll();
//                for (int k = 0; k < 4; k++) {
//
//                }
//            }
//        }
//    }
//        return-1;
//}
//
//    public static void main(String[] args) {
//        Proc7_3 T = new Proc7_3();
//        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 0, 0, 0}}));
//    }
//}
