package CD10;

public class Proc10_1 {
    int answer,n;
    int [] pow;
    int[] student;

    public void dfs(int s, int sum, int T) {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if ((sum & student[i]) == student[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            answer++;
        }
        for (int i = s; i <= T; i++) {
            dfs(i + 1, sum + pow[i], T);
        }
    }
    public int solution(int T, int[][]hate) {
        answer = 0;
        pow = new int[21];
        student = new int[10];
        n = hate.length;

        pow[1] = 1;
        for (int i = 2; i <= T; i++)
            pow[i] = pow[i - 1] * 2;

        for (int i = 0; i < n; i++)
            for (int x : hate[i])
                student[i] += pow[x];

        dfs(1, 0, T);

        return answer;
    }
    public static void main(String[] args) {
        Proc10_1 T = new Proc10_1();
        System.out.println(T.solution(6,new int[][]{{1}, {4, 2}, {3, 2, 6}, {5}, {3, 4, 6}}));

    }
}
