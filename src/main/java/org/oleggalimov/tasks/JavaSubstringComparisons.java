package main.java.org.oleggalimov.tasks;
import java.util.Scanner;

public class JavaSubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 0; i < s.length()-k+1; i++) {
            String temp = s.substring(i,i+k);
            if (i==0) {
                smallest = temp;
                largest = temp;
            } else {
                if (smallest.compareTo(temp)>0) {
                    smallest=temp;
                } else if (largest.compareTo(temp)<0) {
                    largest=temp;
                }
            }
//            else if (temp.charAt(0)<smallest.charAt(0)) {
//                smallest=temp;
//            } else if (temp.charAt(0)==smallest.charAt(0)) {
//                smallest = deepCompare(smallest, temp, true);
//                smallest.compareTo(temp);
//            } else if (temp.charAt(0)>largest.charAt(0)) {
//                largest=temp;
//            }
//            else if (temp.charAt(0)==largest.charAt(0)) {
//                largest = deepCompare(largest, temp, false);
//            }
        }
        return smallest + "\n" + largest;
    }
    private static String deepCompare(String oldStr, String newStr, boolean smaller) {
            for (int i = 0; i < oldStr.length(); i++) {
                if (oldStr.charAt(i)>newStr.charAt(i)) {
                    return smaller? newStr:oldStr;
                } else if (oldStr.charAt(i)<newStr.charAt(i)){
                    return smaller? oldStr:newStr;
                }
            }
            return oldStr;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
