package CD6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Proc6_1 {

    LinkedList<Character> tmp = new LinkedList<>();
    ArrayList<String> res = new ArrayList<>();

    HashMap<Character, Integer> sH = new HashMap<>();
    private int len;
    public void dfs() {
        if (len == tmp.size()) { // 입력된 문자열의 길이와 tmp의 길이아 같아졌을 때 종료 조건
            String Ts = "";
            for(char x:tmp)
                Ts += x;
            res.add(Ts);
        }else {
            for (char key : sH.keySet()) {
                if(sH.get(key)==0) continue; // hashing 된 개수가 없을 경우 continue
                tmp.add(0, key); //앞에 알파벳 넣어주기
                tmp.add(key); //뒤에 알파벳 넣어주기
                sH.put(key, sH.get(key) - 2); //해당 알파벳 hahsing 개수 -2
                dfs();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key) + 2);
            }
        }


    }
    public String[] solution(String s) {
        String[] answer = {};
        len = s.length();
        for (char x : s.toCharArray()) {//Hashing 하기
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        int odd = 0;//홀수
        char mid = '0';
        for (char key : sH.keySet()) {
            if (sH.get(key) % 2 == 1) { //해싱된 알파벳 개수가 홀수일 경우
                mid = key; //해당된 알파벳 mid에 넣어주기
                odd++;
            }
        }
        if(odd>1) return new String[]{};// 홀수개의 알파벳이 2개이상일경우 빈 배열 반환

        if(mid!='0'){ // 홀수가 1개만 존재할 경우
            tmp.add(mid); //가운데에 홀수개의 알파벳 하나 넣어주기
            sH.put(mid, sH.get(mid) - 1); //hashing 개수 빼주기
        }

        dfs();

        answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;


    }
    public static void main(String[] args) {
        Proc6_1 T = new Proc6_1();
        System.out.println(Arrays.toString(T.solution( "aaaabb")));
        System.out.println(Arrays.toString(T.solution( "aaaabb")));
    }
}
