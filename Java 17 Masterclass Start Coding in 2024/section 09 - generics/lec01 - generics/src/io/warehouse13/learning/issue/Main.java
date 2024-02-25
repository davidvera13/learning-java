package io.warehouse13.learning.issue;

import io.warehouse13.learning.issue.abstractions.impl.BaseballPlayer;
import io.warehouse13.learning.issue.abstractions.impl.FootballPlayer;

public class Main {
    public static void main(String[] args) {
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);
        System.out.println("****************");
        SportTeam phillies = new SportTeam("Philadelphia Phillies");
        SportTeam astros = new SportTeam("Houston Astros");
        sportsScoreResult(phillies, 3, astros, 5);
        System.out.println("****************");
        // adding players
        var harper = new BaseballPlayer("B. Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B. Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.printDetails();
        System.out.println("****************");

        SportTeam afc1 = new SportTeam ("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker" , "Centre half forward");
        afc1.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc1.addTeamMember(rory);
        // now here we could have a problem ... a baseball player is in a football team ...
        // we need to fix some rules and allow specific players in specific type of teams...
        var guthrie = new BaseballPlayer("D. Guthrie", "Center Fielder");
        afc1.addTeamMember(guthrie);
        afc1.printDetails();
        System.out.println("****************");
    }

    public static void scoreResult(BaseballTeam team1, int team1Score, BaseballTeam team2, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }

    public static void sportsScoreResult(SportTeam team1, int team1Score, SportTeam team2, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);

    }
}
