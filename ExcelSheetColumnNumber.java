/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class ExcelSheetColumnNumber {
	public static int excelSheetColumnNumber(String s) {
		int sum = 0;
		for (char c : s.toCharArray()) {
			sum = sum * 26 + c - 'A' + 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(excelSheetColumnNumber("D"));
		System.out.println(excelSheetColumnNumber("AA"));
		System.out.println(excelSheetColumnNumber("AB"));
		System.out.println(excelSheetColumnNumber("AAA"));
	}
}
