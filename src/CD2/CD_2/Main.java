package CD2.CD_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution{
    public int solution (String str){
        int answer = 0;
        ArrayList list = new ArrayList();
        HashMap<Character, Integer> sh = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();

        for (Character x : str.toCharArray()) {
            sh.put(x,  (sh.get(x) == null) ? 1: sh.get(x) +1);
        }
        for(char key: sh.keySet()){
            while (ch.contains(sh.get(key))) {
                answer++;
                sh.put(key, sh.get(key) - 1);
            }
                if(sh.get(key)==0)
                    continue;
                ch.add(sh.get(key));

        }

        return answer;

    }
    public static void main(String []args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));

    }
}