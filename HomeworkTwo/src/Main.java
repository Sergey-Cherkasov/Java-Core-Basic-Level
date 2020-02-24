import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int[] array;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThreeFiveSix();
        taskFour();
        taskSeven();
    }

    private static void taskOne() {
        int numberArrayElements;
        try {
            System.out.println("Task 1.");
            System.out.print("Enter the number of array elements: ");
            numberArrayElements = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Inputted value is not integer: " + e);
            numberArrayElements = 0;
        }
        array = UserArray.getArray(numberArrayElements);
        String nameArray = "Input array";
        UserArray.printArray(nameArray, array);
        UserArray.inversionBinaryArray(array);
        nameArray = "Output array";
        UserArray.printArray(nameArray, array);
    }

    private static void taskTwo() {
        int[] arrayElementsMultiplesThree = new int[8];
        String nameArray = "Array of elements of multiples of 3";
        UserArray.multiplyThree(arrayElementsMultiplesThree);
        System.out.println("\nTask 2.");
        UserArray.printArray(nameArray, arrayElementsMultiplesThree);
    }

    private static void taskThreeFiveSix() {
        int numberArrayElements;
        int maxValueElement = 0;
        try {
            System.out.println("\nTask 3.");
            System.out.print("Enter the number of array elements: ");
            numberArrayElements = scanner.nextInt();
            System.out.print("Enter the maximum value of the array element: ");
            maxValueElement = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Inputted value is not integer: " + e);
            numberArrayElements = 0;
        }
        if (maxValueElement < 0) maxValueElement = -maxValueElement;
        array = UserArray.getArray(numberArrayElements, maxValueElement);
        String nameArray = "Input array";
        UserArray.printArray(nameArray, array);
        UserArray.multiplyTwo(array, maxValueElement);
        nameArray = "Output array";
        UserArray.printArray(nameArray, array);
        UserArray.minMaxValues(array);
        System.out.println("The output array has a balance: "+ UserArray.isCheckBalance(array));
    }

    private static void taskFour() {
        int numberArrayRowsColumns;
        int[][] array;
        try {
            System.out.println("\nTask 4.");
            System.out.print("Enter the number rows and columns of square array: ");
            numberArrayRowsColumns = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Inputted value is not integer: " + e);
            numberArrayRowsColumns = 0;
        }
        array = UserArray.getSquareArray(numberArrayRowsColumns);
        String nameArray = "Square array";
        UserArray.printArray(nameArray, array);
    }

    private static void taskSeven(){
        int numberArrayElements;
        int shiftValue;
        try {
            System.out.println("\nTask 3.");
            System.out.print("Enter the number of array elements: ");
            numberArrayElements = scanner.nextInt();
            System.out.print("Enter the number (either positive or negative) that all elements of the array should shift: ");
            shiftValue = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Inputted value is not integer: " + e);
            numberArrayElements = 0;
            shiftValue = 0;
        }
        int[] array = UserArray.shiftElements(numberArrayElements, shiftValue);
        System.out.print("Output array:\t [");
        for (int arrayElement : array){
            System.out.print(" " + arrayElement);
        }
        System.out.println(" ]");
    }

}