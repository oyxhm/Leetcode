/*
Implement atoi to convert a string to an integer.

The atoi function first discards as many whitespace characters as necessary until the
first non-whitespace character is found. Then, starting from this character, takes an
optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace
characters, no conversion is performed.

If no valid conversion could be performed, a zero
value is returned. If the correct value is out of the range of representable values, the
maximum integer value (2147483647) or the minimum integer value (–2147483648) is returned.
*/

class StringToInteger {
    private static final int BASE = 10, MAX = Integer.MAX_VALUE / 10;

    public static int atoi(String s) {
        int ret = 0, i = 0, len = s.length();
        boolean isPositive = true;

        while (s.charAt(i) == ' ' && i < len) {
            i++;
        }
        if (i < len && s.charAt(i) == '-') {
            isPositive = false;
            i++;
        }
        if (i < len && s.charAt(i) == '+') {
            i++;
        }
        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (ret > MAX || ret == MAX && digit >= 8) {
                return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = digit + ret * BASE;
            i++;
        }
        return ret * (isPositive? 1 : -1);
    }

    public static void main(String[] args) {
        String[] testCases = { "-1234", "1234", "+1234", 
                               "  -1234", "  1234", "  +1234",
                               "  1234a", "123456789123456" };
        for (String testCase : testCases) {
            System.out.println(atoi(testCase));         
        }
    }
}