package BOJ.BT_15649;

import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] visited ;
    static int[] arr ;

    static void dfs(int depth){
        if(depth==m){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                visited[i]=1;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        visited = new int[n];
        arr = new int[m];

        dfs(0);



    }
}