package CD10;

import java.util.HashMap;

public class Proc10_2 {
    public int solution(String []s,int k){
        int answer=0;
        int n = s.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 1 << n;
        for (int i = 0; i < cnt; i++) {
            int sum = 0;
            int shift = 0;
            for (int j = 0; j < n; j++) {
                if((i&(1<<j))==0) continue;
                int score = s[j].length();
                for (Character x : s[j].toCharArray()) {
                    if(x==' ')continue;
                    if (x >= 65 && x <= 90) {
                        x = (char) (x + 32);
                        shift = 1;
                        score++;
                    }
                    map.put(x, 1);
                }
                sum += score;
            }
            if(map.size()+shift<=k)
                answer = Math.max(answer, sum);
            map.clear();

        }
        return answer;
    }
    public static void main(String[] args) {
        Proc10_2 T = new Proc10_2();
        System.out.println(T.solution(new String[]{"Ges Big", "Ges in Big", "Big size", "Ges size"},7));

    }
}
