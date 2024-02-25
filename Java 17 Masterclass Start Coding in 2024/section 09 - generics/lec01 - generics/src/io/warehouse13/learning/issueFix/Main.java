package io.warehouse13.learning.issueFix;

import io.warehouse13.learning.issueFix.abstractions.impl.BaseballPlayer;
import io.warehouse13.learning.issueFix.abstractions.impl.FootballPlayer;

public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA",
                "US");

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);
        System.out.println("printing details: " + phillies1);
        phillies1.printDetails();
        System.out.println("printing details: " + astros1);
        astros1.printDetails();

        System.out.println("*****************");

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);
        System.out.println("printing details: " + phillies2);
        phillies2.printDetails();
        System.out.println("printing details: " + astros2);
        astros2.printDetails();

        System.out.println("*****************");


        Team<BaseballPlayer, Affiliation> phillies =
                new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros", philly);
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.addTeamMember(guthrie);
        // we can't add football player in baseball team...
        //var mbappe = new FootballPlayer("K. Mbappé", "Midfield");
        // phillies1.addTeamMember(mbappe);

        System.out.println("printing details: " + phillies);
        phillies.printDetails();
        System.out.println("printing details: " + astros);
        astros.printDetails();

        System.out.println("****************");


        Team<FootballPlayer, String> hawthorn = new Team<>("Hawthorn", "Adelaide ?");
        Team<FootballPlayer, Affiliation> fremantle = new Team<>("Fremantle", philly);
        Team<FootballPlayer, Affiliation> sydneySwans = new Team<>("Sydney Swans", philly);
        Team<FootballPlayer, Affiliation> melbourne = new Team<>("Melbourne", philly);

        // adding players
        var tex = new FootballPlayer("Tex Walker" , "Centre half forward");
        fremantle.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        fremantle.addTeamMember(rory);

        scoreResult(hawthorn, 1, fremantle, 2);
        scoreResult(hawthorn, 3, sydneySwans, 5);
        scoreResult(hawthorn, 5, melbourne, 1);

        scoreResult(fremantle, 4, hawthorn, 1);
        scoreResult(fremantle, 2, sydneySwans, 0);
        scoreResult(fremantle, 1, melbourne, 3);

        scoreResult(sydneySwans, 2, hawthorn, 4);
        scoreResult(sydneySwans, 7, fremantle, 2);
        scoreResult(sydneySwans, 0, melbourne, 3);

        scoreResult(melbourne, 3, hawthorn, 5);
        scoreResult(melbourne, 3, fremantle, 5);
        scoreResult(melbourne, 3, sydneySwans, 5);

        System.out.println("****************");
        System.out.println("printing details: " + hawthorn);
        hawthorn.printDetails();

        System.out.println("printing details: " + fremantle);
        fremantle.printDetails();

        System.out.println("printing details: " + sydneySwans);
        sydneySwans.printDetails();

        System.out.println("printing details: " + melbourne);
        melbourne.printDetails();

        System.out.println("****************");
        System.out.println("Print ranking");
        System.out.println(hawthorn + " : " + hawthorn.ranking());
        System.out.println(fremantle + " : " + fremantle.ranking());
        System.out.println(sydneySwans + " : " + sydneySwans.ranking());
        System.out.println(melbourne + " : " + melbourne.ranking());

        // we can pass any type unless we specify what the generic type extends
        // Team<Integer> integerTeam = new Team<>("Team Number ?");
        // Team<String> stringTeam = new Team<>("Team Number ?");

    }

    // Raw use of parameterized class 'Team'  is discouraged
    //public static void scoreResult(Team team1, int team1Score, Team team2, int team2Score) {
    // we can fix by typing the parameter to the parent interface
    // we can't implement 2 methods with same erasure:
    // > scoreResult(Team<BaseballPlayer, Affiliation> team1, int team1Score, Team<BaseballPlayer, Affiliation> team2, int team2Score)
    // > scoreResult(Team<FootballPlayer, Affiliation> team1, int team1Score, Team<FootballPlayer, Affiliation> team2, int team2Score)
    // have the same erasure, so we can use a wildcard in order to allow to pass Team<BaseballPlayer, Affiliation> or  Team<FootballPlayer, Affiliation>
    // WE REPLACED public static void scoreResult(Team team1, int team1Score, Team team2, int team2Score) {
    // WE REPLACED public static void scoreResult(Team<?, Affiliation> team1, int team1Score, Team<?, Affiliation> team2, int team2Score)
    public static void scoreResult(Team<?, ?> team1, int team1Score, Team<?, ?> team2, int team2Score) {


        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    //public static void scoreResult(Team<BaseballPlayer, Affiliation> team1, int team1Score, Team<BaseballPlayer, Affiliation> team2, int team2Score) {
    //    String message = team1.setScore(team1Score, team2Score);
    //    team2.setScore(team2Score, team1Score);
    //    System.out.printf("%s %s %s %n", team1, message, team2);
    //}

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
