public class DecimalNumber {

    //----------------Fields------------------
    private String decimalValue;


    //----------------Constructors------------------

    //Task 1.6
    // 'value' is a string representing a valid decimal number.
    // Constructs a DecimalNumber with the given decimal string value
    public DecimalNumber(String value) {
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(value, 10))
            throw new IllegalArgumentException("value isn't a numeric string in base 10");
        this.decimalValue = value;
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 1.7
    // 'value' is a string representing a valid number in the given 'base' (2, 8, or 10).
    // Constructs a DecimalNumber by converting the given value from the specified base to decimal.
    public DecimalNumber(String value, int base) {
        // ---------------write your code BELOW this line only! ------------------
        if (((base != 2) && (base != 8) && (base != 10)) || (!legalNumericString(value, base)))
            throw new IllegalArgumentException("invalid input");
        if (base == 2)
            value = binaryToDecimal(value);
        if (base == 8)
            value = octalToDecimal(value);
        this.decimalValue = value;
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
        if ((s == null) || (s.length() == 0) || ((s.length() != 1) && (s.charAt(s.length() - 1) == '0')) || (base <= 1) || (base > 10))
            ans = false;
        else {
            for (int i = 0; (i < s.length()) && ans; i++) {
                int digit = toInt(s.charAt(i));
                if (digit < 0 || digit >= base)
                    ans = false;
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number.
    // Increments the number represented by 's' by 1 and returns the result as a string.
    private static String decimalIncrement(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(s, 10)) {
            throw new IllegalArgumentException("s isn't a numeric String in base 10");
        }
            ans = decimalIncrement(s, 1);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.2
    // 's' is a string representing a valid decimal number, 0<='carry'<=1.
    // Increments the number represented by 's' by 'carry'.
    private static String decimalIncrement(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (carry == 0)
            ans = s;
        else {
            if (s.length() == 0)
                ans = "1";
            else {
                char c = s.charAt(0);
                if (c != '9')
                    ans = (char) (c + 1) + s.substring(1);
                else
                    ans = "0" + decimalIncrement(s.substring(1), 1);
            }
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number.
    // Doubles the decimal number represented by 's' and returns the result as a string.
    private static String decimalDouble(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (!legalNumericString(s, 10)) {
            throw new IllegalArgumentException("s isn't a numeric String in base 10");
        }
        ans = decimalDouble(s, 0);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.3
    // 's' is a string representing a valid decimal number, 0<='carry'<=1
    // Doubles the decimal number represented by 's', and adds to it the 'carry'
    private static String decimalDouble(String s, int carry) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        int current = toInt(s.charAt(s.length() - 1));
        if (s.length() == 1) {
            int sum = current * 2 + carry;
            if (sum < 10)
                ans += "" + (sum % 10);
            else
                ans += "" + (sum % 10) + (sum / 10);
        }
        else {
            String lowerPart = s.substring(0, s.length() - 1);
            ans += decimalDouble(lowerPart, 0);
            if(ans.length() > lowerPart.length())
                ans = ans.substring(0, ans.length() - 1) + decimalDouble("" + current, 1);
            else
                ans += decimalDouble("" + current, 0);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.4
    // 's' is a string representing a valid binary number.
    // Converts a binary string 's' to its decimal string representation.
    private static String binaryToDecimal(String s) {
        String ans ="";
        // ---------------write your code BELOW this line only! ------------------
        if (s.length() == 1)
            ans += s;
        else {
            String doubledS = decimalDouble(binaryToDecimal(s.substring(1)));
            if (s.charAt(0) == '1')
                ans += decimalIncrement(doubledS);
            else
                ans += doubledS;
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 1.5
    // 's' is a string representing a valid octal number.
    // Converts an octal string 's' to its decimal string representation.
    private static String octalToDecimal(String s) {
        String ans = "";
        // ---------------write your code BELOW this line only! ------------------
        if (s.length() == 1)
            ans += s;
        else {
            String decimalS = octalToDecimal(s.substring(1));
            ans = decimalDouble(decimalDouble(decimalDouble(decimalS)));
            for (int i = 0; i < toInt(s.charAt(0)); i++)
                ans = decimalIncrement(ans);
        }
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

}
