package io.warehouse13.learning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String customLocations = """        
                lake,at the edge of Lake Ness,E:ocean,W:forest,S:well house,N:cave
                ocean,on Dead Man's beach before an angry sea,W:lake
                cave,at the mouth of Tim's bat cave,E:ocean,W:forest,S:lake
                """;


        // game with custom locations
        AdventureGame game = new AdventureGame(customLocations);
        // AdventureGame game = new AdventureGame();
        //game.play("road");
        game.play("lake");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String direction = scanner.nextLine().trim().toUpperCase().substring(0,1);
            if(direction.equals("Q")) break;
            game.move(direction);
        }
    }
}
