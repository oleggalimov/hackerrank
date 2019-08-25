package org.oleggalimov;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile ("<([^\\/\\s<>]+[^<>\\/]*)>([^<>]+)<(\\/\\1[^\\/<>]?)>");
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            boolean find = false;
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                find = true;
            }
            testCases--;
            if (!find) {
                System.out.println("None");
            }
        }
    }
}
