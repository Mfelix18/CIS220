// Miguel Angel Felix Pacheco
// Chpt3 PA
// This program implements the Bubble Sort algorithm.
// It generates an array of 25 random integers (1-1000),
// sorts them using Bubble Sort, and prints both the unsorted and sorted arrays.

import java.util.Random;

public class BubbleSort {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if the current element is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating an array of 25 random integers between 1 and 1000
        int[] numbers = new int[25];
        Random rand = new Random();

        // Generating random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000) + 1; // Random number between 1 and 1000
        }

        // Printing the unsorted array
        System.out.println("Unsorted Array:");
        printArray(numbers);

        // Sorting the array using Bubble Sort
        bubbleSort(numbers);

        // Printing the sorted array
        System.out.println("Sorted Array:");
        printArray(numbers);
    }
}
