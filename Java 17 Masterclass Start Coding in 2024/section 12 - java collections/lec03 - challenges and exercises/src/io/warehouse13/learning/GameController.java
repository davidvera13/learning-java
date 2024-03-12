package io.warehouse13.learning;

import io.warehouse13.learning.game.poker.PokerGame;

public class GameController {
    // Think for a moment about a card game that you'd enjoy building, and one you know some of the rules for.
    // 1. Create a deck of cards, either a standard deck, or a deck that's specialized to the card game you want to
    //    create.
    // 2. Shuffle your deck.
    // 3. Deal your players' hands. Pick the number of players playing, and figure out how you'll deal the cards,
    //    one at a time to each hand, or some other way.
    // 4. Evaluate your players' hands for card combinations that are important to the game.
    // 5. Use a combination of java.util.Collections and List methods, to achieve your results.
    //
    // Poker: Five Card Draw
    // This game usually has four or more players.
    // - The dealer shuffles the deck, and asks another player to cut the deck.
    // - The dealer deals the cards one at a time to each player, starting with the player on the dealer's left, until
    //   each player has 5 cards.
    // - Each player evaluates his hand for certain card combinations, called card ranks.
    // - Each player can discard up to 3 cards.
    // - The dealer will replace discarded cards from the remaining pile, in the order they've been shuffled.
    // - Each player reevaluates his hand if he drew new cards, and bets on his hand.
    // This gives us quite a bit to work on, so let's get going.

    public static void main(String[] args) {
        PokerGame fiveCardGame = new PokerGame(4, 5);
        fiveCardGame.startPlay();



    }

}
