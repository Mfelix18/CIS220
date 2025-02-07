// Miguel Angel Felix Pacheco
// CHPT2 PA

import java.util.Scanner;

public class ReverseString {



    // Recursive method to reverse a string
    public static String reverseString(String str) {
        // Base case: if the string is empty or has one character, return it as is
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        
        // Recursive case: reverse the substring (excluding first character) 
        // and append the first character at the end
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input, result;
        //Call recursive function to reverse teh string 
        System.out.print("Enter the string to be reversed: ");
        input = scnr.nextLine();
        
        result = reverseString(input);
        //Print the reversed string 
        System.out.printf("Reversed: %s\n", result);
        
        scnr.close(); // Close scanner to prevent resource leak
    }
}