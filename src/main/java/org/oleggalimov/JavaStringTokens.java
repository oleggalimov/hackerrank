package org.oleggalimov;

import java.util.Scanner;

public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        scan.close();
        String temp = s.trim();
        String[] strings = temp.split("[^a-zA-Z0-9]+"); //\W+ matches any non-word character
        // (equal to [^a-zA-Z0-9]+) + Quantifier — Matches between one and unlimited times, as many times as possible, giving back as needed
        if (strings.length==1 && strings[0].equals("") ) {
            System.out.println(0);
        } else {
            System.out.println(strings.length);
            for (String element:strings) {
                System.out.println(element);
            }
        }
    }
}
