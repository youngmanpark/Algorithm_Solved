package CD5;

import java.util.HashMap;

public class Proc5_5 {
    public int solution(String s,int k) {
        int answer = 300000;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size()==k){
                answer = Math.min(answer, right - left + 1);
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
        }
        return answer;

    }
    public static void main(String[] args) {
        Proc5_5 T = new Proc5_5();
        System.out.println(T.solution("abacbbcdede",5));
    }
}
