package BOJ.IMPL_2563;


import java.util.Scanner;

public class Main {

    static int a, n, m;

    static int[][] arr;

    public static void main(String[] args) {

        arr = new int[100][100];
        int cnt=0;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        for(int i=0;i<a;i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int k = 0; k < 10; k++) {
                for(int j=0;j<10;j++) {
                    arr[n + k][m + j] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
               if(arr[i][j]==1)
                   cnt++;
            }
        }
        System.out.println(cnt);
    }
}
