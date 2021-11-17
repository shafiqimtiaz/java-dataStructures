package com.datastructures.BoyerMooreSearch;

import com.datastructures.HashMap.hashMap;
import java.util.*;

public class boyerMooreSearch {

    static hashMap hm = new hashMap();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Text: ");
        String text = input.nextLine();
        System.out.print("Enter Pattern: ");
        String pattern = input.nextLine();

        input.close();

        int match = BMS(text, pattern);
        System.out.print("Match at index " + match);
    }

    public static int BMS(String text, String pattern) {

        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();
        int numOfSkips = 0;

        for (int i = 0; i < lengthOfText - lengthOfPattern; i += numOfSkips) {
            for (int j = lengthOfPattern - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {

                    if (hm.get(text.charAt(i + j)) != null) {
                        numOfSkips = (int) hm.get(text.charAt(i + j));
                        break;
                    } else {
                        numOfSkips = lengthOfPattern;
                        break;
                    }

                }
            }

            if (numOfSkips == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void preComputeShifts(String text, String pattern) {

        int lengthOfPattern = pattern.length();

        for (int i = 0; i < lengthOfPattern; i++) {

            char actualCharacter = pattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            hm.put(actualCharacter, maxShift);
        }
    }

}
