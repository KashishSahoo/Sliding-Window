public class a5_maxConsec {
    public static void main(String[] args) {
        int arr[]={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int ans=max2(arr,k);
        System.out.println(ans);
    }
    public static int max(int arr[],int k){
        int n=arr.length;
        int len=0;
        int maxLen=0; 
        for (int i = 0; i <n; i++) {
            int zeros=0;
            for (int j = i; j <n; j++) {
                if(arr[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    len=j-i+1;
                     maxLen=Math.max(maxLen, len);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
    public static int max1(int arr[],int k){
        int n=arr.length;
        int zeros=0;
        int l=0;
        int r=0;
        int maxLen=0;
       while (r<n) {
        if(arr[r]==0){
            zeros++;
        }
        while (zeros>k) {
            if (arr[l]==0) {
                zeros--;
            }
            l++;
        }
        if (zeros<=k) {
           maxLen=Math.max(maxLen, (r-l+1)); 
        }
        r++;
       }
        return maxLen;
    }
    public static int max2(int arr[],int k){
        int n=arr.length;
        int zeros=0;
        int l=0;
        int r=0;
        int maxLen=0;
       while (r<n) {
        if(arr[r]==0){
            zeros++;
        }
        if(zeros>k) {
            if (arr[l]==0) {
                zeros--;
            }
            l++;
        }
        if (zeros<=k) {
           maxLen=Math.max(maxLen, (r-l+1)); 
        }
        r++;
       }
        return maxLen;
    }
}
