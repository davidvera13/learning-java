package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    public static void main(String[] args) {
        String[] names = {
                "Ann Jones",
                "Ann Jones Ph.D.",
                "Bob Jones M.D.",
                "Carol Jones",
                "Ed Green Ph.D.",
                "Ed Green M.D.",
                "Ed Black"};

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println(counts);

        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println(
                "There are " + counts.get(annJonesPhd) +
                " records for " + annJonesPhd);

        // remove titles of names
        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);

        // returns null
        System.out.println(
                "There are " + counts.get(annJonesPhd) +
                        " records for " + annJonesPhd);
        // we have duplicates
        System.out.println(counts);


        StringBuilder annJones = new StringBuilder("Ann Jones");
        System.out.println(
                "There are " + counts.get(annJones) +
                " records for " + annJones);

        // RESULTS ARE NOT THE SAME !!!
        System.out.println("****************************");
        counts.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("****************************");
        counts.keySet().forEach(k -> System.out.println(k + " : " + counts.get(k)));

    }

    private static List<StringBuilder> getNames(String[] names) {
        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for (String name: names) {
            for(int i = 0; i < index;  i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;
    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> names) {
        List<StringBuilder> list = new ArrayList<>();
        for (var name: names) {
            for(String suffix: new String[]{ "Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) > -1) {
                    name.replace(startIndex - 1, startIndex + suffix.length(), "");
                }
            }
            list.add(name);
        }
        return list;
    }
}
