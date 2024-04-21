package io.warehouse13.learning;

import javax.swing.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle rb;
        rb = ResourceBundle.getBundle("BasicText");
        System.out.println(rb.getClass().getName());
        System.out.println(rb.getBaseBundleName());
        System.out.println(rb.keySet());

        System.out.println("***************");
        System.out.printf("%s %s!%n", rb.getString("hello"), rb.getString("world"));
        System.out.println("***************");

        for (Locale locale:  List.of(Locale.FRANCE, Locale.CANADA_FRENCH, Locale.CANADA)) {
            rb = ResourceBundle.getBundle("BasicText", locale);
            System.out.printf("%s %s!%n",
                    rb.getString("hello"), rb.getString("world"));

            ResourceBundle uiComponentBundle = ResourceBundle
                    .getBundle("UIComponents", locale);

            String message = "%s %s!%n".formatted(
                    rb.getString("hello"), rb.getString("world"));

            JOptionPane.showOptionDialog(null,
                    message,
                    uiComponentBundle.getString("first.title"),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{
                            rb.getString("yes"),
                            rb.getString("no")},

                    //new Object[]{
                    //        uiComponentBundle.getString("btn.ok"),
                    //        uiComponentBundle.getString("btn.cancel")},
                    null);

        }



    }
}
