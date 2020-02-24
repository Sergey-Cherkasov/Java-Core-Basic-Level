
public class UserArray {

    /**
     * The method sets an array of a random binary elements 0 and 1.
     *
     * @param numberElements Count elements of array.
     * @return Array consisting of a binary elements 0 and 1.
     */
    public static int[] getArray(int numberElements) {
        int[] array;
        if (numberElements < 0) {
            return new int[0];
        }
        array = new int[numberElements];
        for (int arrayElement = 0; arrayElement < array.length; arrayElement++) {
            array[arrayElement] = (Math.random() * 10) < 5 ? 0 : 1;
        }
        return array;
    }

    /**
     * The method sets an array of a random value elements.
     * @param numberElements  Count elements of array.
     * @param maxElementValue Max array element value.
     * @return Array consisting of elements of random values from 0 to maxElementValue.
     */
    public static int[] getArray(int numberElements, int maxElementValue) {
        int[] array;
        if (numberElements < 0){
            return new int[0];
        }
        array = new int[numberElements];
        for (int arrayElement = 0; arrayElement < array.length; arrayElement++) {
            array[arrayElement] = (int) (Math.random() * maxElementValue);
        }
        return array;
    }

    /**
     * The method sets a square array with values of 1 on the diagonals.
     * @param numberArrayRowsColumns Number of rows and columns in a square array
     * @return A square array
     */
    public static int[][] getSquareArray(int numberArrayRowsColumns) {
        int[][] array;
        if (numberArrayRowsColumns <= 0) {
            return new int[1][1];
        }
        array = new int[numberArrayRowsColumns][numberArrayRowsColumns];
        int startColumn = 0, endColumn = numberArrayRowsColumns - 1, startRows = 0;
        do {
            array[startRows][startColumn] = array[startRows][endColumn] = 1;
            startColumn++;
            endColumn--;
            startRows++;
        } while (startColumn < numberArrayRowsColumns && endColumn >= 0 && startRows < numberArrayRowsColumns);
        return array;
    }

    /**
     * The method inverts the binary values of the array: 0 to 1, 1 to 0.
     *
     * @param array Array consisting of a binary elements 0 and 1.
     */
    public static void inversionBinaryArray(int[] array) {
        for (int arrayElement = 0; arrayElement < array.length; arrayElement++) {
            switch (array[arrayElement]) {
                case 0:
                    array[arrayElement] = 1;
                    break;
                case 1:
                    array[arrayElement] = 0;
            }
        }
    }

    /**
     * The method sets an array of elements of multiples of 3.
     *
     * @param array Empty array.
     */
    public static void multiplyThree(int[] array) {
        for (int arrayElement = 0; arrayElement < array.length; arrayElement++) {
            array[arrayElement] = arrayElement * 3;
        }
    }

    /**
     * The method doubles the values of elements less than {@code maxValueElement / 2}.
     * @param array Array consisting of elements of random values.
     * @param maxValueElement Maximum value of an element in the array.
     */
    public static void multiplyTwo(int[] array, int maxValueElement) {
        for (int elementArray = 0; elementArray < array.length; elementArray++) {
            if (array[elementArray] < maxValueElement / 2) array[elementArray] *= 2;
        }
    }

    /**
     * The method outputs a one-dimensional array to the console.
     *
     * @param nameArray The string with array name.
     * @param array     Array to output to the console
     */
    public static void printArray(String nameArray, int[] array) {
        System.out.print(nameArray + " =\t[");
        for (int elementArray : array) {
            System.out.print(" " + elementArray);
        }
        System.out.println(" ]");
    }

    /**
     * The method outputs a square array to the console.
     *
     * @param nameArray The string with array name.
     * @param array     Square array to output to the console
     */
    public static void printArray(String nameArray, int[][] array) {
        System.out.println(nameArray + " =");
        for (int[] elements : array) {
            System.out.print("\t\t\t\t|");
            for (int element : elements) System.out.print(" " + element);
            System.out.println(" |");
        }
    }

    /**
     * The method searches for the minimum and maximum elements in the array.
     *
     * @param array Array consisting of elements of random values from 0 to maxElementValue
     */
    public static void minMaxValues(int[] array) {
        int min = array[0], max = array[0];
        for (int arrayElement : array) {
            if (min > arrayElement) min = arrayElement;
            if (max < arrayElement) max = arrayElement;
        }
        System.out.println("Min = " + min + ", max = " + max);
    }

    /**
     * The method returns true if there is a place in the array where the sum of
     * the left and right parts of the array are equal.
     * @param array Integer array
     * @return true or false
     */
    public static boolean isCheckBalance(int[] array){
        int sumLeft = 0, sumRight = 0, arrayElementLeft = 0, arrayElementRight = array.length - 1;
        int iterator = 0;
        do {
            if (sumLeft < sumRight) {
                sumLeft += array[arrayElementLeft];
                arrayElementLeft++;
                iterator++;
            }else if (sumLeft > sumRight) {
                sumRight += array[arrayElementRight];
                arrayElementRight--;
                iterator++;
            } else {
                sumLeft += array[arrayElementLeft];
                arrayElementLeft++;
                iterator++;
                if (iterator < array.length){
                    sumRight += array[arrayElementRight];
                    arrayElementRight--;
                    iterator ++;
                }
            }
        }while(iterator < array.length);
        return sumLeft == sumRight;
    }

    /**
     * The method shifts all elements of the array by n positions.
     * @param numberElements Count elements of array.
     * @param shiftValue The value by which all elements of the array are shifted.
     * @return The array with shifted elements.
     */
    public static int[] shiftElements(int numberElements, int shiftValue){
        int[] array;
        if (numberElements < 0){
            return new int[0];
        }
        array = new int[numberElements];
        System.out.print("Input array:\t [");
        for (int arrayElement = 0; arrayElement < array.length; arrayElement++) {
            array[arrayElement] = (int) (Math.random() * numberElements);
            System.out.print(" " + array[arrayElement]);
        }
        System.out.println(" ]");
        if (shiftValue > 0) {
            for (int i = array.length - 1; i >= 0; i--){
                if (i > shiftValue - 1){
                    array[i] = array[i - shiftValue];
                } else{
                    array[i] = 0;
                }
            }
        } else if (shiftValue < 0){
            for (int i = 0; i < array.length; i++){
                if (i < array.length + shiftValue){
                    array[i] = array[i - shiftValue];
                } else{
                    array[i] = 0;
                }
            }
        }
        return array;
    }

}
