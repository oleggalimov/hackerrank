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
                "US: $12,324.13\n" +
                "India: Rs.12,324.13\n" +
                "China: ￥12,324.13\n" +
                "France: 12 324,13 €\n",

                byteArrayOutputStream.toString()
        );
    }
    @Test
    public void PatternSyntaxChecker() throws Exception {
        String data = "3\n" +
                "([A-Z])(.+)\n" +
                "[AZ[a-z](a-z)\n" +
                "batcatpat(nat";
        String expected = "Valid\n" +
                "Invalid\n" +
                "Invalid\n";
        runTest(data, PatternSyntaxChecker.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaStringsIntroduction() throws Exception {
        String data = "vuu\n" +
                "vuuuuu";
        String expected = "9\n" +
                "No\n" +
                "Vuu Vuuuuu";
        runTest(data, JavaStringsIntroduction.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaSubstring() throws Exception {
        String data = "Helloworld\n" +
                "3 7\n";
        String expected = "lowo\n";
        runTest(data, JavaSubstring.class.getName());
        Assert.assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void JavaSubstringComparisons() throws Exception {
        String data = "fsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH\n" +
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
        String input = "";
        String expected = "0\n";
        runTest(input, JavaStringTokens.class.getName());
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
