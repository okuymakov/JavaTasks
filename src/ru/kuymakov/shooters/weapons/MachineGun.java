package ru.kuymakov.shooters.weapons;

import ru.kuymakov.utiils.StringUtils;

public class MachineGun extends Gun {

    private int rate;

    public MachineGun() {
        super(30, 30);
        this.rate = 30;
    }

    public MachineGun(int maxAmmo) {
        super(maxAmmo, maxAmmo);
        this.rate = maxAmmo / 2;
    }

    public MachineGun(int rate, int ammo, int maxAmmo) {
        super(ammo, maxAmmo);
        this.rate = rate;
    }

    @Override
    public void shoot() {
        for(int i = 0 ; i < rate; i++) {
            super.shoot();
        }
    }
    
    public void shoot(int n) {
        for(int i = 0 ; i < n * rate; i++) {
            super.shoot();
        }
    }
}
