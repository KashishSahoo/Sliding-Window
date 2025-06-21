public class a2_longestSub {
    public static void main(String[] args) {
        // int arr[] = { 2, 5, 1, 7, 10 };
        // print subarr
        int arr[]={2,5,10,1,2,2,1,10,10};//max sum
        int k = 14;
        int ans = longestBetter(arr, k);
        System.out.println(ans);
    }

    public static int longestBrute(int arr[], int k) {
        int maxLen = 0;
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                if (sum <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else if (sum > k)
                    break;
            }

        }
        return maxLen;

    }
    public static int longestBetter(int arr[], int k) {
        int l=0;
        int r=0;
        int sum=0;
        int maxLen=0;
        int n=arr.length;
        while(r<n){
            sum=sum+arr[r];
            while (sum>k) {
                sum=sum-arr[l];
                l++;
            }
            if(sum<=k){
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;

    }
    public static int longestBest(int arr[], int k) {
        int l=0;
        int r=0;
        int sum=0;
        int maxLen=0;
        int n=arr.length;
        while(r<n){
            sum=sum+arr[r];
            if (sum>k) {
                sum=sum-arr[l];
                l++;
            }
            if(sum<=k){
                maxLen=Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;

    }
}








