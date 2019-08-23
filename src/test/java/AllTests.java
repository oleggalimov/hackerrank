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
