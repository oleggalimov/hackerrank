package org.oleggalimov;

import java.util.Scanner;

public class JavaArraylist {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var lines = new int[scanner.nextInt()][];
        for (int i = 0; i < lines.length; i++) {
            var digits = new int[scanner.nextInt()];
            for (int j = 0; j < digits.length; j++) {
                digits[j] = scanner.nextInt();
            }
            lines[i] = digits;
        }
        var reqCount = scanner.nextInt();
        for (int i = 0; i < reqCount; i++) {
            var lineNum = scanner.nextInt()-1;
            var posNum = scanner.nextInt()-1;
            if (lines.length>lineNum && lines[lineNum].length>posNum & posNum>0) {
                System.out.println(lines[lineNum][posNum]);
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
