package CD1.CD_1;

class Solution{
    public  char [] solution (int n,int [][] ladder){
        char[] answer = new char[n];
        for (int i = 0; i < n; i++  ) {
            answer[i] = (char) (i + 65);
        }


        for(int[]line:ladder){
            for(int x:line){
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
        }



        return answer;

    }
    public static void main(String []args){

        Solution T = new Solution();
        int n = 5;
        int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
        System.out.println(T.solution(n,ladder));

    }
}