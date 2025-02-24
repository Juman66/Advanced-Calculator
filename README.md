
# Advanced Calculator (Java)

This is an advanced calculator implemented in Java, providing basic arithmetic operations, scientific functions, memory storage, and calculation history.

## Features

-   **Basic Arithmetic Operations:** Supports addition, subtraction, multiplication, and division.
-   **Expression Evaluation:** Evaluates complex mathematical expressions with parentheses and operator precedence.
-   **Scientific Functions:** Includes trigonometric functions (sin, cos, tan), logarithmic functions (log, ln), power function, and square root.
-   **Memory Storage:** Stores the last calculated result in memory for later retrieval.
-   **Calculation History:** Maintains a history of all calculations performed.
-   **User-Friendly Interface:** Provides a menu-driven interface for easy navigation and operation.
-   **Error Handling:** Implements robust error handling for invalid input and arithmetic exceptions.

## Getting Started

### Prerequisites

-   Java Development Kit (JDK) installed on your system.

### Compilation and Execution

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    ```

2.  **Navigate to the project directory:**

    ```bash
    cd AdvancedCalculator
    ```

3.  **Compile the Java code:**

    ```bash
    javac AdvancedCalculator.java
    ```

4.  **Run the compiled code:**

    ```bash
    java AdvancedCalculator
    ```

### Usage

1.  **Select an option from the main menu:**
    -   1: Basic Calculation
    -   2: Scientific Calculations
    -   3: Check Memory
    -   4: Check History
    -   5: Exit

2.  **Follow the prompts to enter expressions or select functions.**

3.  **View the results or history as needed.**

## Code Structure

-   `AdvancedCalculator.java`: Contains the main class and all the calculator's functionalities.

## Functions

-   `performArithmetic(double num1, double num2, String operator)`: Performs basic arithmetic operations.
-   `evaluateExpression(String exp)`: Evaluates mathematical expressions.
-   `hasPrecedence(char op1, char op2)`: Checks operator precedence.
-   `applyOp(char op, double b, double a)`: Applies an operator to two operands.
-   `sinFunction(double angleInDegrees)`, `cosFunction(double angleInDegrees)`, `tanFunction(double angleInDegrees)`: Trigonometric functions.
-   `logFunction(double value)`, `lnFunction(double value)`: Logarithmic functions.
-   `powerFunction(double base, double exponent)`: Power function.
-   `squareRootFunction(double value)`: Square root function.
-   `storeInMemory(double result)`: Stores a result in memory.
-   `retrieveFromMemory()`: Retrieves a result from memory.
-   `addToHistory(String entry)`: Adds a calculation entry to the history.
-   `showHistory()`: Displays the calculation history.
-   `main(String[] args)`: The main method for running the calculator.

## Error Handling

-   Handles division by zero.
-   Handles invalid operators.
-   Handles invalid function names.
-   Handles square roots of negative numbers.
-   Handles general exceptions during input or calculation.

## Contributing

Contributions are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
