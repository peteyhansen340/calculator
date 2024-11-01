import java.util.Scanner

// Calculator class to perform arithmetic operations
class Calculator {
    // Function to add two numbers
    fun add(a: Double, b: Double): Double = a + b

    // Function to subtract two numbers
    fun subtract(a: Double, b: Double): Double = a - b

    // Function to multiply two numbers
    fun multiply(a: Double, b: Double): Double = a * b

    // Function to divide two numbers with error handling
    fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) a / b else {
            println("Cannot divide by zero.")
            0.0
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()

    // Immutable variable (val) for calculator instructions
    val instructions = """
        Select an operation:
        1. Addition (+)
        2. Subtraction (-)
        3. Multiplication (*)
        4. Division (/)
        5. Exit
    """.trimIndent()

    // Mutable variable (var) for loop control
    var isRunning = true

    while (isRunning) {
        println(instructions)
        print("Enter your choice: ")
        val choice = scanner.nextInt()

        if (choice in 1..4) {
            // Get user input for two numbers
            print("Enter first number: ")
            val num1 = scanner.nextDouble()
            print("Enter second number: ")
            val num2 = scanner.nextDouble()

            // Using when expression for operation selection
            val result = when (choice) {
                1 -> calculator.add(num1, num2)
                2 -> calculator.subtract(num1, num2)
                3 -> calculator.multiply(num1, num2)
                4 -> calculator.divide(num1, num2)
                else -> 0.0 // This line should never be reached
            }

            println("Result: $result")
        } else if (choice == 5) {
            println("Exiting calculator. Goodbye!")
            isRunning = false
        } else {
            println("Invalid choice, please try again.")
        }
    }
}
