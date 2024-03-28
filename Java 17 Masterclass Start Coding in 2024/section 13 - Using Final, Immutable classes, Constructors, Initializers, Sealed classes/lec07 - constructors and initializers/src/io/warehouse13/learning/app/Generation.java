package io.warehouse13.learning.app;

import java.time.LocalDate;

// enum type can't be instanciated ... constructor IS private and can't be public
public enum Generation {
    //GEN_Z(2001, 2025),
    GEN_Z() {
        {
            System.out.println(">> initializer for  ... " + this);
        }
    },
    MILLENIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);

    private final int startYear;
    private final int endYear;

    Generation() {
        this(2001, LocalDate.now().getYear());
    }

    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println("Enum constructor Called: " + this);
        //System.out.println("Start: " + startYear + "\tEnd: " + endYear);
    }

    @Override
    public String toString() {
        return this.name() + " " + "startYear=" + startYear + ", endYear=" + endYear;
    }
}
