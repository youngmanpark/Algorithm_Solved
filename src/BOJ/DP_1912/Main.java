package BOJ.DP_1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();
        int[] arr = new int[n];
        int []dp= new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        dp[0]=arr[0];
        int max=arr[0];

        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
            max=Math.max(dp[i],max);
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
