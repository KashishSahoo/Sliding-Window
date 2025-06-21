import java.util.HashMap;

class a11_repeatReplacement{
    public static void main(String[] args) {
        
    }
    public static int longest(String str,int k){
        int left=0;
        int right=0;
        int maxLen=0;
        int maxf=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while (right<str.length()) {
         map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1); 
         maxf=Math.max(maxf,map.get(str.charAt(right)));
         while ((right-left+1)-maxf>k) {
         map.put(str.charAt(left), map.get(str.charAt(left)) - 1); 
         maxf=0;
            
         }

            
        }
    }
    int ans=0,length=0,max=0,left=0;
        HashMap<Character ,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
        hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        max=Math.max(max,hm.get(s.charAt(i)));
        while((i-left+1-max)>k){
        hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
        if(hm.get(s.charAt(left))==0){
        hm.remove(left);
        }
        left++;
        }
        length=Math.max(length,i-left+1);
        }

}
class Solution {
    public int maxScore(String str) {
        int n=str.length();
        int res=0;
        int max=0;
        for(int i=0;i<n-1;i++){
            String f=str.substring(0,i+1);
            String s=str.substring(i+1);
            int cnt0=0;
            for(int j=0;j<f.length();j++){
                if(f.charAt(j)=='0'){
                 cnt0++;
                }
            }
            int cnt1=0;
             for(int k=0;k<s.length();k++){
                if(s.charAt(k)=='1'){
                 cnt1++;
                }
            }
            res=cnt0+cnt1;
            max=Math.max(max,res);
        }
        return max;
    }
}