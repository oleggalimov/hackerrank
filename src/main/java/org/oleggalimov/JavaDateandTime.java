//package org.oleggalimov;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class JavaDateandTime {
//    /*
//    Classic: strawberry, banana, pineapple, mango, peach, honey
//    Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
//    Greenie: green apple, lime, avocado, spinach, ice, apple juice
//    Just Desserts: banana, ice cream, chocolate, peanut, cherry
//     */
//
//    public static String ingredients(String order) {
//        HashMap<String, TreeSet<String>> menu = new HashMap<>();
//        menu.put("Classic", Stream.of("strawberry", "banana", "pineapple", "mango", "peach", "honey").collect(Collectors.toCollection(TreeSet::new)));
//        menu.put("Freezie", Stream.of("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt").collect(Collectors.toCollection(TreeSet::new)));
//        menu.put("Greenie", Stream.of("green apple", "lime", "avocado", "spinach", "ice", "apple juice").collect(Collectors.toCollection(TreeSet::new)));
//        menu.put("Just Desserts", Stream.of("banana", "ice cream", "chocolate", "peanut", "cherry").collect(Collectors.toCollection(TreeSet::new)));
//
//        if (order==null || order.length() == 0) {
//            throw new IllegalArgumentException("Sorry, your order has a bad format");
//        } else {
//            int commaPos = order.indexOf(",");
//            String optionName;
//            String ingredientsString=null;
//            if (commaPos!=-1) {
//                optionName = order.substring(0, commaPos);
//                ingredientsString = order.substring(commaPos);
//            } else {
//                optionName=order;
//            }
//            TreeSet ingredients = menu.get(optionName);
//            if (ingredients == null) {
//                throw new IllegalArgumentException("Sorry, there is no ingredients for order: " + order);
//            } else {
//                //there is such option, we have to exclude others
//                if (ingredientsString!=null ) {
//                    if (!ingredientsString.contains("-")) {
//                        throw new IllegalArgumentException("Sorry, there is no ingredients for order: " + order);
//                    }
//                    String [] ingrArray = ingredientsString.split(",-");
//                    ArrayList<String> elements = new ArrayList<>();
//                    for (String ingr : ingrArray) {
//                        if (ingr.contains("-")) {
//                            String [] temp = ingr.split("-");
//                            Collections.addAll(elements, temp);
//                        } else if (ingr.contains(",")) {
//                            String [] temp = ingr.split(",");
//                            Collections.addAll(elements, temp);
//                        } else {
//                            elements.add(ingr);
//                        }
//                    }
//                    elements.forEach(elem-> {
//                        if (!elem.equals("")) {
//                            ingredients.remove(elem.toLowerCase().trim());
//                        }
//                    });
//                    return printSet(ingredients);
//                } else {
//                    return printSet(ingredients);
//
//                }
//
//            }
//        }
//    }
//    private static String printSet(Set<String>ingredients ) {
//        StringBuilder builder = new StringBuilder();
//        ingredients.forEach(ingredient-> builder.append(ingredient).append(","));
//        int lastComma = builder.lastIndexOf(",");
//        if (lastComma!=-1) {
//            builder.deleteCharAt(lastComma);
//        }
//        return builder.toString();
//    }
//}