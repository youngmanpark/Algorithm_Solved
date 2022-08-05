package BOJ.DP_1932;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                arr[i][j] = fr.nextInt();
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){

                dp[i][j]=max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(max<dp[n][i]) max=dp[n][i];
        }
        System.out.println(max);


    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

