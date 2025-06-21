public class a8_allChars {
    public static void main(String[] args) {
        String str="bbacba";
        int ans=numberOfSubstrings2(str);
        System.out.println(ans);
    }
    public int numberOfSubstrings(String str) {
        int n = str.length();
        int cnt = 0;
        
        // Loop to iterate over each possible starting point of substrings
        for (int i = 0; i < n; i++) {
            int[] hash = new int[3]; // Reset the hash array for each new starting index
            // Loop to generate all substrings starting at index i
            for (int j = i; j < n; j++) {
                // Update the character count
                hash[str.charAt(j) - 'a'] = 1;
                
                // Check if all three characters 'a', 'b', and 'c' are present
                if (hash[0] + hash[1] + hash[2] == 3) {
                    cnt++; 
                    // Valid substring found
                    //cnt=cnt+(n-j);
                    //break
                }
            }
        }
        
        return cnt; // Return the final count of valid substrings
    }
    public static int numberOfSubstrings2(String str) {
        int n=str.length();
        int cnt=0;
        int lastSeen[]={-1,-1,-1}; 
        for (int i = 0; i < n; i++) {
            lastSeen[str.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                cnt=cnt+(1+Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return cnt;
    }

}

