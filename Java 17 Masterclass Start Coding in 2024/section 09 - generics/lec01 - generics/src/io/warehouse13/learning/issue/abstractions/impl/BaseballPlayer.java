package io.warehouse13.learning.issue.abstractions.impl;

import io.warehouse13.learning.issue.abstractions.Player;

public record BaseballPlayer(String name, String position) implements Player {
}
