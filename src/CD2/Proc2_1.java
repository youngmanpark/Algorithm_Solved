package CD2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Proc2_1 {
    public int[] solution(String s){
        int[] answer = new int[5];
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(sH.getOrDefault(key, 0) > max){
                max = sH.getOrDefault(key, 0);
            }
        }
        for(char key : tmp.toCharArray()){
            res.add(max - sH.getOrDefault(key, 0));
        }
        for(int i = 0; i < 5; i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Proc2_1 T = new Proc2_1();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
    }
}
