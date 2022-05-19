package ru.kuymakov.shooters;

import ru.kuymakov.shooters.weapons.Weapon;

public class Shooter {

    String name;
    Weapon weapon;

    public Shooter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public void shoot() {
        if (weapon == null) {
            System.out.println("не могу участвовать в перестрелке");
        } else {
            weapon.shoot();
        }
    }
}
