package CD4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Proc4_4 {
    public class Man implements Comparable<Man> {
        int num;
        String  team;
        int grade;

        public Man(int num, String  team, int grade) {
            this.num = num;
            this.team = team;
            this.grade = grade;
        }

        @Override
        public int compareTo(Man o) {
            return this.grade - o.grade;
        }
    }
    public int[] solution(String []students) {
        int n = students.length;
        int []answer = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Man> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String a = students[i].split(" ")[0];
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Man(i, a, b));
        }
        Collections.sort(list);

        int total = 0,j=0;//j가 초기화 되면 안되기때문에 미리 초기화
        for (int i = 1; i < n; i++  ) {
            for (; j < n; j++  ) {
                if(list.get(j).grade<list.get(i).grade){
                    total += list.get(j).grade;
                    String x = list.get(j).team;
                    map.put(x, map.getOrDefault(x, 0) + list.get(j).grade);
                } else break;


            }
            answer[list.get(i).num] = total-map.getOrDefault(list.get(i).team,0);

        }


        return answer;

    }

    public static void main(String[] args) {
        Proc4_4 T = new Proc4_4();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));

    }
}
