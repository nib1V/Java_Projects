package HeistGame.person;

import HeistGame.armor.Gun;

public class HeistMember extends Member{
    public HeistMember(String name, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(name, 10, gun, bodyArmor, iq, physicalStrength);
    }
}
