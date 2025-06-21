public class a1_constantWindow {
    public static void main(String[] args) {
        int arr[]={-1,2,3,3,4,5,-1};
        int k=4;
        int ans=consst(arr,k);
        System.out.println(ans);
    }

    public static int consst(int arr[],int k){
        int n=arr.length;
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum=sum+arr[i];
        }
        int maxSum=sum;
        int l=0;
        int r=k-1;
        while (r<n-1) {
            sum-=arr[l];
            l++;
            r++;
            sum+=arr[r];
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
