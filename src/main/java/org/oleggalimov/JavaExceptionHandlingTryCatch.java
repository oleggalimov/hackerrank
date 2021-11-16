package org.oleggalimov;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      System.out.println(x/y);
    } catch (InputMismatchException mismatchException) {
      System.out.println(mismatchException.getClass().getCanonicalName());
    } catch (ArithmeticException arithmeticException) {
      System.out.println("java.lang.ArithmeticException: / by zero");
    }
  }
}
