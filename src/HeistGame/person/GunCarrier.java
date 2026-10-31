package HeistGame.person;

import HeistGame.armor.Gun;

public class GunCarrier {
    private Gun gun;

    public GunCarrier(Gun gun){
        this.gun = gun;
    }

    void setGun(Gun gun){
        this.gun = gun;
    }

    public Gun getGun(){return gun;}
}
