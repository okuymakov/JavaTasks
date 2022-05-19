package ru.kuymakov.shooters.weapons;

public abstract class Weapon {
    protected int ammo;
    final int maxAmmo;

    public Weapon(int ammo, int maxAmmo) {
        if (ammo < 0) {
            throw new RuntimeException();
        }
        if(ammo > maxAmmo) {
            this.ammo = maxAmmo;
        } else {
            this.ammo = ammo;
        } 
        this.maxAmmo = maxAmmo;
    }

    public int getAmmo() {
        return ammo;
    }

    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException();
        } else if (ammo > maxAmmo) {
            this.ammo = maxAmmo;
            return ammo - maxAmmo;
        }
        this.ammo = ammo;
        return 0;
    }

    public abstract void shoot();
}
