# Java Array and Data Manipulation

This project demonstrates essential Java principles, focusing on array handling, sorting, and data manipulation techniques.

## Key Objectives and Points
- Reading and parsing user input into an array.
- Implementing bubble sort to find min/max values.
- Using efficient array traversal to find the minimum value without sorting.
- Showcases array handling, sorting, and data manipulation techniques.

## Example Usage

```java
package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrayList = readInteger();
        System.out.println("Unsorted Array: " + Arrays.toString(arrayList));
        System.out.println("Sorted in ascending order: " + findMin(arrayList));
        System.out.println("Sorted in descending order: " + findMax(arrayList));
        System.out.println("Minimum without sorting: " + findMinUnsorted(arrayList));
    }

    public static int[] readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a comma-delimited list of numbers.");
        String userList = scanner.nextLine();
        String[] stringNumbers = userList.split(",");
        int[] myNumbersArray = new int[stringNumbers.length];
        for (int i = 0; i < myNumbersArray.length; i++) {
            myNumbersArray[i] = Integer.parseInt(stringNumbers[i].trim());
        }
        return myNumbersArray;
    }

    private static int findMin(int[] unsortedArray) {
        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("Sorted in ascending order: " + Arrays.toString(sortedArray));
        return sortedArray[0];
    }

    private static int findMax(int[] unsortedArray) {
        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("Sorted in descending order: " + Arrays.toString(sortedArray));
```
