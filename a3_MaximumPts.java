public class a3_MaximumPts {
    public static void main(String[] args) {
        int arr[] = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
        int k = 4;
        int ans = maxpts(arr, k);
        System.out.println(ans);
    }

    public static int maxpts(int arr[], int k) {
        int lsum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            lsum = lsum + arr[i];
        }
        maxSum = lsum;

        int ridx=arr.length-1;
        int rsum=0;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-arr[i];
            rsum=rsum+arr[ridx];
            ridx--;
            maxSum=Math.max(maxSum, (lsum+rsum));
            
        }
        return maxSum;
    }
}


