package io.warehouse13.learning.v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("Press: ");
        System.out.println("\t0. Print choice options");
        System.out.println("\t1. Print the list of grocery items");
        System.out.println("\t2. Add an item to the list");
        System.out.println("\t3. Change an item in the list");
        System.out.println("\t4. Remove an item from the list");
        System.out.println("\t5. Search an item in the list");
        System.out.println("\t6. Quit the application");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + ", not on file.");
        }
    }

    public static void processArrayList() {
        ArrayList<String> al = new ArrayList<>();
        al.addAll(groceryList.getGroceryList());

        // same as previous
        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        String[] strArr = new String[groceryList.getGroceryList().size()];
        strArr = groceryList.getGroceryList().toArray(strArr);

    }

}
