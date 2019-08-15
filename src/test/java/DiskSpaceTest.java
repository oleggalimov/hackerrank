//package main.java.org.oleggalimov.test;
//
//import org.junit.Test;
//import main.java.org.oleggalimov.tasks.DiskSpace;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashSet;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class DiskSpaceTest {
//
//    @Test
//    public void test1() {
//        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
//    }
//
//    @Test
//    public void test2() {
//        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
//    }
//
//    @Test
//    public void test3() {
//        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
//    }
//    @Test
//    public void test4() {
//        assertFalse(DiskSpace.isWritable(0, 1, new HashSet<>(Collections.singletonList(1))));
//    }
//    @Test
//    public void test5() {
//        assertTrue(DiskSpace.isWritable(999999, 999998, new HashSet<>(Collections.singletonList(1))));
//    }
//    @Test
//    public void test6() {
//
//        assertFalse(DiskSpace.isWritable(999999, 999998, new HashSet<>(Arrays.asList(1,999999))));
//    }
//    @Test
//    public void test7() {
//        assertTrue(DiskSpace.isWritable(999999, 0, new HashSet<>(Arrays.asList(1,999999))));
//    }
//    @Test
//    public void test8() {
//        assertFalse(DiskSpace.isWritable(999999, -1, new HashSet<>(Arrays.asList(1,999999))));
//    }
//    @Test
//    public void test9() {
//        assertFalse(DiskSpace.isWritable(999999, -1, new HashSet<>(Arrays.asList(-1,999999))));
//    }
//
//}