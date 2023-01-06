package CD2.CD_6;
import java.util.*;
class Solution {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public String[] solution(String[] arr, int time){

        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();
        for(String x : arr){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];
            if(c.equals("in"))
                inT.put(a, getTime(b));
            else
                sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - inT.get(a)));//기존에 있는값에 누적
        }
        ArrayList<String> res = new ArrayList<>();

        /** 제공된 시간보다 초과한 사람 찾기 **/
        for(String name : sumT.keySet()){
            if(sumT.get(name) > time) res.add(name);
        }

        Collections.sort(res); // 초과한 사람 이름순 정렬

        String[] answer = new String[res.size()];

        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
    }
}