package CD9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Proc9_5 {
    public String solution(String[] cities , String[] roads,String [] cars,String  customer){
        String answer = "";
        int n = cities.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <n; i++) {
            map.put(cities[i], i);
        }
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (String x : roads) {
            int a = map.get(x.split(" ")[0]);
            int b = map.get(x.split(" ")[1]);
            int c = Integer.parseInt(x.split(" ")[2]);
            dist[a][b] = c;
            dist[b][a] = c;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        System.out.print(dist[i][j]);
                    }
                    System.out.println();
                }
            }
        }
        ArrayList<ArrayList<int[]>> carlist = new ArrayList<>();
        return answer;
    }

    public static void main(String[] args) {
        Proc9_5 T = new Proc9_5();
        System.out.println(T.solution(new String[]{"rome", "busan", "daegu"},
                new String[]{"rome busan 1", "rome daegu 1", "busan daegu 2"},
                new String[]{"rome 50 10", "busan 100 20", "daegu 40 8", "rome 80 14", "rome 30 8"},
                "busan daegu 40"));

    }
}
