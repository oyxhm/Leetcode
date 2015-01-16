/*
Validate if a given string is numeric. 
Some examples:
"0"      true
"0.1"    true
"abc"    false

ignore both leading and trailing whitespaces.
If the string contains any non-numeric characters (excluding whitespaces and decimal point), it is not numeric.
“+1” and “-1” are both numeric.
Feel free to work on the challenge that takes exponent into consideration.
*/


class ValidNumber {
    public static boolean validNumber(String s) {
        int i = 0, len = s.length();
        boolean isValidNumber = false;
        while (Character.isWhitespace(s.charAt(i)) && i < len) {
            i++;  // ignore leading whitespaces
        }
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;  // handle positive and negative
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            i++;
            isValidNumber = true;
        }
        if (i < len && s.charAt(i) == '.') {
            i++;  // pass the dot
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isValidNumber = true;
            }
        }
        while (i < len && Character.isWhitespace(s.charAt(i))) {
            i++;  // ignore trailing whitespaces
        }
        return isValidNumber && i == len;
    }

    public static void main(String[] args) {
        String[] testCases = {"1.23", ".12", "  .12", "  .12  ", "  .12.3 "};
        for (String testCase : testCases) {
            System.out.println(validNumber(testCase));
        }
    }
}