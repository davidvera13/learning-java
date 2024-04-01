package io.warehouse13.learning;

// circular reference: sealed class must know class that they can extend
public sealed class SpecialAbstractClass
        permits FinalKid, NonSealedKid, SealedKid, SpecialAbstractClass.Kid {

    // must be declared: final, sealed or non sealed
    final class Kid extends SpecialAbstractClass {

    }
}
