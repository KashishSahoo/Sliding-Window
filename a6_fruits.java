import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class a6_fruits {
    public static void main(String[] args) {
        int arr[]={3,3,3,1,2,1,1,2,3,3,4};
        int ans=totalFruit1(arr);
        System.out.println(ans);
    }
    public static int  totalFruit(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(arr[j]);
                if (set.size() <= 2)
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }

        }
        return maxLen;
    }
     public static int  totalFruit1(int[] arr) {
        // int arr[]={3,3,3,1,2,1,1,2,3,3,4};

        int n = arr.length; // Total number of fruits
        Map<Integer, Integer> map = new HashMap<>(); // Map to store the frequency of each fruit
        int left = 0, max = 0; // Left pointer and max length variable
        
        int right = 0; // Initialize the right pointer
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1); // Update frequency of the current fruit

            // Shrink the window until there are at most two distinct fruits
            while (map.size() > 2) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1); // Decrement the frequency of the leftmost fruit
                if (map.get(arr[left]) <= 0) {
                    map.remove(arr[left]); // Remove the fruit if its frequency becomes zero
                }
                left++;
            }

            // Update the max length of the window
            if(map.size()<=2){
                max = Math.max(max, right - left + 1);
            }

            right++; // Move the right pointer forward
        }

        return max;
        
    }

    public static int  totalFruit2(int[] arr) {
        // int arr[]={3,3,3,1,2,1,1,2,3,3,4};

        int n = arr.length; // Total number of fruits
        Map<Integer, Integer> map = new HashMap<>(); // Map to store the frequency of each fruit
        int left = 0, max = 0; // Left pointer and max length variable
        
        int right = 0; // Initialize the right pointer
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1); // Update frequency of the current fruit

            // Shrink the window until there are at most two distinct fruits
            if (map.size() > 2) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1); // Decrement the frequency of the leftmost fruit
                if (map.get(arr[left]) <= 0) {
                    map.remove(arr[left]); // Remove the fruit if its frequency becomes zero
                }
                left++;
            }

            // Update the max length of the window
            if(map.size()<=2){
                max = Math.max(max, right - left + 1);
            }

            right++; // Move the right pointer forward
        }

        return max;
        
    }
}

