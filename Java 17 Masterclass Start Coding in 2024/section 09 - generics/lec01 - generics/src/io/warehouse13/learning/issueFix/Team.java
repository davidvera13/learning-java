package io.warehouse13.learning.issueFix;

import io.warehouse13.learning.issueFix.abstractions.Player;

import java.util.ArrayList;
import java.util.List;

// T, S, U, V
// some letters are used for some cases:
// E for Element, used extensively for java collections framework
// L for key (used for mapped types)
// N for numbers
// T for types
// V for value

// note that Team<T> can take any object but we can limit object to extends: we add an upper bound
// adding Team<T extends Player>, the type must be a Player or any of its subtypes that implement Player
// for integer, we should have : Type parameter 'java.lang.Integer' is not within its bound;
// should implement 'io.warehouse13.app.lec01generics.issueFix.abstractions.Player'
public class Team<T extends Player, S> {
    private String teamName;
    private S affiliation;
    private List<T> players = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public Team(String teamName, S affiliation) {

        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T player) {
        if (!this.players.contains(player))
            this.players.add(player);
    }

    public void printDetails() {
        System.out.println(this.teamName + " Roster : ");
        System.out.println((affiliation == null ? "" : " AFFILIATION: "+ affiliation));

        //System.out.println(this.players);
        for (T t: players)
            System.out.println(t + " : " + t.name());
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked "  + ranking() + ")";
    }
}
