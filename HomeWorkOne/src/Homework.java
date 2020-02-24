public class Homework {

    /**
     * Task 2.
     * Declare and initialize global variables of a primitive group:
     * numeric, symbolic and logical variables
     */
    byte varByte = -128;
    Short varShort = 32767;
    int varInt = 2147483647;
    long varLong = 922337203685477580L;

    float varFloat = 1.4e-45f;
    double varDouble = 1.7e+308;

    char varChar = '\u1007';

    boolean varBoolean = false;

    // Declare and initialize global variables of a primitive group

    String varString = "";

    /**
     * Task 3.
     * A method that calculates the expression a * (b + (c / d)) and returns the result, where
     *
     * @param a - the input parameter of double type
     * @param b - the input parameter of double type
     * @param c - the input parameter of double type
     * @param d - the input parameter of double type
     * @return result of performing an arithmetic operation a * (b + (c / d))
     */
    public double calculateExpression(double a, double b, double c, double d) {
        double result = 0;
        if (d != 0) {
            result = a * (b + (c / d));
        }
        return result;
    }

    /**
     * Task 4.
     * A method that accepts two numbers as input and checks that their sum is between 10 and 20 (inclusive).
     *
     * @param paramOne - the input parameter of double type
     * @param paramTwo - the input parameter of double type
     * @return - if Yes, return true, otherwise false;
     */
    public boolean isSumBetweenTenAndTwenty(double paramOne, double paramTwo) {
        double sumParam = paramOne + paramTwo;
        return (sumParam >= 10) && (sumParam <= 20);
    }

    /**
     * Task 5.
     * A method that is passed an integer as a parameter, the method must print to the console
     * whether the number is positive or negative.
     * Note: zero is considered a positive number.
     *
     * @param paramOne - the input parameter of int type
     */
    public void isPositiveNumber(int paramOne) {
        if (!(paramOne < 0)) {
            System.out.println("This is a positive number: " + paramOne + "\n");
        } else {
            System.out.println("This is a negative number: " + paramOne + "\n");
        }
    }

    /**
     * Task 6.
     * A method that is passed an integer as a parameter must return ;
     *
     * @param paramOnce - the input parameter of int type
     * @return - true if the number is negative
     */
    public boolean isNegativeNumber(int paramOnce) {
        return paramOnce < 0;
    }

    /**
     * Task 7.
     * A method that is passed a string denoting the name as a parameter
     * should output the message "Hello, name_name!" to the console.
     *
     * @param name - the input parameter of String type
     */
    public void printHello(String name) {
        System.out.println("Hello, " + name);
    }

    /**
     * Task 8.
     * A method that determines whether the year is a leap year and outputs a message to the console.
     * Every 4th year is a leap year, except for every 100th, and every 400th is a leap year.
     *
     * @param year - the input parameter of int type
     * @return - outputs a message
     */
    public String isLeapYear(int year) {
        if ((year % 4 != 0) || (year % 100 == 0) & (year % 400 != 0)) return "is not a leap year";
        return "is a leap year";
    }
}
