package main.java.org.oleggalimov.tasks;

import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder builder = new StringBuilder(A);
        String result = A.equals(builder.reverse().toString())? "Yes":"No";
        System.out.println(result);
    }
}
