package Strings.CNToNumber;

public class Solution {
    private static final CNNumber[] CN_NUMBER_ARRAY = {
            CNNumber.ZERO, CNNumber.ONE, CNNumber.TWO, CNNumber.THREE, CNNumber.FOUR,
            CNNumber.FIVE, CNNumber.SIX, CNNumber.SEVEN, CNNumber.EIGHT, CNNumber.NINE
    };
    private static final CNNumber[] CN_NUMBER_UNIT_ARRAY_1 = {
            CNNumber.TEN, CNNumber.HUNDRED
            , CNNumber.THOUSAND
    };

    private static final CNNumber[] CN_NUMBER_UNIT_ARRAY_2 = {
            CNNumber.WAN, CNNumber.YI
    };

    private enum CNNumber {
        ZERO('零', 0),
        ONE('一', 1),
        TWO('二', 2),
        THREE('三', 3),
        FOUR('四', 4),
        FIVE('五', 5),
        SIX('六', 6),
        SEVEN('七', 7),
        EIGHT('八', 8),
        NINE('九', 9),

        TEN('十', 10),
        HUNDRED('百', 100),
        THOUSAND('千', 1000),
        WAN('万', 10000),
        YI('亿', 100000000);
        private char cn;
        private int number;

        CNNumber(char cn, int number) {
            this.cn = cn;
            this.number = number;
        }

        char getCN() {
            return cn;
        }

        int getNumber() {
            return number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cnArray = {
                "一百二十三", "一千三", "一千零三", "一千零三十", "一万零三十",
                "十万零三十", "一百万零三十", "一万三", "20.01",
                "十", "二", "二百二十万零一"
        };
        for (String cn : cnArray) {
            System.out.println(solution.cnToNumber(cn));
        }
//        System.out.println(1/100f);
    }

    /**
     * 遍历input字符，如果字符为汉语数字，则用临时变量存储；如果是单位，则用之前的临时变量乘以
     * 单位所代表的数量级。
     * 针对形如"一千三"，如果最后一位是数字且前一位是单位，则该数字需乘以前一个单位再除以10，再进行累加；
     *
     * @param input
     * @return
     */
    public float cnToNumber(String input) {
        if (input == null || "".equals(input)) {
            return 0;
        }
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException exception) {
            try {
                float sum = 0;
                for (int i = CN_NUMBER_UNIT_ARRAY_2.length - 1; i >= 0; i--) {
                    String unit = String.valueOf(CN_NUMBER_UNIT_ARRAY_2[i].getCN());
                    if (input.contains(unit)) {
                        String[] strArray = input.split(unit);
                        String numPartStr = strArray[0];
                        float numPart = thousandCNToNumber(numPartStr);
                        sum += numPart * CN_NUMBER_UNIT_ARRAY_2[i].getNumber();
                        input = strArray[1];
                        if (input.length() == 1) {
                            sum += thousandCNToNumber(input) * (CN_NUMBER_UNIT_ARRAY_2[i].getNumber() / 10f);
                            return sum;
                        }
                    }
                }
                if (!"".equals(input)) {
                    sum += thousandCNToNumber(input);
                }
                return sum;
            } catch (Exception e) {
                throw new RuntimeException(String.format("Input(%s) not valid", input));
            }

        }
    }

    private float thousandCNToNumber(String input) {
        char[] charArray = input.toCharArray();
        float sum = 0;
        float temp = 0;
        boolean isCurNumber = false;//当前是否是数字
        boolean isPreUnit = false;//之前一位是否是单位
        float preUnit = 10;
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            boolean validCNNumber = false;
            for (CNNumber cnNumber : CN_NUMBER_ARRAY) {
                if (cur == cnNumber.getCN()) {
                    validCNNumber = true;
                    sum += temp;
                    temp = cnNumber.getNumber();
                    isCurNumber = true;
                    if (i == charArray.length - 1) {
                        if (isPreUnit) {
                            sum += temp * (preUnit / 10);
                        } else {
                            sum += temp;
                        }
                    }
                }
            }
            if (!isCurNumber) {
                for (CNNumber cnNumberUnit : CN_NUMBER_UNIT_ARRAY_1) {
                    if (cur == cnNumberUnit.getCN()) {
                        validCNNumber = true;
                        if (temp == 0) {
                            temp = 1;
                        }
                        temp *= cnNumberUnit.getNumber();
                        preUnit = cnNumberUnit.getNumber();
                        isCurNumber = false;
                        if (i == charArray.length - 1) {
                            sum += temp;
                        }
                    }
                }
            }
            if (!validCNNumber) {
                throw new RuntimeException("Input not valid");
            }
            isPreUnit = !isCurNumber;
            isCurNumber = false;
        }

        return sum;
    }
}
