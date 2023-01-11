package CD2;



import java.util.*;

class Proc2_4 {
    public String solution (String []arr, int k){
        String answer;

        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String,Integer> candidate = new HashMap<>();
        HashMap<String, Integer> cntHash = new HashMap<>();
        ArrayList<String > list = new ArrayList();

        for (String x : arr) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b,0)+1);
        }
        int max = 0;
        for (String key : voteHash.keySet()) {
            int cnt = 0;
            for (String x : voteHash.get(key)) {
                if(candidate.get(x)>=k)
                    cnt++;
                cntHash.put(key, cnt);
                max = Math.max(max, cnt);
            }
        }
        for (String key : cntHash.keySet()) {
            if (cntHash.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        answer= list.get(0);
        return answer;

    }
    public static void main(String []args){
       Proc2_4 T = new Proc2_4();
        String [] arr  = {"john tom", "daniel luis", "john luis", "luis tom",
                "daniel tom", "luis john"};
        System.out.println(T.solution(arr,2));

    }
}