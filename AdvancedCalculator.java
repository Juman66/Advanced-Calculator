import java.util.*;
import java.lang.Math;

public class AdvancedCalculator {
    private static double memory = 0;
    private static List<String> history = new ArrayList<>();

    public static double performArithmetic(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Can't be divided by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Sorry but the operator is invalid.");
        }
    }

    public static double evaluateExpression(String exp) {
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < exp.length() && (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.')) {
                    sb.append(exp.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static double sinFunction(double angleInDegrees) {
        return Math.sin(Math.toRadians(angleInDegrees));
    }

    public static double cosFunction(double angleInDegrees) {
        return Math.cos(Math.toRadians(angleInDegrees));
    }

    public static double tanFunction(double angleInDegrees) {
        return Math.tan(Math.toRadians(angleInDegrees));
    }

    public static double logFunction(double value) {
        return Math.log10(value);
    }

    public static double lnFunction(double value) {
        return Math.log(value);
    }

    public static double powerFunction(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRootFunction(double value) {
        if (value < 0) {
            throw new ArithmeticException("Sorry but Square root of negative number cannot be calculated.");
        }
        return Math.sqrt(value);
    }

    public static void storeInMemory(double result) {
        memory = result;
    }

    public static double retrieveFromMemory() {
        return memory;
    }

    public static void addToHistory(String entry) {
        history.add(entry);
    }

    public static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Sorry but there is no history available.");
        } else {
            System.out.println("  Your Calculation History is :");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ADVANCED CALCULATOR:");
            System.out.println("1. WANT TO DO BASIC CALCULATION");
            System.out.println("2. WANT TO DO SCIENTIFIC CALCULATIONS ");
            System.out.println("3. WANT TO CHECK MEMORY");
            System.out.println("4. WANT TO CHECK THE HISTORY");
            System.out.println("5. WANT TO EXIT");
            System.out.print("CHOOSE AN OPTION : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter The Expression: ");
                        String exp = scanner.nextLine();
                        double result = evaluateExpression(exp);
                        System.out.println(" The Result is : " + result);
                        storeInMemory(result);
                        addToHistory(exp + " = " + result);
                        break;
                    case 2:
                        System.out.print("Enter The Function (sin, cos, tan, log, ln, sqrt, power): ");
                        String func = scanner.nextLine();
                        double value;
                        double scientificResult = 0;
                        switch (func.toLowerCase()) {
                            case "sin":
                                System.out.print("Enter the angle : ");
                                value = scanner.nextDouble();
                                scientificResult = sinFunction(value);
                                System.out.println(" The Result is : " + scientificResult);
                                addToHistory("sin(" + value + ") = " + scientificResult);
                                break;
                            case "cos":
                                System.out.print("Enter the angle : ");
                                value = scanner.nextDouble();
                                scientificResult = cosFunction(value);
                                System.out.println(" The Result is : " + scientificResult);
                                addToHistory("cos(" + value + ") = " + scientificResult);
                                break;
                            case "tan":
                                System.out.print("Enter the angle : ");
                                value = scanner.nextDouble();
                                scientificResult = tanFunction(value);
                                System.out.println(" The Result is : " + scientificResult);
                                addToHistory("tan(" + value + ") = " + scientificResult);
                                break;
                            case "log":
                                System.out.print("Enter the value: ");
                                value = scanner.nextDouble();
                                scientificResult = logFunction(value);
                                System.out.println("The Result is : " + scientificResult);
                                addToHistory("log(" + value + ") = " + scientificResult);
                                break;
                            case "ln":
                                System.out.print("Enter the value: ");
                                value = scanner.nextDouble();
                                scientificResult = lnFunction(value);
                                System.out.println("The Result is : " + scientificResult);
                                addToHistory("ln(" + value + ") = " + scientificResult);
                                break;
                            case "sqrt":
                                System.out.print("Enter the value: ");
                                value = scanner.nextDouble();
                                scientificResult = squareRootFunction(value);
                                System.out.println("The Result is : " + scientificResult);
                                addToHistory("sqrt(" + value + ") = " + scientificResult);
                                break;
                            case "power":
                                System.out.print("Enter the base: ");
                                double base = scanner.nextDouble();
                                System.out.print("Enter the exponent: ");
                                double exponent = scanner.nextDouble();
                                scientificResult = powerFunction(base, exponent);
                                System.out.println(" The Result is : " + scientificResult);
                                addToHistory("power(" + base + ", " + exponent + ") = " + scientificResult);
                                break;
                            default:
                                System.out.println("Sorry but the function is not valid.");
                        }
                        if (scientificResult != 0) {
                            storeInMemory(scientificResult);
                        }
                        break;
                    case 3:
                        System.out.println("Memory: " + retrieveFromMemory());
                        break;
                    case 4:
                        showHistory();
                        break;
                    case 5:
                        System.out.println("Exiting the Calculator. Thank you!!!.");
                        return;
                    default:
                        System.out.println("Sorry, but your option is invalid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}