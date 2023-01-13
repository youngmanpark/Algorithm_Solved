package CD5;

import java.util.ArrayList;
import java.util.HashMap;

public class Proc5_6 {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public String [] solution(String []reports,int k) {
        HashMap<String, ArrayList<Integer>> sH = new HashMap<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            sH.putIfAbsent(a, new ArrayList<Integer>());
            sH.get(a).add(getTime(b));
        }
        ArrayList<String> res = new ArrayList<>();
        for(String key : sH.keySet()){
            ArrayList<Integer> curr = sH.get(key);
            curr.sort((a, b) -> a - b);
            int left = 0;
            for(int right = 0; right < curr.size(); right++){
                while(curr.get(right) - curr.get(left) > 60) left++;
                if(right-left+1 == k){
                    res.add(key);
                    break;
                }
            }
        }
        res.sort((a, b) -> a.compareTo(b));
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;

    }
    public static void main(String[] args) {
        Proc5_6 T = new Proc5_6();
        System.out.println(T.solution(new String[]{"luis 08:11", "daniel 10:21", "luis 09:12", "emily 08:34",
                "luis 09:45", "luis 08:45", "luis 18:48", "emily 09:12",
                "daniel 11:15", "emily 09:34", "luis 10:35", "luis 10:45"},3));
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           