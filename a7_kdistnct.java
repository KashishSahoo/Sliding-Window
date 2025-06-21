import java.util.*;

public class a7_kdistnct {
    public static void main(String args[]) {
        String str = "aaabbccd";
        int k = 2;
        System.out.println("Ans " + longestkSubstr3(str, k));
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
    public static int longestkSubstr2(String str, int k) {
        int maxAns = -1; // Initialize maxAns to -1 to handle the case when no valid substring is found.

        for (int i = 0; i < str.length(); i++) {
           HashMap<Character,Integer> map=new HashMap<>();
            for (int j = i; j < str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1); // Update frequency of the current fruit

                // If the set exceeds k distinct characters, stop checking further
                if (map.size() > k) {
                    break;
                }

                // Update maxAns if the substring has exactly k distinct characters
                if (map.size() == k) {
                    maxAns = Math.max(maxAns, j - i + 1);
                }
            }
        }
        return maxAns;
    }
    public static int longestkSubstr3(String str, int k) {
        int maxAns = -1;
        int l = 0;  // Left pointer of the window
    
        // Use a sliding window with the right pointer 'r' expanding
        HashMap<Character, Integer> map = new HashMap<>();
    
        for (int r = 0; r < str.length(); r++) {
            // Add the current character to the window (map)
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);
    
            // Shrink the window from the left side if the number of distinct characters exceeds k
            while (map.size() > k) {
                map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                if (map.get(str.charAt(l)) <= 0) {
                    map.remove(str.charAt(l));
                }
                l++;  // Move the left pointer to shrink the window
            }
    
            // Check if the current window has exactly k distinct characters
            if (map.size() == k) {
                maxAns = Math.max(maxAns, r - l + 1);
            }
        }
    
        return maxAns;  // Return -1 if no valid substring was found
    }
    
}
