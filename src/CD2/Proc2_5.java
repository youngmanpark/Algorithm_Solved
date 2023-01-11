package CD2;
import java.util.*;

//시간이 들어오면 분으로 환산 ex) 5:30 => h=5->5*60=300 m=30 ::330

class Proc2_5 {

    class Info implements Comparable<Info>{
        String name;
        int time;
        public Info(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time-o.time;
        }
    }
    /**시간이 들어오면 분으로 환산 ex) 5:30 => h=5->5*60=300 m=30 ::330**/
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public String[] solution (String []arr, String times){

        ArrayList<Info> tmp = new ArrayList<>();
        for(String x : arr){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp);
        int s = getTime(times.split(" ")[0]);//최소 시간
        int e = getTime(times.split(" ")[1]);//최대 시간

        ArrayList<String> res = new ArrayList<>();
        for(Info x : tmp){
            if(x.time >= s && x.time <= e){
                res.add(x.name);
            }
        }

        String[] answer = new String[res.size()];

        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;

    }
    public static void main(String []args){
        Proc2_5 T = new Proc2_5();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));

    }
}