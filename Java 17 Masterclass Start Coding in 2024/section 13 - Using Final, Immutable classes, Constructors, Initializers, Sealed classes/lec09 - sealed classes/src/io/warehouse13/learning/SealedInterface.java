package io.warehouse13.learning;

import java.util.function.Predicate;

public sealed interface SealedInterface
        permits BetterInterface, StringChecker {
    boolean testData(Predicate<String> p, String... strings);
}
