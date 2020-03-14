import java.util.Scanner;

/**
 * Task 1.
 * An empty project was created in IntelliJ IDEA
 * and the main method was registered();
 */
public class HomeworkOne {

    private static Homework homework;

    public static void main(String[] args) {

        homework = new Homework();
        Scanner scanner = new Scanner(System.in);

//        Entering input data for the calculateExpression method
        System.out.println("Task 3.");
        System.out.println("For the calculateExpression method, please\nenter four numeric parameter: a, b, c, d");
        System.out.print("Parameter a: ");
        double varA = scanner.nextDouble();
        System.out.print("Parameter b: ");
        double varB = scanner.nextDouble();
        System.out.print("Parameter c: ");
        double varC = scanner.nextDouble();
        System.out.print("Parameter d: ");
        double varD = scanner.nextDouble();
        System.out.println("Task 3: Output of method result (a * (b + (c / d))) = "
                + homework.calculateExpression(varA, varB, varC, varD) + "\n");

//        Entering input data for the isSumBetweenTenAndTwenty method
        System.out.println("Task 4.");
        System.out.println("For the isSumBetweenTenAndTwenty method, please\nenter two numeric parameter:");
        System.out.print("Parameter 1: ");
        double paramOne = scanner.nextInt();
        System.out.print("Parameter 2: ");
        double paramTwo = scanner.nextInt();
        System.out.println("Result of method: isSumBetweenTenAndTwenty(" + paramOne + ", " + paramTwo + ") = "
                + homework.isSumBetweenTenAndTwenty(paramOne, paramTwo) + "\n");

//        Entering input data for the isNumberPositive method
        System.out.println("Task 5.");
        System.out.println("For the isPositiveNumber method, please\nenter parameter of int type:");
        System.out.print("Parameter: ");
        int paramOnce = scanner.nextInt();
        homework.isPositiveNumber(paramOnce);

//        Entering input data for the isNegativeNumber method
        System.out.println("Task 6.");
        System.out.println("For the isNegativeNumber method, please\nenter parameter of int type:");
        System.out.print("Parameter: ");
        paramOnce = scanner.nextInt();
        System.out.println("The entered number: " + paramOnce + " is a "
                + (homework.isNegativeNumber(paramOnce) ? "negative" : "positive"));

//        Entering input data for the printHello method
        System.out.println("Task 7.");
        System.out.println("For the printHello method, please\nenter parameter of String type:");
        System.out.print("Enter a name: ");
        String sName = scanner.next();
        homework.printHello(sName);
        System.out.println();

//        Entering input data for the isLeapYear method
        System.out.println("Task 8.");
        System.out.println("For the isLeapYear method, please\nenter parameter of int type.");
        System.out.print("Enter the Year: ");
        int paramYear = scanner.nextInt();
        System.out.println("The entered Year: " + paramYear + ", " + (homework.isLeapYear(paramYear)));
    }

}
