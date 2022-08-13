package BOJ.BT_15651;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void dfs( int depth) {
        if (depth == m) {
            for (int i=0;i<m;i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs( depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs( 0);
        System.out.println(sb);


    }
}