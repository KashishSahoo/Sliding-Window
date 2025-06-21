import java.util.*;

public class a4_longestSubNoRepeat {
    public static void main(String args[]) {
        String str = "aaabbccd";
        int k = 2;
        System.out.println("Ans " + longestkSubstr(str, k));
    }

    static int solveOpt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            // single window u keep exp then violtates condn move left
            if (mpp.containsKey(s.charAt(right))) {
                if (mpp.get(s.charAt(right)) > left) {
                    left = mpp.get(s.charAt(right)) + 1;
                }
            }
            // left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static int longestkSubstr(String str, int k) {
        int maxAns = -1; // Initialize maxAns to -1 to handle the case when no valid substring is found.

        for (int i = 0; i < str.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                se.add(str.charAt(j));

                // If the set exceeds k distinct characters, stop checking further
                if (se.size() > k) {
                    break;
                }

                // Update maxAns if the substring has exactly k distinct characters
                if (se.size() == k) {
                    maxAns = Math.max(maxAns, j - i + 1);
                }
            }
        }

        return maxAns;
    }

    public static int lengthOfLongestSubstringBrute(String str) {
        if (str.length() == 0)
            return 0;
        if (str.equals(" "))
            return 1;
        if (str.length() == 1)
            return 1;

        int maxans = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (se.contains(str.charAt(j))) {
                    break;
                }
                maxans = Math.max(maxans, j - i + 1);
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }
}
