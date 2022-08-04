package BOJ.DP_9461;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int testcase = fr.nextInt();

        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int k = 0; k < testcase; k++) {

            int n=fr.nextInt();

            for (int i = 4; i < n + 1; i++) {

                dp[i] = dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);

        }
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