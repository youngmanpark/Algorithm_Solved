package BOJ.BT_15650;

import java.util.Scanner;

public class Main {
    static int n, m;

    static int[] arr;

    static void dfs(int at, int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i < n; i++) {
            arr[depth] = i + 1;
            dfs(i+ 1, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(0, 0);


    }
}