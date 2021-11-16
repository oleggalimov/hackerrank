package org.oleggalimov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


interface PerformOperation {
    boolean check(Integer num);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return integer -> integer % 2 != 0;
    }

    public PerformOperation isPrime() {
        return integer -> {
            for (int i = 2; i < Math.sqrt(integer); i++) {
                if (integer % i == 0) {
                    return false;
                }
            }
            return true;
        };
        //or in one line:
//        return integer -> java.math.BigInteger.valueOf(integer).isProbablePrime(100);
    }

    public PerformOperation isPalindrome() {
        return integer -> {
            byte[] intStringBytes = Integer.toString(integer).getBytes();
            for (int i = 0; i < intStringBytes.length; i++) {
                if (intStringBytes[i] != intStringBytes[intStringBytes.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        };
        //or in chain:
//        return integer -> new StringBuilder(Integer.toString(integer))
//                .reverse()
//                .toString()
//                .equals(Integer.toString(integer));
//

    }
}


public class JavaLambdaExpression {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}



