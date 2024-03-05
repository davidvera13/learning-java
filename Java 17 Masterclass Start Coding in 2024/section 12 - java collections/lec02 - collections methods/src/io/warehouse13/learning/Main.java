package io.warehouse13.learning;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDesk();
        Card.printDeck(deck);

        Card[] cardsArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardsArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardsArray), "Aces of Hearts", 1);
        //Card.printDeck(Arrays.asList(cardsArray));

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        // using n copies
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);


        Collections.addAll(cards, cardsArray);
        Collections.addAll(cards, cardsArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        System.out.println("USING SHUFFLE");
        Card.printDeck(deck);
        Collections.shuffle(deck);
        Card.printDeck(deck);
        System.out.println("USING REVERSE");
        Collections.reverse(deck);
        Card.printDeck(deck);

        System.out.println("USING COMPARATOR");
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        //Collections.sort(deck, sortingAlgorithm);
        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Standard deck sorted by rank & suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Standard deck sorted by rank & suit reversed", 13);

        // sublitsting
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(deck, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);


        int sublistIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + sublistIndex);

        // containss all
        System.out.println("Contains = " + deck.containsAll(tens));
        System.out.println("Contains = " + new HashSet<>(deck).containsAll(tens));


        Collections.shuffle(deck);
        int sublistIndexShuffled = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + sublistIndexShuffled);

        // containss all
        System.out.println("Contains = " + deck.containsAll(tens));
        System.out.println("Contains = " + new HashSet<>(deck).containsAll(tens));

        // Returns: true if the two specified collections have no elements in common.
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Disjoint  = " + disjoint);

        // there are no common element in those collections => returns true
        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("Disjoint  = " + disjoint2);

        // binary search
        // fix  Index -13 out of bounds
        deck.sort(sortingAlgorithm);

        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        // foundIndex = -48 ? it wasn't found
        System.out.println("foundIndex = " + foundIndex);
        System.out.println("foundIndex using indexOf = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "row containing tens", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "row containing tens", 1);

        // Result of 'Collections.replaceAll()' is ignored  => it returns boolean
        if(Collections.replaceAll(deck, tenOfHearts, tenOfClubs))
            System.out.println("Ten of hearts replaced by tens of clubs");
        else
            System.out.println("No tens of heart were found");

        // frequency: count element occurrence in collection
        System.out.println("Tens of clubs cards = " + Collections.frequency(deck, tenOfClubs));

        // min, max
        System.out.println("Best cards ? " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst cards ? " + Collections.min(deck, sortingAlgorithm));

        // rotate
        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by suit and rank", 4);

        // the n last elements become first after rotation, order is maintained
        List<Card> copy = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copy, 2);
        System.out.println("unrotated  = " + deck.subList(0, 13));
        System.out.println("rotated " + 2 + " = " + copy);

        System.out.println("**********************");

        copy = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copy, -2);
        System.out.println("unrotated  = " + deck.subList(0, 13));
        System.out.println("rotated " + -2 + " = " + copy);

        // swap
        copy = new ArrayList<>(deck.subList(0, 13));
        for(int i = 0; i < copy.size() / 2; i++) {
            Collections.swap(copy, i, copy.size() - 1 - i);
        }
        System.out.println("Manual reverse: " + copy);

        // we could have used reverse
        copy = new ArrayList<>(deck.subList(0, 13));
        Collections.reverse(copy);
        System.out.println("Using reverse: " + copy);
    }
}
