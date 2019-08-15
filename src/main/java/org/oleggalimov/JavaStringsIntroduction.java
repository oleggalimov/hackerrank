package org.oleggalimov;

import java.util.Scanner;

public class JavaStringsIntroduction {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String aIsGreaterThanB = A.charAt(0)<=B.charAt(0) ? "No" : "Yes";
        System.out.println(A.length()+B.length());
        System.out.println(aIsGreaterThanB);
        System.out.printf("%s %s\n", capitalize(A, 0), capitalize(B, 0));

    }
    private static String capitalize(String text, int pos) {
        String firstLetter = String.valueOf(text.charAt(pos));
        return text.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }
}
