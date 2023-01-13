package CD6;

import java.util.Stack;

public class Test {
    static Stack<Integer> stack = new Stack<>();


    static int []check;
    public static void dfs(int L,int n, int r) {
        if (L == r) {
            for (int x : stack) {
                System.out.print(x +" ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    stack.push(i);
                    dfs(L + 1,n,r);
                    check[i] = 0;
                    stack.pop();
                }
            }
        }
    }
    public void solution(int n, int r){
        check = new int[n+1];
        dfs(0, n, r);
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println();
        t.solution(3, 2);

    }
}
