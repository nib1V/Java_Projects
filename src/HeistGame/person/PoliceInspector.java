package HeistGame.person;

import HeistGame.armor.Gun;

public class PoliceInspector extends Member{
    public PoliceInspector(String name, Gun gun, int iq, int physicalStrength){
        super(name, 12, gun, false, iq, physicalStrength);
    }
}
