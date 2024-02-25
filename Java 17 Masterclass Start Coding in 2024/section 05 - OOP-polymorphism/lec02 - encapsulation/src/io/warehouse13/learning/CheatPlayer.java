package io.warehouse13.learning;

public class CheatPlayer {
    // scope is public here...
    // issue 1: We can change health anywhere
    // issue 2: Changing members name impacts the whole project. With getter and setters,
    // changes happen only inside the class
    // issue 3: we must ensure the members are correctly set during setup (we can forget to set a value)

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if(this.health <= 0)
            System.out.println("Player is dead");
        else
            System.out.println("Health : " + this.health);
    }

    public int healthRemaining() {
        return this.health;
    }
}
