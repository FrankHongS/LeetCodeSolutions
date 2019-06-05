package Strings.SubString;

import util.Util;

public class Solution {

    public static void main(String[] args) {
        String p1 = "aaaab";
        String p2 = "abccabca";
        String p3 = "abcabcd";
        String p4 = "lloi";
        String p5 = "cbcba";
        String p6 = "bbb";
        String p7 = "issip";
        String p8 = "ababcaabc";
        String p9= "abbabbbabaa";

        String s1 = "ababcabcacbab";
        String s2 = "hello";
        String s3 = "aacbba";
        String s4 = "aaadfabccabcaxyz";
        String s5 = "babba";
        String s6 = "mississippi";
        String s7 = "ababcaababcaabc";
        String s8="ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb";


        Solution solution = new Solution();
//        System.out.println(solution.findRepeat(p2.toCharArray(), 6));

        int[] array1 = new int[p7.length()];
        solution.getNext01(p7, array1);

        Util.printIntArray(array1);

        System.out.println(solution.index(s6, p7, array1));
    }

    private int index(String s, String pattern, int[] next) {
        int sLength = s.length();
        int pLength = pattern.length();

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = pattern.toCharArray();

        for (int i = 0, j = 0; i < sLength && j < pLength; i++, j++) {
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

    // KMP implementation
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

//                int equalCount = 0;
//
//                // 如果当前位置与之前位置有相同字符的情况
//                for (int j = i - 1; j >= 0; j--) {
//                    if (charArray[j] == charArray[i]) {
//                        equalCount++;
//
//                        int temp = j - 1;
//
//                        if (temp < 0) {
//                            target[i] = -1;
//                            break;
//                        }
//
//                        if (charArray[temp] == charArray[i]) {
//                            continue;
//                        }
//
//                        int count = 0;
//                        for (int k = 0; k < temp; k++) {
//                            if (charArray[k] == charArray[(i - 1) - (j - 2 - k)]) {
//                                count++;
//                            } else {
//                                break;
//                            }
//                        }
//
//                        if (count == j - 1) {
//                            target[i] = j - 1;
//                            break;
//                        }
//                    }
//                }
//
//                if (equalCount == 0) {
//                    // 如果当前位置与之前位置没有相同字符的情况
//                    int repeat=findRepeat(charArray,i);
//                    if(repeat!=-1){
//                        target[i]=i-repeat;
//                    }
//                }

                int repeat = findRepeat(charArray, i);
                if (repeat != -1) {
                    if (repeat == -2) {
                        target[i] = -1;
                    } else {
//                        if (charArray[i] == charArray[i - repeat]) {
//                            target[i] = -1;
//                        } else {
                            target[i] = i - repeat;
//                        }
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

        while (t <= i - 1) {
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
//                        break;
                    }
                }
                if (count > 0) {
                    break;
                }

                temp += t;
            }

//            if (count == 0) {
//                return t;
//            }else {
            temp = 0;
//            }

            t++;
        }

        return -1;
    }

}
