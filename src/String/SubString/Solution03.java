package String.SubString;

public class Solution03 {

    public int strStr(String haystack, String needle) {

        int hLength = haystack.length();
        int nLength = needle.length();

        if (hLength == 0) {
            if (nLength == 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (nLength == 0) {
                return 0;
            }
        }

        if (nLength > hLength)
            return -1;

        char[] hCharArray = haystack.toCharArray();
        char[] nCharArray = needle.toCharArray();

        int count = 0;
        for (int i = 0, j = 0; i < hLength && j < nLength; i++, j++) {

            if (hLength - i < nLength - j) {
                return -1;
            }

            if (hCharArray[i] == nCharArray[j]) {
                count++;
                if (count == nLength) {
                    return i - j;
                }
            } else {
                i = i - count;
                j = -1;
                count = 0;
            }
        }

        return -1;
    }
}
