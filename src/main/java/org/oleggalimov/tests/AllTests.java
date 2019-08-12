package main.java.org.oleggalimov.tests;


import main.java.org.oleggalimov.tasks.JavaCurrencyFormatter;
import main.java.org.oleggalimov.tasks.PatternSyntaxChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

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
