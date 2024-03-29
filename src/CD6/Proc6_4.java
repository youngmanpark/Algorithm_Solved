package CD6;


import java.util.Arrays;

public class Proc6_4 {

    class Data{
        public int num,idx, big;
        public Data(int num, int idx, int big) {
            this.num = num;
            this.idx = idx;
            this.big = big;
        }
    }    public void merge(int []arr, int left, int right) {
        int[] tmp = new int[arr.length];

        int L, R, k, i;
        int mid = (left + right) / 2;
        L = left;
        R = mid + 1;
        k = left;

        while (L <= mid && R <= right)//루프가 도는 동안
            tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        //분할된 양쪽의 값을 비교후 작은 쪽을 임시배열에 복사후 인데스 증가

        if (L > mid)//분할된 한쪽 배열이모두 복사되었을때 나머지를 임시배열에 복사
            for (i = R; i <= right; i++)
                tmp[k++] = arr[i];
        else
            for (i = L; i <= mid; i++)
                tmp[k++] = arr[i];

        for (i = left; i <= right; i++)// 복사해둔 정렬된 임시배열을 기존배열에 돌려줌
            arr[i] = tmp[i];

    }


    public void mergeSort(int []arr, int left, int right) {

        if (left == right) return;
        int mid=(left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }
    Data[] a = new Data[10];
    Data[] b = new Data[10];

    public String[] solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            a[i] = new Data(nums[i],i,0);
        }

        String[] answer = {};


        return answer;

    }

    public static void main(String[] args) {
        Proc6_4 T = new Proc6_4();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 2, 1, 3})));
    }
}
