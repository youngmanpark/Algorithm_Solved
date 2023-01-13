package CD6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Proc6_2 {
    LinkedList<String> tmp;
    ArrayList<String> res;

    public void dfs(int start, String s) {
        if(tmp.size()>4) return;
        if (tmp.size() == 4 && start == s.length()) {
            int i = 0;
            String src="";
            for (String x : tmp) {
                src += x;
                if(i<3) src+=".";
                i++;
            }
            res.add(src);

        } else {
            for (char x : s.toCharArray()) {
                for (int i = start; i < s.length(); i++) {
                    if (s.charAt(start) == '0' && i > start) return;
                    String num = s.substring(start, i + 1);
                    if (Integer.parseInt(num) > 255) return;
                    tmp.add(num);
                    dfs(i + 1, s);
                    tmp.pollLast();
                }
            }
        }
    }

    public String[] solution(String s) {
        String[] answer = {};
        tmp = new LinkedList<>();
        res = new ArrayList<>();

        dfs(0,s);
        System.out.println(res);
        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;

    }

    public static void main(String[] args) {
        Proc6_2 T = new Proc6_2();
        System.out.println(Arrays.toString(T.solution("2025505")));
    }
}
