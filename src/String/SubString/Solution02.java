package String.SubString;

public class Solution02 {

    public static void main(String[] args) {
        String p2 = "abccabca";
        String p3 = "bbb";
        String p7 = "issip";
        String p9= "abbabbbabaa";

        String s3 = "babba";
        String s4 = "aaadfabccabcaxyz";
        String s6 = "mississippi";
        String s8="ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb";

        Solution02 solution = new Solution02();

        System.out.println(solution.strStr(s8, p9));
    }

    public int strStr(String haystack, String needle) {
        int pLength = needle.length();
        int sLength = haystack.length();

        if (sLength == 0) {
            if (pLength == 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (pLength == 0) {
                return 0;
            }
        }

        if(pLength>sLength)
            return -1;

        char[] sCharArray = haystack.toCharArray();
        char[] pCharArray = needle.toCharArray();


        int[] next = new int[pLength];
        getNext01(needle, next);

        for (int i = 0, j = 0; i < sLength && j < pLength; i++, j++) {

            if(sLength-i<pLength-j){
                return -1;
            }

            if (sCharArray[i] == pCharArray[j]) {
                if (j == pLength - 1) {
                    return i - j;
                }
            } else {
                int n = next[j];
                if (n == -1) {
                    j = -1;
                } else {
                    j = n - 1;
                    i--;
                }
            }
        }

        return -1;
    }

    private void getNext01(String pattern, int[] target) {
        int i=0;
        int j=-1;
        target[0]=-1;

        char[] charArray=pattern.toCharArray();

        while (i<pattern.length()-1){
            if(j==-1||charArray[i]==charArray[j]){
                i++;
                j++;
                target[i]=j;
            }else {
                j=target[j];
            }
        }
    }

    private void getNext(String pattern, int[] target) {
        int size = pattern.length();
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < size; i++) {
            target[i] = 0;
            if (i == 0)
                target[i] = -1;
            else {
                int repeat = findRepeat(charArray, i);
                if (repeat != -1) {
                    if (repeat == -2) {
                        target[i] = -1;
                    } else {
                        target[i] = i - repeat;
                    }
                } else {
                    if (charArray[i] == charArray[0]) {
                        target[i] = -1;
                    }
                }

            }
        }
    }

    private int findRepeat(char[] charArray, int i) {
        int temp = 0;
        int t = 1;

        while (t <= i / 2 + 1) {
            int count = 0;
            while (temp < i) {
                for (int k = 0; k < t; k++) {
                    if (temp + k + t < i) {
                        if (charArray[temp + k] != charArray[temp + k + t]) {
                            count++;
                            break;
                        }
                    } else {
                        if (t == 1 && charArray[0] == charArray[i]) {
                            return -2;
                        }
                        return t;
                    }
                }
                if (count > 0) {
                    break;
                }

                temp += t;
            }

            temp = 0;

            t++;
        }

        return -1;
    }

}
