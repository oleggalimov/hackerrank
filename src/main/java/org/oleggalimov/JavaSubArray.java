package org.oleggalimov;

import java.util.Scanner;

public class JavaSubArray {

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }
        scan.close();
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum = numbers[j]+sum;
                if (sum<0) result++;
            }
        }
        System.out.println(result);

    }
}
