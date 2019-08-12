//package main.java.org.oleggalimov.tests;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import main.java.org.oleggalimov.tasks.JavaDateandTime;
//
//import static org.junit.Assert.assertEquals;
//
//public class JavaDateandTimeTest {
//    //Classic
//    @Test
//    public void classicSmoothie() {
//        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
//                JavaDateandTime.ingredients("Classic"));
//    }
//
//    @Test
//    public void classicSmoothieWithoutStrawberry() {
//        assertEquals("banana,honey,mango,peach,pineapple",
//                JavaDateandTime.ingredients("Classic,-strawberry"));
//    }
//
//    //Freezie
//    @Test
//    public void classicFreezie() {
//        assertEquals("black currant,blackberry,blueberry,frozen yogurt,grape juice",
//                JavaDateandTime.ingredients("Freezie"));
//    }
//
//    @Test
//    public void classicFreezieWithoutBlackCurrant() {
//        assertEquals("blackberry,blueberry,frozen yogurt,grape juice",
//                JavaDateandTime.ingredients("Freezie,-black currant"));
//    }
//
//    //Greenie
//
//    @Test
//    public void classicGreenie() {
//        assertEquals("apple juice,avocado,green apple,ice,lime,spinach",
//                JavaDateandTime.ingredients("Greenie"));
//    }
//
//    @Test
//    public void classicGreenieWithoutLime() {
//        assertEquals("apple juice,avocado,green apple,ice,spinach",
//                JavaDateandTime.ingredients("Greenie,-lime"));
//    }
//
//    //Just Desserts
//
//    @Test
//    public void classicJustDesserts() {
//        assertEquals("banana,cherry,chocolate,ice cream,peanut",
//                JavaDateandTime.ingredients("Just Desserts"));
//    }
//
//    @Test
//    public void classicJustDessertsWithoutIceCream() {
//        assertEquals("banana,cherry,chocolate,peanut",
//                JavaDateandTime.ingredients("Just Desserts,-ice cream"));
//    }
//
//    //bad input
//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
//
//    @Test
//    public void badInput() {
//        exceptionRule.expect(IllegalArgumentException.class);
//        JavaDateandTime.ingredients("asdfasdfa");
//    }
//
//    @Test
//    public void emptyInput() {
//        exceptionRule.expect(IllegalArgumentException.class);
//        exceptionRule.expectMessage("Sorry, your order has a bad format");
//        JavaDateandTime.ingredients("");
//    }
//
//    @Test
//    public void nullInput() {
//        exceptionRule.expect(IllegalArgumentException.class);
//        exceptionRule.expectMessage("Sorry, your order has a bad format");
//        JavaDateandTime.ingredients(null);
//    }
//
//    @Test
//    public void multiPlyMinus() {
//        assertEquals("banana,cherry,chocolate,peanut",
//                JavaDateandTime.ingredients("Just Desserts,---ice cream"));
//    }
//
//    @Test
//    public void onlyMinus() {
//        assertEquals("",
//                JavaDateandTime.ingredients("Just Desserts,-ice cream-banana-cherry-chocolate-peanut"));
//    }
//
//    @Test
//    public void badIngridients() {
//        exceptionRule.expect(IllegalArgumentException.class);
//        JavaDateandTime.ingredients("Classic, chocolate");
//    }
//
//
//    //other
//    @Test
//    public void emptyOutput() {
//        assertEquals("",
//                JavaDateandTime.ingredients("Just Desserts,-ice cream-banana-cherry-chocolate-peanut"));
//
//    }@Test
//    public void lastComma() {
//        assertEquals("banana,honey,mango,peach,pineapple",
//                JavaDateandTime.ingredients("Classic,-strawberry,"));
//
//    }
//}