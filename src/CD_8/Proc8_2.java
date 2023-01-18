package CD_8;

import java.util.HashMap;
import java.util.PriorityQueue;


public class Proc8_2 {

    public class twin implements Comparable<twin>{
        char c;
        int a;

        public twin(char c, int a) {
            this.c = c;
            this.a = a;
        }
        @Override
        public int compareTo(twin o) {
            return o.a-this.a;
        }
    }

    public String  solution(String s){
        String  answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<twin> pq = new PriorityQueue<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Character x : map.keySet()) {
            pq.add(new twin(x, map.get(x)));
        }

        while (pq.size() > 0) {
            twin tmp=pq.poll();
            answer+=tmp.c;
            if (tmp.a>1)pq.add(new twin(tmp.c, tmp.a-1));

        }

        return answer;
    }

    public static void main(String[] args) {
        Proc8_2 T = new Proc8_2();
        System.out.println(T.solution("AAABBCDEFFG"));
    }
}
