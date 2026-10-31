package HeistGame.person;

import HeistGame.armor.Gun;
import HeistGame.exception.DeadCharacterException;

import static HeistGame.utilities.Utilities.getRandomVal;

public abstract class Member extends GunCarrier implements Character{
    private final String name;
    private int health;
    private final boolean bodyArmor;
    private final int iq, physicalStrength;

    public Member(String name, int health, Gun gun, boolean bodyArmor, int iq, int physicalStrength){
        super(gun);
        this.health = health;
        this.name = name;
        this.bodyArmor = bodyArmor;
        this.iq = iq;
        this.physicalStrength = physicalStrength;
    }

    public int getHealth(){return health;}
    public String getName(){return name;}
    public boolean isAlive(){return health > 0;}
    public boolean hasBodyArmor(){return bodyArmor;}
    public void damageHealth(int damage){health -= damage;}
    public int calculateAtomicPower(){return iq + physicalStrength;}

    public int handleHostage(){return getRandomVal(-2, 2);}

    public void fight(Character adversary) throws DeadCharacterException {
        if (!isAlive()) throw new DeadCharacterException(getName());
        int damage = super.getGun().getPower();
        if (!(adversary instanceof Member)) throw new IllegalArgumentException();
        if (adversary instanceof Insider) damage = 2;
        else {
            if (((Member)adversary).hasBodyArmor()) damage /= 2;
            damage += (calculateAtomicPower() - adversary.calculateAtomicPower()) + handleHostage();
        }
        adversary.damageHealth(damage);
    }
}
