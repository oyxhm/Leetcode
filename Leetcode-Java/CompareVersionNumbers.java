/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

*/


public class CompareVersionNumbers {
    public static int compareVersionNumbers(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int len = Math.min(len1, len2);
        for (int i = 0; i < len; i++) {
            float f1 = Float.parseFloat(s1[i]);
            float f2 = Float.parseFloat(s2[i]);
            int result = Float.compare(f1, f2);
            if (result != 0) {
                return result;
            }
        }   
        if (len1 == len2) {
            return 0;
        } else if (len1 > len2) {
            for (int i = len; i < len1; i++) {
                if (Float.parseFloat(s1[i]) != 0) {
                    return 1;
                }
            }
        } else {
            for (int i = len; i < len2; i++) {
                if (Float.parseFloat(s2[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersionNumbers("0.1", "1.1"));
        System.out.println(compareVersionNumbers("1.1.0", "1.1"));
        System.out.println(compareVersionNumbers("1", "1.1"));
        System.out.println(compareVersionNumbers("1.0", "1"));
    }
}
