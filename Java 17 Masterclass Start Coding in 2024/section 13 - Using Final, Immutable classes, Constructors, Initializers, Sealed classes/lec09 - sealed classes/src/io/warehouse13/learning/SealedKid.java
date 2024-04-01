package io.warehouse13.learning;

// Sealed class must have subclasses
public sealed class SealedKid extends SpecialAbstractClass {
    final class GrandKid extends SealedKid {

    }
}
