package ru.kuymakov.shooters.weapons;

public class Gun extends Weapon{
    public Gun() {
        super(5,5);
    }

    public Gun(int ammo, int maxAmmo) {
        super(ammo, maxAmmo);
    }
    
    public boolean isCharged() {
        return ammo != 0;
    }
    
    public int discharge() {
        ammo = 0;
        return 0;
    }
    
    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац!");
        }
    }
}
