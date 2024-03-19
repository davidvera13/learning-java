package io.warehouse13.learning.old;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits = new HashMap<>();
        // this value is shared by all locations
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, Integer locationId) {
        exits.put(direction, locationId);
    }

    // getters
    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //return exits;
        // we provide a copy of the hashmap
        // exits can not be modified outside of this class
        return new HashMap<>(exits);
    }
}
