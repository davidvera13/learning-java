package io.warehouse13.learning;

public class Main {

    public static void main(String[] args) {
        // BAD PRACTICE
	    CheatPlayer cheatPlayer = new CheatPlayer();
        // scope is public
        cheatPlayer.name = "John";
        cheatPlayer.health = 100;
        cheatPlayer.weapon = "Claymore";

        int damage = 10;
        cheatPlayer.loseHealth(damage);
        System.out.println("Remaining health => " + cheatPlayer.healthRemaining());

        damage = 110;
        cheatPlayer.loseHealth(damage);
        System.out.println("Remaining health => " + cheatPlayer.healthRemaining());

        // we can cheat here
        cheatPlayer.health = 240;
        damage = 10;
        cheatPlayer.loseHealth(damage);
        System.out.println("Remaining health => " + cheatPlayer.healthRemaining());

        // GOOD PRACTICE
        System.out.println("***************************");
        Player player = new Player("Walter", 100, "Axe");
        // scope is private, we can't set values
        // player.name = "John";

        damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health => " + player.getHealth());

        damage = 120;
        player.loseHealth(damage);
        System.out.println("Remaining health => " + player.getHealth());

        // we can cheat here
        // player.health = 240;
        damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health => " + player.getHealth());




    }
}
