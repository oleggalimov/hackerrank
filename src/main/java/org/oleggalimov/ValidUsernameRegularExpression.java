package org.oleggalimov;

import java.util.Scanner;

public class ValidUsernameRegularExpression {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "^[[a-zA-Z]]\\w{7,29}";
}