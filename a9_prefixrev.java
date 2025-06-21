class a9_prefixrev {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        String word = "abcdefd";
        String ch = "d";
    }
    public String reversePrefix(String str, char ch) {
        int n = str.length();
        int idx = -1;

        // Find the index of the first occurrence of ch
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ch) {
                idx = i;
                break;
            }
        }

        // If ch is not found, return the original string
        if (idx == -1) {
            return str;
        }

        // Reverse the prefix
        String s = str.substring(0, idx + 1);
        String rev = revstr(s);

        // Concatenate the reversed prefix with the rest of the string
        return rev + str.substring(idx + 1);
    }

    // Helper method to reverse a string
    public static String revstr(String s) {
        char[] charArray = s.toCharArray(); // Convert string to char array
        int left = 0, right = charArray.length - 1;

        // Swap characters from both ends
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray); // Convert char array back to string
    }
}

