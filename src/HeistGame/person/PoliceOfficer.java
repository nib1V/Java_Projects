package HeistGame.person;

import HeistGame.armor.Gun;

public class PoliceOfficer extends Member{
    public PoliceOfficer(String name, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(name, 10, gun, bodyArmor,iq, physicalStrength);
    }
}
