package BOJ.DP_1904;


import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) {

        FastReader fr = new FastReader();

        int n=fr.nextInt();
        int []dp= new int[n+1];
        for(int i=3;i<n+1;i++){
            dp[1]=1;
            dp[2]=2;
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]%15746);

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