package io.warehouse13.learning.challenge01Switch;

import java.util.Random;

public class NatoAlphabet {
    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char c = selectAChar(str);

        switch (c) {
            case 'A':
                System.out.println("Alfa");
                break;
            case 'B':
                System.out.println("Bravo");
                break;
            case 'C':
                System.out.println("Charlie");
                break;
            case 'D':
                System.out.println("Delta");
                break;
            case 'E':
                System.out.println("Echo");
                break;
            case 'F':
                System.out.println("Foxtrot");
                break;
            case 'G':
                System.out.println("Golf");
                break;
            case 'H':
                System.out.println("Hotel");
                break;
            case 'I':
                System.out.println("India");
                break;
            case 'J':
                System.out.println("Juliet");
                break;
            case 'K':
                System.out.println("Kilo");
                break;
            case 'L':
                System.out.println("Lima");
                break;
            case 'M':
                System.out.println("Mike");
                break;
            case 'N':
                System.out.println("November");
                break;
            case 'O':
                System.out.println("Oscar");
                break;
            case 'P':
                System.out.println("Papa");
                break;
            case 'Q':
                System.out.println("Quebec");
                break;
            case 'R':
                System.out.println("Romeo");
                break;
            case 'S':
                System.out.println("Sierra");
                break;
            case 'T':
                System.out.println("Tango");
                break;
            case 'U':
                System.out.println("Uniform");
                break;
            case 'V':
                System.out.println("Victor");
                break;
            case 'W':
                System.out.println("Whiskey");
                break;
            case 'X':
                System.out.println("X-ray");
                break;
            case 'Y':
                System.out.println("Yankee");
                break;
            case 'Z':
                System.out.println("Zulu");
                break;
        }
    }

    public static char selectAChar(String s){
        Random random = new Random();
        int index = random.nextInt(s.length());
        return s.charAt(index);

    }
}
