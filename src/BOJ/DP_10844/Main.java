package BOJ.DP_10844;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        long mod=1000000000;
        int n = fr.nextInt();
        long[][] dp = new long[n+1][10];


        for(int i=1;i<10;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=n;i++){
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    dp[i][j] = (dp[i - 1][j + 1]) % mod;
                else if (j == 9)
                    dp[i][j] = (dp[i - 1][j - 1]) % mod;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long result=0;
        for(int i=0;i<10;i++){
            result+=dp[n][i];
        }
        System.out.println(result%mod);


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