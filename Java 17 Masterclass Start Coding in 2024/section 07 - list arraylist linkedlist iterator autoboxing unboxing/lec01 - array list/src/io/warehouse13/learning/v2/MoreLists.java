package io.warehouse13.learning.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);
        // we can't add item to tbe list...
        System.out.println(list.getClass().getName());

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        // single line
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese"));

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("3rd item = " + groceries.get(2));

        if(groceries.contains("mustard"))
            System.out.println("List contains mustard");

        // add yogurt a second time
        groceries.add("yogurt");
        // index 4 and 8
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));

        // we can remove by index or name
        System.out.println("**************");
        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        // remove first one in the list
        groceries.remove("yogurt");
        System.out.println(groceries);

        // we can remove several entries
            groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        // remove all
        groceries.clear();
        System.out.println(groceries);
        System.out.println("is groceries empty ? " + groceries.isEmpty());

        // we pass a list and add all to current arraylist
        groceries.addAll(List.of("apples", "milk", "mustard",
                "cheese"));
        // we pass an array converted to list to the current arraylist
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        // we can sort list
        System.out.println("**************");
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        // list to array
        System.out.println("**************");
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));

        var groceryArray2 = groceries.toArray(new String[0]);
        System.out.println(Arrays.toString(groceryArray2));
    }
}
