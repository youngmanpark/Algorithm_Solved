package CD6;

public class Proc6_3 {
    int[] mz = new int[101];
    public int dfs(int start, String s) {
        if(start<s.length()&&s.charAt(start)=='0') return 0;
        if(start ==s.length()-1|| start==s.length()) return 1;
        if(mz[start]!=0) return mz[start];

        else {
            int res = dfs(start+1,s);
            int num = Integer.parseInt(s.substring(start, start + 2));
            if(num<=26 ) res += dfs(start + 2, s);
            return mz[start]=res;

        }
    }
    public int solution(String s) {

        int answer=dfs(0, s);

        return answer;

    }

    public static void main(String[] args) {
        Proc6_3 T = new Proc6_3();
        System.out.println(T.solution("25114"));
    }
}
