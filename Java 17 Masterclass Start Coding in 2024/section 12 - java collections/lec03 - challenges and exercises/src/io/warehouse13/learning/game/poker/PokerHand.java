package io.warehouse13.learning.game.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerHand {
    private int playerNo;
    private List<Card> hand;
    private List<Card> keepers;
    private List<Card> discards;

    private Ranking score = Ranking.NONE;

    public PokerHand(int playerNo, List<Card> hand) {
        hand.sort(Card.sortRankReversedSuit());
        this.playerNo = playerNo;
        this.hand = hand;

        this.keepers = new ArrayList<>(this.hand.size());
        this.discards = new ArrayList<>(this.hand.size());
    }

    @Override
    public String toString() {
        return "%d. %-16s Rank:%d %-40s Best:%-7s Worst:%-6s %s".formatted(
                playerNo, score, score.ordinal(), hand,
                Collections.max(hand, Comparator.comparing(Card::rank)),
                Collections.min(hand, Comparator.comparing(Card::rank)),
                (!discards.isEmpty()) ? "Discards:" + discards : "");

        //return "Player %d. %-16s Rank: %d %-40s %s".formatted(
        //        this.playerNo,
        //        score,
        //        score.ordinal(),
        //        hand,
        //        (!discards.isEmpty()) ? "Discards: " + discards: "");
    }

    private void setRank(int faceCount) {
        switch (faceCount) {
            // if i have 4 faces count
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                // if we have 3 faceCount, we can have 3 of a kind of a full house
                if(score == Ranking.NONE) score = Ranking.THREE_OF_A_KIND;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 -> {
                // if we have 2 face count, we can have one pair, a full house or two pairs
                if(score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if(score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;
            }
        }

    }

    public void evalHand() {
        List<String>faceList = new ArrayList<>(hand.size());
        hand.forEach(card -> faceList.add(card.face()));

        List<String> duplicateFaceCards = new ArrayList<>();
        faceList.forEach(face -> {
            if(!duplicateFaceCards.contains(face) &&
                    Collections.frequency(faceList, face) > 1){
                duplicateFaceCards.add(face);
            }
        });

        for (String duplicate : duplicateFaceCards) {
            int start = faceList.indexOf(duplicate);
            int last = faceList.lastIndexOf(duplicate);
            setRank(last - start + 1);
            List<Card> sub = hand.subList(start, last + 1);
            // if we have duplicate faces
            keepers.addAll(sub);
        }

        pickDiscards();
    }

    private void pickDiscards() {
        List<Card> temp = new ArrayList<>(hand);
        temp.removeAll(keepers);
        int rankedCards = keepers.size();
        Collections.reverse(temp);
        int index = 0;
        for (Card card: temp) {
            if (index++ < 3 && (rankedCards > 2 || card.rank() < 9)) discards.add(card);
            else keepers.add(card);
        }
    }
}
