package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

//Objective: Demonstrate knowledge of arrays and data manipulation using array and
//string classes.

//Requirement 1: Write a method that reads a comma delimited list of numbers
//entered by the user from the console that returns as an array containing
//the numbers the user listed.

//Requirement 2: Write a method that takes the array as an argument, sorts the
//numbers in the array from least to greatest, and then returns the minimum value.

//Requirement 3: Write a method that returns the minimum value found in the array without sorting.

//Tip: Assume user will only enter numbers, so no this doesn't include validating console input for the exercise.


public class Main {
    public static void main(String[] args) {

        int[] arrayList = readInteger(); //Create an arrayList in main
        //by utilizing the readInteger() method that returns an array.
        //The returned array is assigned to arrayList variable.

        System.out.println("Unsorted Array is: " + Arrays.toString(arrayList)); //The arrayList is
        // then printed by converting it to a readable String using
        //Java.util's Arrays class .toString method and passing the arrayList to it.

        //Now I need to pass the array to a method (findMin()) that will sort it and return the maximum
        //number from it.

        System.out.println("The largest number in the given range is: " + findMax(arrayList));

        //Now I need to pass the array to a method (findMin()) that will sort it and return the manimum
        //number from it.

        System.out.println("The smallest number in the given range is: " + findMin(arrayList));
        //This should return the minimum number.

        //Now I need to pass the array to a method that will find the smallest number WITHOUT sorting.

        System.out.println("Alternative method confirming smallest number: " + findMinUnsorted(arrayList));

    }

    public static int[] readInteger() { //reads comma delimited list of numbers input by user. Nothing passed through.
        Scanner scanner = new Scanner(System.in); //initialize instance of Scanner
        System.out.println("Enter a comma-delimited list of numbers."); //Prompt conversation by giving directions...
        String userList = scanner.nextLine(); //Read the entire line of input. Then assign this next line to a String
        //called userList.
        String[] stringNumbers = userList.split(","); //Create an array called stringNumbers that stores
        //everything split by commas within the string called userList.
        //Now that I have a string of split numbers, I need to convert these from String to Int.

        int[] myNumbersArray = new int[stringNumbers.length]; //Create a new Array of size input at scanner
        //using the stringNumbers Array and making the length the amount.
        //Now I need to assign the numbers from stringNumbers to the initialized int Array.
        //To do this, I'll use a loop.

        for (int i = 0; i < myNumbersArray.length; i++) { //Created a loop going the length of the array.
            //now I need to use the parseInt method in Java.util to parse the string
            //array, generate an Int equivalent, and then assign that number to the
            //int array per iteration.
            myNumbersArray[i] = Integer.parseInt(stringNumbers[i].trim());
            //Each iteration is being assigned as described above, with .trim() method being
            //used to eliminate leading spaces.

        }
        return myNumbersArray;
    }

    private static int findMin(int[] unsortedArray) {

        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length); //Create a
        //copy of the Array to manipulate data without messing up original.

        //I'll create a loop to sort the array. First I need to make a flag to enable a "while true" loop.
        boolean flag = true; //Now that it's true, I'll need a temporary variable to store the number being
        //switched while it is being switched.
        int temp; //temporary storage. Not necessary to be assigned here.
        while (flag) { //trigger the "while true" loop.
            flag = false; //Set the flag to false for an exit of loop.
            for (int i = 0; i < sortedArray.length - 1; i++) { //For loop, with condition being while the iteration is
                //less than how many total numbers there are, minus one (because we are comparing left number to next
                //number, and once we get to the second last number, we just compare it to the last number).
                if (sortedArray[i] > sortedArray[i + 1]) { //if first number is less than second...
                    temp = sortedArray[i]; //Assign the temporary number with the current number (sortedArray[i])
                    //to make it a placeholder and hold onto that number to swap them.
                    sortedArray[i] = sortedArray[i + 1]; //Swap the current instance/array number with the value of
                    //the second instance/array number in the index.
                    sortedArray[i + 1] = temp; //Swap the second array number to the first
                    //number we have temporarily stored in 'temp.'
                    flag = true; //Flag gets reset to "true" to trigger loop again, which starts
                    //by setting flag to false you only get through it one more time, unless it is triggered again.
                }
            }
        }
        System.out.println("Sorted in ascending order is: " + Arrays.toString(sortedArray));
        return sortedArray[0]; //return the first number from the sorted array.
    }

    private static int findMax(int[] unsortedArray) {

        int[] sortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length); //Create a
        //copy of the Array to manipulate data without messing up original.

        //I'll create a loop to sort the array. First I need to make a flag to enable a "while true" loop.
        boolean flag = true; //Now that it's true, I'll need a temporary variable to store the number being
        //switched while it is being switched.
        int temp; //temporary storage. Not necessary to be assigned here.
        while (flag) { //trigger the "while true" loop.
            flag = false; //Set the flag to false for an exit of loop.
            for (int i = 0; i < sortedArray.length - 1; i++) { //For loop, with condition being while the iteration is
                //less than how many total numbers there are, minus one (because we are comparing left number to next
                //number, and once we get to the second last number, we just compare it to the last number).
                if (sortedArray[i] < sortedArray[i + 1]) { //if first number is less than second...
                    temp = sortedArray[i]; //Assign the temporary number with the current number (sortedArray[i])
                    //to make it a placeholder and hold onto that number to swap them.
                    sortedArray[i] = sortedArray[i + 1]; //Swap the current instance/array number with the value of
                    //the second instance/array number in the index.
                    sortedArray[i + 1] = temp; //Swap the second array number to the first
                    //number we have temporarily stored in 'temp.'
                    flag = true; //Flag gets reset to "true" to trigger loop again, which starts
                    //by setting flag to false you only get through it one more time, unless it is triggered again.
                }
            }
        }
        System.out.println("Sorted in descending order: " + Arrays.toString(sortedArray));
        return sortedArray[0]; //return the first number from the sorted array.
    }

    public static int findMinUnsorted(int[] unsortedArray) { //More optimized version of find min without sorting.
        int min = unsortedArray[0]; //Assume the first element is the minimum to compare.
        for (int i = 1; i < unsortedArray.length; i++) { //Start comparison from second element of index.
            if (unsortedArray[i] < min) { //check if current iteration value is less than min variable.
                min = unsortedArray[i]; //if it is, update/replace the min variable with new iteration value.
                //This repeats until the length of the array is through.
            }
        }
        return min;
    }
}
