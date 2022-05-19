package ru.kuymakov.cities;

import java.util.Objects;

public class Way {

    private City city;
    private int cost;

    public Way(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public City getCity() {
        return city;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.city);
        hash = 71 * hash + this.cost;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Way other = (Way) obj;
        if (this.cost != other.cost) {
            return false;
        }
        if (this.city.getName() != other.city.getName()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return city.getName() + ":" + cost;
    }

}
