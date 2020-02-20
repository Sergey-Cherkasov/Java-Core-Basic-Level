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
     * @param _a - the input parameter of double type
     * @param _b - the input parameter of double type
     * @param _c - the input parameter of double type
     * @param _d - the input parameter of double type
     */
    public double calculateExpression(double _a, double _b, double _c, double _d) {
        return _a * (_b + (_c / _d));
    }

    /**
     * Task 4.
     * A method that accepts two numbers as input and checks that their sum is between 10 and 20 (inclusive).
     *
     * @param _paramOne - the input parameter of double type
     * @param _paramTwo - the input parameter of double type
     * @return - if Yes, return true, otherwise false;
     */
    public boolean isSumBetweenTenAndTwenty(double _paramOne, double _paramTwo) {
        double sumParam = _paramOne + _paramTwo;
        return (sumParam >= 10) && (sumParam <= 20);
    }

    /**
     * Task 5.
     * A method that is passed an integer as a parameter, the method must print to the console
     * whether the number is positive or negative.
     * Note: zero is considered a positive number.
     *
     * @param _paramOne - the input parameter of int type
     */
    public void isPositiveNumber(int _paramOne) {
        if (!(_paramOne < 0)) {
            System.out.println("This is a positive number: " + _paramOne + "\n");
        } else {
            System.out.println("This is a negative number: " + _paramOne + "\n");
        }
    }

    /**
     * Task 6.
     * A method that is passed an integer as a parameter must return ;
     *
     * @param _paramOnce - the input parameter of int type
     * @return - true if the number is negative
     */
    public boolean isNegativeNumber(int _paramOnce) {
        return _paramOnce < 0;
    }

    /**
     * Task 7.
     * A method that is passed a string denoting the name as a parameter
     * should output the message "Hello, name_name!" to the console.
     *
     * @param _name - the input parameter of String type
     */
    public void printHello(String _name) {
        System.out.println("Hello, " + _name);
    }

    /**
     * Task 8.
     * A method that determines whether the year is a leap year and outputs a message to the console.
     * Every 4th year is a leap year, except for every 100th, and every 400th is a leap year.
     *
     * @param _year - the input parameter of int type
     * @return - outputs a message
     */
    public String isLeapYear(int _year) {
        if ((_year % 4 != 0) || (_year % 100 == 0) & (_year % 400 != 0)) return "is not a leap year";
        return "is a leap year";
    }
}
