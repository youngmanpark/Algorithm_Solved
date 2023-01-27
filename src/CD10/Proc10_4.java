package CD10;

public class Proc10_4 {
    public int solution(int []nums){
        int answer=0;
        int n = nums.length;
        int[] minR = new int[n];
        minR[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--)
            minR[i] = Math.min(nums[i], minR[i+1]);

        int curMax = nums[0];
        for(int i = 1; i < n; i++){
            curMax = Math.max(curMax, nums[i - 1]);
            if(curMax <= minR[i]) return i;
        }
        return answer;
    }
    public static void main(String[] args) {
        Proc10_4 T = new Proc10_4();
        System.out.println(T.solution(new int[]{3, 5, 3, 1, 2, 5, 3, 5, 7}));

    }
}
