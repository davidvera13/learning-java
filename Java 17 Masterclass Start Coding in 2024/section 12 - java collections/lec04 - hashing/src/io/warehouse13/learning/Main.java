package io.warehouse13.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";
        String fText = String.join("l", "he", "lo");

        List<String> hellos = Arrays.asList(
                aText, bText, cText, dText, eText, fText);
        hellos.forEach(str -> System.out.println(str + ":" + str.hashCode()));

        Set<String> strSet = new HashSet<>(hellos);
        // set track duplicates with hashcode
        System.out.println("strSet      : " + strSet);
        System.out.println("strSet size : " + strSet.size());

        for(String strSetValue: strSet) {
            System.out.print("strSetValue: " + strSetValue + ": ");
            for (int i = 0; i < hellos.size(); i++) {
                if (strSetValue == hellos.get(i)) {
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
        }

        System.out.println("****************");
        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpade = new PlayingCard("Spades", "Queen");

        List<PlayingCard> playingCards = Arrays.asList(aceHearts, kingClubs, queenSpade);
        playingCards.forEach(playingCard ->
                System.out.println(playingCard + ": " + playingCard.hashCode()));

        Set<PlayingCard> playingCardSet = new HashSet<>();
        for (PlayingCard card: playingCards) {
            if(!playingCardSet.add(card)) {
                System.out.println("found a duplicate");
            }
        }
        System.out.println(playingCardSet);
    }
}
