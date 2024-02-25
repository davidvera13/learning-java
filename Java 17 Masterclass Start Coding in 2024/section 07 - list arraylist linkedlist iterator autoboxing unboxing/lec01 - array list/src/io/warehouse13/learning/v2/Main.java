package io.warehouse13.learning.v2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // arrays are not really flexible, we can't change array size
        // we can pass any type of object
        Object[] groceryItemsObj = new Object[3];
        groceryItemsObj[0] = new GroceryItem("milk");
        groceryItemsObj[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryItemsObj[2] = "5 Oranges";

        System.out.println(Arrays.toString(groceryItemsObj));
        System.out.println("***************");

        // we're more restricted
        GroceryItem[] groceryItems = new GroceryItem[3];
        groceryItems[0] = new GroceryItem("milk");
        groceryItems[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryItems[2] = new GroceryItem("Oranges", "PRODUCE", 5);

        System.out.println(Arrays.toString(groceryItems));
        System.out.println("***************");

        // with array list, size is not fixed on initialization, but type must be defined: row type
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");


        // we expect here a single type of object in the array list
        ArrayList<GroceryItem> groceryItemList = new ArrayList<>();
        groceryItemList.add(new GroceryItem("Butter"));
        groceryItemList.add(new GroceryItem("Yogurt"));
        groceryItemList.add(new GroceryItem("orange", "PRODUCE", 5));
        // we can add first
        groceryItemList.add(0, new GroceryItem("orange", "PRODUCE", 5));
        System.out.println(groceryItemList);

        groceryItemList.remove(2);
        System.out.println(groceryItemList);


    }
}

// using record instead
record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s ", count, name.toUpperCase(), type);
    }
}
