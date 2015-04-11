/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    704 -> AAB
    18280 -> AAAB
    19632 -> ACAB
*/

public class ExcelSheetColumnTitle {
    public static String excelSheetColumnTitle(int n) {
        int i = n, j;
        StringBuilder sb = new StringBuilder();
        while (i != 0) {
            j = i % 26;
            i = i / 26;
            if (j == 0) {
                /*  BE CAREFUL HERE!!!!!!! */
                sb.append('Z');
                i--;   
            } else {
                sb.append(intToChar(j));
            }
        }
        
        return sb.reverse().toString();
    }

    public static char intToChar(int n) {
        char c = (char) ((int)'A' + n - 1);
        return c;
    }

    public static void main(String[] args) {
        System.out.println(excelSheetColumnTitle(3));
        System.out.println(excelSheetColumnTitle(26));
        System.out.println(excelSheetColumnTitle(28));
        System.out.println(excelSheetColumnTitle(52));
        System.out.println(excelSheetColumnTitle(18280));
        System.out.println(excelSheetColumnTitle(19632));
    }
}