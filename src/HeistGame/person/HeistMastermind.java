package HeistGame.person;

import HeistGame.armor.Gun;

public class HeistMastermind extends Member{
    public HeistMastermind(String name, Gun gun, int iq, int physicalStrength){
        super(name, 15, gun, false, iq, physicalStrength);
    }
}
