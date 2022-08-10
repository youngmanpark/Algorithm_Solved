package BOJ.DP_2156;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=fr.nextInt();
        }

        dp[1]=arr[1];
        if(n>1){
            dp[2]=arr[1]+arr[2];
        }

        for(int i=3;i<=n;i++){
            dp[i] =max(dp[i-1], max(dp[i-2],dp[i-3]+arr[i-1])+arr[i]);
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
