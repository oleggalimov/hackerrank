package main.java.org.oleggalimov.tasks;

import java.util.Scanner;

public class JavaAnagrams {
    private static boolean isAnagram(String a, String b) {
        //By condition: Strings  and  consist of English alphabetic characters AND The comparison should NOT be case sensitive => All alphabet is capital characters of Unicode 16
        //Max char is Z which is 90 in int
        final int ALPHABET_MAX_CODE=90;
        if (a.length()!=b.length()) {
            return false;
        } else {
            int wordLength = a.length();
            String aUpperCase = a.toUpperCase();
            String bUpperCase = b.toUpperCase();

            int [] aWord = new int[ALPHABET_MAX_CODE+1];//because the number of last element is 89 if length=90
            int [] bWord = new int[ALPHABET_MAX_CODE+1];
            int charCode;
            for (int i = 0; i < wordLength; i++) {
                //fill A-array
                charCode = aUpperCase.charAt(i);
                aWord[charCode] = (aWord[charCode]+1);
                //fill B-array
                charCode = bUpperCase.charAt(i);
                bWord[charCode] = (bWord[charCode]+1);
            }
            //compare
            for (int i = 0; i < ALPHABET_MAX_CODE; i++) {
                int charCountA = aWord[i];
                int charCountB = bWord[i];
                if ( charCountA!=charCountB ) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
