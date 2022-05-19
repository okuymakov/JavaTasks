package ru.kuymakov.cities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class City {

    private String name;
    private List<Way> ways;

    public City(String name, Way... ways) {
        this.name = name;
        for (int i = 0; i < ways.length; i++) {
            for (int j = i + 1; j < ways.length; j++) {
                if (ways[i].getCity().name == ways[j].getCity().name) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.ways = new ArrayList<>(Arrays.asList(ways));
    }

    public void addWay(Way newWay) {
        for (Way way : ways) {
            if (way.getCity().name == newWay.getCity().name) {
                throw new IllegalArgumentException();
            }
        }
        ways.add(newWay);
    }

    public void deleteWay(Way oldWay) {
        ways.remove(oldWay);
    }

    public String getName() {
        return name;
    }

    public List<Way> getWays() {
        return new ArrayList<>(ways);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.ways);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final City other = (City) obj;
        if (!(other instanceof City)) {
            return false;
        }
        if (!Objects.equals(this.ways, other.ways)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + ways;
    }

}
