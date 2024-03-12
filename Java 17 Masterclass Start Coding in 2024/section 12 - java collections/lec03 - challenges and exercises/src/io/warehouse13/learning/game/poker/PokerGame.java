package io.warehouse13.learning.game.poker;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {
    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startPlay() {
        Collections.shuffle(deck);
        Card.printDeck(deck);
        // splitting in half the deck (we cauld split the deck in 2 with a distance from 10 To 42
        int randomMiddle = new Random().nextInt(10, 42);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);

        // dealing cards
        dealCards();
        System.out.println("***********************");
        pokerHands.forEach(System.out::println);
        // we want to evaluate the hand
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        System.out.println("*********************");
        pokerHands.forEach(checkHand.andThen(System.out::println));

        // managing remaing cards in deck
        int cardsDealt = playerCount * cardsInHand;
        int cardRemaining = deck.size() - cardsDealt;
        // copy the list with remaining
        remainingCards = new ArrayList<>(Collections.nCopies(cardRemaining, null));

        remainingCards.replaceAll(
                card -> deck.get(cardsDealt + remainingCards.indexOf(card)));
        Card.printDeck(remainingCards, "remaining cards", 4);
    }

    private void dealCards() {
        Card[][] hands = new Card[playerCount][cardsInHand];
        for (int deckIndex = 0, i = 0; i < cardsInHand; i++) {
            for (int j = 0; j < playerCount; j++) {
                hands[j][i] = deck.get(deckIndex++);
            }
        }

        int playerNo = 1;
        for (Card[] hand : hands) {
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }
}
