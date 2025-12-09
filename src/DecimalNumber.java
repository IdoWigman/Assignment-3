public class DecimalNumber {

    //----------------Fields------------------
    private String decimalValue;


    //----------------Constructors------------------

    //Task 1.6
    // 'value' is a string representing a valid decimal number.
    // Constructs a DecimalNumber with the given decimal string value
    public DecimalNumber(String value) {
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 1.7
    // 'value' is a string representing a valid number in the given 'base' (2, 8, or 10).
    // Constructs a DecimalNumber by converting the given value from the specified base to decimal.
    public DecimalNumber(String value, int base) {
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
    }


    //----------------Public Methods------------------
    // Increments decimalValue by 1.
    public void increment() {
        this.decimalValue = decimalIncrement(this.decimalValue);
    }

    // Multiplies decimalValue by 2.
    public void multiplyByTwo() {
        this.decimalValue = decimalDouble(this.decimalValue);
    }

    // Returns the decimal number as a string.
    public String toString() {
        
        return decimalValue;
        
    }

    // No assumptions
    // Compares this DecimalNumber to another for equality based on their decimal values. If other is null, should return false.
    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof DecimalNumber) {
            equals = this.decimalValue.equals(((DecimalNumber) other).decimalValue);
        }
        return equals;
    }


    //----------------Private Static Functions------------------
    // No assumptions
    // Converts the character 'c' to its integer value, returns -1 if 'c' is not a decimal digit.
    private static int toInt(char c) {
        return "0123456789".indexOf(c);
    }

    //Task 1.1
    // No assumptions
    // Checks if 's' is a valid numeric string in the specified 'base', and if 1<'base'<=10.
    private static boolean legalNumericString(String s, int base) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number.
    // Increments the number represented by 's' by 1 and returns the result as a string.
    private static String decimalIncrement(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number, 0<='carry'<=1.
    // Increments the number represented by 's' by 'carry'.
    private static String decimalIncrement(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number.
    // Doubles the decimal number represented by 's' and returns the result as a string.
    private static String decimalDouble(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number, 0<='carry'<=1
    // Doubles the decimal number represented by 's', and adds to it the 'carry'
    private static String decimalDouble(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.4
    // 's' is a string representing a valid binary number.
    // Converts a binary string 's' to its decimal string representation.
    private static String binaryToDecimal(String s) {
        String ans ="";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.5
    // 's' is a string representing a valid octal number.
    // Converts an octal string 's' to its decimal string representation.
    private static String octalToDecimal(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

}
