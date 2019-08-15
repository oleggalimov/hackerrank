package org.oleggalimov;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            testCases--;
            String pattern = in.nextLine();
            try {
                Pattern p = Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException pse) {
                System.out.println("Invalid");
            }
        }
    }
}
