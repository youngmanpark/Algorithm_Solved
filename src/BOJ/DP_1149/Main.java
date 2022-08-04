package BOJ.DP_1149;


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    final static int Red=0;
    final static int Green=1;
    final static int Blue=2;

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int n = fr.nextInt();

        int [][]cost=new int[n][3];

        for(int i=0;i<n;i++){
            cost[i][Red]=fr.nextInt();
            cost[i][Green]=fr.nextInt();
            cost[i][Blue]=fr.nextInt();

        }

        for(int i=1;i<n;i++){
            cost[i][Red]+= min(cost[i-1][Green],cost[i-1][Blue]);
            cost[i][Green]+= min(cost[i-1][Red],cost[i-1][Blue]);
            cost[i][Blue]+= min(cost[i-1][Red],cost[i-1][Green]);
        }

        int min_cost= min(min(cost[n-1][Red],cost[n-1][Green]),cost[n-1][Blue]);
        System.out.println(min_cost);

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
