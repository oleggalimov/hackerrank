import org.oleggalimov.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.oleggalimov.PatternSyntaxChecker;


import java.io.*;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllTests {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream console;

    @Before
    public void setup() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        console = System.out;
    }

    @Test
    public void javaCurrencyFormatter() throws Exception {
        double data = 12324.134D;
        runTest(String.valueOf(data), JavaCurrencyFormatter.class.getName());
        Assert.assertEquals(
                "US: $12,324.13\r\n" +
                "India: Rs.12,324.13\r\n" +
                "China: ￥12,324.13\r\n" +
                "France: 12 324,13 €\r\n",

                byteArrayOutputStream.toString()
        );
    }
    @Test
    public void PatternSyntaxChecker() throws Exception {
        String data = "3\r\n" +
                "([A-Z])(.+)\r\n" +
                "[AZ[a-z](a-z)\r\n" +
                "batcatpat(nat";
        String expected = "Valid\r\n" +
                "Invalid\r\n" +
                "Invalid\r\n";
        runTest(data, PatternSyntaxChecker.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaStringsIntroduction() throws Exception {
        String data = "vuu\r\n" +
                "vuuuuu";
        String expected = "9\r\n" +
                "No\r\n" +
                "Vuu Vuuuuu\r\n";
        runTest(data, JavaStringsIntroduction.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaSubstring() throws Exception {
        String data = "Helloworld\r\n" +
                "3 7\r\n";
        String expected = "lowo\r\n";
        runTest(data, JavaSubstring.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaSubstringComparisons() throws Exception {
        String data = "fsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH\r\n" +
                "100";
        String expected = "DJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljh\n" +
                "yotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgklj\n";
        runTest(data, JavaSubstringComparisons.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    String javaStringTokensExpected;
    String javaStringTokensInput;
    @Before
    public void readJavaStringTokensFiles() throws URISyntaxException, IOException {
        Path path;
        byte[] bytes;
        path = Paths.get(getClass().getClassLoader().getResource("JavaStringTokens_EXPECTED").toURI());
        bytes = Files.readAllBytes(path);
        javaStringTokensExpected = new String(bytes);

        path = Paths.get(getClass().getClassLoader().getResource("JavaStringTokens_INPUT").toURI());
        bytes = Files.readAllBytes(path);
        javaStringTokensInput = new String(bytes);

    }
    @Test
    public void JavaStringTokens() throws Exception {
        String input = javaStringTokensInput;
        String expected = javaStringTokensExpected;
        runTest(input, JavaStringTokens.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaStringTokens_withEmptyInput() throws Exception {
        String input = " ";
        String expected = "0\r\n";
        runTest(input, JavaStringTokens.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void JavaRegex() throws Exception {
        String input = "12.12.12.12\r\n" +
                "13.13.13.112\r\n" +
                "VUUT.12.12\r\n" +
                "111.111.11.111\r\n" +
                "1.1.1.1.1.1.1\r\n" +
                ".....\r\n" +
                "1...1..1..1\r\n" +
                "0.0.0.0\r\n" +
                "255.0.255.0\r\n" +
                "266.266.266.266\r\n" +
                "00000.000000.0000000.00001\r\n" +
                "0023.0012.0012.0034";
        String expected = "true\r\n" +
                "true\r\n" +
                "false\r\n" +
                "true\r\n" +
                "false\r\n" +
                "false\r\n" +
                "false\r\n" +
                "true\r\n" +
                "true\r\n" +
                "false\r\n" +
                "false\r\n" +
                "false\r\n";
        runTest(input, JavaRegex.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaRegex2DuplicateWords() throws Exception {
        String input = "5\r\n" +
                "Goodbye bye bye world world world\r\n" +
                "Sam went went to to to his business\r\n" +
                "Reya is is the the best player in eye eye game\r\n" +
                "in inthe\r\n" +
                "Hello hello Ab aB";
        String expected = "Goodbye bye world\r\n" +
                "Sam went to his business\r\n" +
                "Reya is the best player in eye game\r\n" +
                "in inthe\r\n" +
                "Hello Ab\r\n";
        runTest(input, JavaRegex2DuplicateWords.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    String ValidUsernameRegularExpression_EXPECTED;
    String ValidUsernameRegularExpression_INPUT;
    @Before
    public void readValidUsernameRegularExpressionFiles() throws URISyntaxException, IOException {
        Path path;
        byte[] bytes;

        path = Paths.get(getClass().getClassLoader().getResource("ValidUserNameRegularExpression_EXPECTED").toURI());
        bytes = Files.readAllBytes(path);
        ValidUsernameRegularExpression_EXPECTED = new String(bytes);

        path = Paths.get(getClass().getClassLoader().getResource("ValidUserNameRegularExpression_INPUT").toURI());
        bytes = Files.readAllBytes(path);
        ValidUsernameRegularExpression_INPUT = new String(bytes);

    }
    @Test
    public void ValidUsernameRegularExpression_100Rows() throws Exception {
        String input = ValidUsernameRegularExpression_INPUT;
        String expected = ValidUsernameRegularExpression_EXPECTED;
        runTest(input, ValidUsernameRegularExpression.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void ValidUsernameRegularExpression() throws Exception {
        String input = "8\n" +
                "Julia\n" +
                "Samantha\n" +
                "Samantha_21\n" +
                "1Samantha\n" +
                "Samantha?10_2A\n" +
                "JuliaZ007\n" +
                "Julia@007\n" +
                "_Julia007\n";
        String expected = "Invalid\r\n" +
                "Valid\r\n" +
                "Valid\r\n" +
                "Invalid\r\n" +
                "Invalid\r\n" +
                "Valid\r\n" +
                "Invalid\r\n" +
                "Invalid\r\n";
        runTest(input, ValidUsernameRegularExpression.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void TagContentExtractor() throws Exception {
        String input = "4\r\n" +
                "<h1>Nayeem loves counseling</h1>\r\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\r\n" +
                "<Amee>safat codes like a ninja</amee>\r\n" +
                "<SA premium>Imtiaz has a secret crush</SA premium>\r\n";
        String expected = "Nayeem loves counseling\r\n" +
                "Sanjay has no watch\r\n" +
                "So wait for a while\r\n" +
                "None\r\n" +
                "Imtiaz has a secret crush\r\n";
        runTest(input, TagContentExtractor.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    //Java Date and Time
    public void Java_Date_and_Time() {
        String res = Result.findDay(8,5,2015);
        Assert.assertEquals("WEDNESDAY", res);
    }

    private void runTest(final String data, final String className) throws Exception {

        final InputStream input = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        final InputStream old = System.in;

        try {
            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setIn(input);

            final Class<?> cls = Class.forName(className);
            final Method meth = cls.getDeclaredMethod("main", String[].class);
            final String[] params = new String[]{};
            meth.invoke(null, (Object) params);

        } finally {
            System.setOut(console);
            System.setIn(old);
        }
    }
}
