package com.kyle.practicealgorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuffer> answerRows = generateInputRowList(numRows);
        int i = 0;
        int row = 0;
        int column = 0;
        boolean isRemained = true;
        int count = 0;

        while (isRemained) {
            if (isInputRow(row, column, numRows)) {
                answerRows.get(row).append(s.charAt(i));
                i++;
            }
            row++;
            if (row == numRows) {
                column++;
                row = 0;
            }

            if (s.length() == i) {
                isRemained = false;
            }
        }

        StringBuffer answerBuffer = new StringBuffer();
        for (StringBuffer answerRow : answerRows) {
            answerBuffer.append(answerRow.toString());
        }
        return answerBuffer.toString();
    }

    private static boolean isInputRow(int thisRow, int thisColumn, int numRows) {
        int realRow = numRows - 1;
        if (thisColumn == 0 || (thisColumn % realRow == 0)) {
            return true;
        }
        if (thisRow == realRow - (thisColumn % realRow)) {
            return true;
        }
        return false;
    }


    private static List<StringBuffer> generateInputRowList(int numRows) {
        List<StringBuffer> answerRows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            answerRows.add(new StringBuffer());
        }
        return answerRows;
    }

    //best voted answer
    public static String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    //best speed answer
    public static String convert3(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {

        String input = "PAYPALISHIRING";
        System.out.println(convert(input, 3));
        System.out.println(convert(input, 3).equals("PAHNAPLSIIGYIR"));

        System.out.println(convert(input, 4));
        System.out.println(convert(input, 4).equals("PINALSIGYAHRPI"));

        System.out.println(convert2(input, 3));
        System.out.println(convert2(input, 3).equals("PAHNAPLSIIGYIR"));

        System.out.println(convert2(input, 4));
        System.out.println(convert2(input, 4).equals("PINALSIGYAHRPI"));



    }
}
