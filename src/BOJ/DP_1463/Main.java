package BOJ.DP_1463;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int n= fr.nextInt();
        int []dp=new int[n+1];
        dp[0]=dp[1]=0;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0)
                dp[i] = min(dp[i], dp[i / 2] + 1);
            if(i%3==0)
                dp[i] = min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);

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