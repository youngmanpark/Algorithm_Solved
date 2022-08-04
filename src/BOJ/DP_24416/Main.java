package BOJ.DP_24416;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt,dpcnt;
    static int []dp;

    public static void main(String[] args) {

        FastReader fr= new FastReader();

        n=fr.nextInt();
        dp=new int[n+1];

        fib(n);
        fibonacci(n);

        System.out.println(cnt + " "+dpcnt );
    }

    static int fib(int n){
        if(n==1||n==2){
            cnt ++;
            return 1;
        }
        else {

            return fib(n-1)+fib(n-2);
        }
    }
    static int fibonacci(int n){
        dp[1]=1;
        dp[2]=1;
        for(int i=2;i<n;i++){
            dpcnt++;
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
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