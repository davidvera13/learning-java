package io.warehouse13.learning.issueFix.abstractions.impl;

import io.warehouse13.learning.issueFix.abstractions.Player;

public record VolleyballPlayer(String name, String position) implements Player {
    // nothing to implement here because name() is automatically implemented in record with property "name"
}
