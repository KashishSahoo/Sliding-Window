
import java.util.Arrays;

public class  a10_diffLarSmall {
    public static void main(String[] args) {
        long number = 12859; // Example number (can be any n-digit number)
        long difference = findDifference(number);
        System.out.println("Difference between largest and smallest number formed: " + difference);
    }

    public static long findDifference(long number) {
        // Convert the number to a string to extract its digits
        String numStr = String.valueOf(number);
        int len = numStr.length();
        
        // Create an array to store the digits
        int[] digits = new int[len];
        
        // Extract digits from the number
        for (int i = 0; i < len; i++) {
            digits[i] = numStr.charAt(i) - '0'; // Convert char to int
        }

        // Sort digits in ascending order to form the smallest number
        Arrays.sort(digits);
        long smallest = 0;
        for (int i = 0; i < len; i++) {
            smallest = smallest * 10 + digits[i];
        }

        // Sort digits in descending order to form the largest number
        // for (int i = 0; i < len / 2; i++) {
        //     int temp = digits[i];
        //     digits[i] = digits[len - 1 - i];
        //     digits[len - 1 - i] = temp;
        // }

        // int largest=0;
        // for (int i = 0; i <len; i++) {
        //     largest=largest*10+digits[i];
        // }
        
        long largest = 0;
        for (int i = len-1; i >= 0; i--) {
            largest = largest * 10 + digits[i];
        }
       
        

        // Return the difference between the largest and smallest number
        return largest - smallest;
    }
}
