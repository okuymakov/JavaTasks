package ru.kuymakov.cities;

public class City2 extends City{
    
    public City2(String name, Way... ways) {
        super(name, ways);
        for(Way way : getWays()) {
            way.getCity().addWay(new Way(this, way.getCost()));
        }
    }

    @Override
    public void addWay(Way way) {
        super.addWay(way); 
        way.getCity().addWay(new Way(this, way.getCost()));
    }
    
    
}
