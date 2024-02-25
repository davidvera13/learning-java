package io.warehouse13.learning.challenge01burger;


public class BurgerApp {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        System.out.println("**************");
        Meal usRegularMeal = new Meal(0.68);
        System.out.println(usRegularMeal);

        System.out.println("**************");
        Meal euroRegularMeal = new Meal(0.61);
        //euroRegularMeal.addToppings("Ketchup", "Mayo", "Bacon", "Cheddar");
        euroRegularMeal.addToppings("Ketchup", "Mayo", "Bacon");
        System.out.println(euroRegularMeal);
    }
}
