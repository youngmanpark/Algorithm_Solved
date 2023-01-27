package CD11;

import java.util.*;

public class Proc11_4 {
    public String []solution(String []subject,String []course){
        int n= subject.length;
        HashMap< String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put( subject[i],i);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n];
        for (String x : course) {
            int a = map.get(x.split(" ")[0]);
            int b = map.get(x.split(" ")[1]);
            System.out.println(a+" "+b);
            graph.get(b).add(a);
            indegree[a]++;
        }
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i]==0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order.add(pre);
            for (int x : graph.get(pre)) {
                indegree[x]--;
                if(indegree[x]==0)
                    queue.offer(x);
            }
        }
        String[] answer = new String[n];
        for (int i = 0; i < order.size(); i++) {
            answer[i] = subject[order.get(i)];
        }

        return answer;

    }

    public static void main(String[] args) {
        Proc11_4 T = new Proc11_4();
        System.out.println(Arrays.toString(T.solution(new String[]{"english",
                "math", "physics",
                "art", "music"}, new String[]{"art math", "physics art", "art music",
                "physics math", "english physics"})));

    }
}
