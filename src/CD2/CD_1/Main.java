/*
package CD2.CD_1;

import java.util.Arrays;

class Solution{
    public String solution (String str){
        int[] answer = new int[str.length()];
        String[] strings = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            strings[i]= String.valueOf(str.charAt(i));
        }

        int cnt[] = new int[5];

        for (String s : strings) {
            if(s=="a")
                cnt[0]++;
            if(s=="b")
                cnt[1]++;
            if(s=="c")
                cnt[2]++;
            if(s=="d")
                cnt[3]++;
            if(s=="e")
                cnt[4]++;
        }
        int[] strcnt = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {

        }

        int max=Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < str.length(); i++) {
            answer[i] = max - ;
        }
        return Arrays.toString(answer);

    }
    public static void main(String []args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabc"));

    }
}*/
