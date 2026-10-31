package HeistGame.battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import HeistGame.armor.*;
import HeistGame.exception.DeadCharacterException;
import HeistGame.person.HeistMastermind;
import HeistGame.person.HeistMember;
import HeistGame.person.Insider;
import HeistGame.person.Member;
import HeistGame.person.PoliceInspector;
import HeistGame.person.PoliceOfficer;
import static HeistGame.utilities.Utilities.getRandomVal;


public class Battle {

    private static final String LINE = "=".repeat(64);
    private static final String THIN_LINE = "-".repeat(64);

    // Statistics collected during the battle (per member)
    private static final Map<Member, Integer> damageDealt = new HashMap<>();
    private static final Map<Member, Integer> kills = new HashMap<>();

    public static void main(String[] args) {
        // List of names for Heist members
        List<String> heistMembersNames = List.of("Tokyo", "Berlin", "Athens", "Abinsk", "Oslo", "Minsk", "Vác",
                "Lima", "Lisbon", "Dublin", "Tashkent", "Kingston", "Fieri");
        String heistMastermindName = "Madrid";
        String heistInsiderName = "HeistInsider";

        // List of names for Police officers
        List<String> policeNames = List.of("Inspector Anna", "Officer Hawk", "Sergeant Blaze", "Detective Raven",
                "Officer George", "Lieutenant Alex", "Captain Falcon", "Officer Georgia",
                "Detective Pantelis", "Sergeant Phoenix", "Lieutenant Tonis", "Officer Gkampi",
                "Detective Amas");
        String policeInspectorName = "Inspector Aguilar";
        String policeInsiderName = "PoliceInsider";

        // Create groups (the rosters keep the members, so that we can print them)
        List<Member> heistRoster = new ArrayList<>();
        List<Member> policeRoster = new ArrayList<>();
        Group heistGroup = createGroup("Heist", true, heistMembersNames, heistMastermindName, heistInsiderName, heistRoster);
        Group policeGroup = createGroup("Police", false, policeNames, policeInspectorName, policeInsiderName, policeRoster);

        // Printing information about the 2 groups before the battle
        printGroupInfo(heistGroup, heistRoster);
        printGroupInfo(policeGroup, policeRoster);

        // Conduct the battle
        int rounds = conductBattle(heistGroup, policeGroup);

        // Printing the results of the battle
        printSummary(heistGroup, heistRoster, policeGroup, policeRoster, rounds);
    }

    // Method to get a random weapon
    private static Gun getRandomWeapon() {
        switch (getRandomVal(0, 3)) {
            case 0:  return new Handgun();
            case 1:  return new Submachine();
            case 2:  return new Shotgun();
            default: return new Rifle();
        }
    }

    private static Group createGroup(String groupName, boolean isHeist, List<String> memberNames,
                                     String leaderName, String insiderName, List<Member> roster) {
        Group group = new Group(groupName);

        // Add regular members
        for (String name : memberNames) {
            boolean bodyArmor = getRandomVal(0, 1) == 1;
            Member member = isHeist
                    ? new HeistMember(name, getRandomWeapon(), bodyArmor, getRandomVal(1, 3), getRandomVal(1, 3))
                    : new PoliceOfficer(name, getRandomWeapon(), bodyArmor, getRandomVal(1, 3), getRandomVal(1, 3));
            roster.add(member);
        }

        // Add the mastermind or the inspector
        Member leader = isHeist
                ? new HeistMastermind(leaderName, getRandomWeapon(), getRandomVal(3, 5), getRandomVal(3, 5))
                : new PoliceInspector(leaderName, getRandomWeapon(), getRandomVal(3, 5), getRandomVal(3, 5));
        roster.add(leader);

        // Add the insider
        roster.add(new Insider(insiderName, getRandomWeapon(), getRandomVal(0, 1) == 1,
                getRandomVal(3, 4), getRandomVal(3, 4)));

        for (Member member : roster) {
            group.addMember(member);
            damageDealt.put(member, 0);
            kills.put(member, 0);
        }
        return group;
    }

    private static void printGroupInfo(Group group, List<Member> roster) {
        System.out.println(LINE);
        System.out.println(" " + group.getGroupName() + " has " + group.getSize() + " members");
        System.out.println(LINE);
        System.out.printf(" %-20s %-16s %-11s %6s %5s %6s%n", "Name", "Role", "Gun", "Health", "Armor", "Atomic");
        System.out.println(THIN_LINE);
        for (Member m : roster) {
            System.out.printf(" %-20s %-16s %-11s %6d %5s %6d%n",
                    m.getName(), m.getClass().getSimpleName(), gunName(m), m.getHealth(),
                    m.hasBodyArmor() ? "yes" : "no", m.calculateAtomicPower());
        }
        System.out.println();
    }

    /**
     * Conducts the battle. In every round a police member attacks first
     * and then (if the battle is not over) a heist member strikes back.
     *
     * @return the number of rounds played
     */
    private static int conductBattle(Group heistGroup, Group policeGroup) {
        System.out.println(LINE);
        System.out.println(" The battle has begun!");
        System.out.println(LINE);

        int round = 0;
        while (!isOver(heistGroup, policeGroup)) {
            round++;
            System.out.println("\nRound " + round);
            System.out.println(THIN_LINE);

            attack(policeGroup, heistGroup);
            if (!isOver(heistGroup, policeGroup)) {
                attack(heistGroup, policeGroup);
            }

            System.out.printf("   >> %s: %d/%d alive | %s: %d/%d alive%n",
                    heistGroup.getGroupName(), heistGroup.getNumberOfAliveMembers(), heistGroup.getSize(),
                    policeGroup.getGroupName(), policeGroup.getNumberOfAliveMembers(), policeGroup.getSize());
        }
        return round;
    }

    private static boolean isOver(Group heistGroup, Group policeGroup) {
        return heistGroup.isDefeated() || policeGroup.isDefeated();
    }

    // A random alive member of the attackers attacks a random alive member of the defenders
    private static void attack(Group attackers, Group defenders) {
        Member attacker = attackers.pickRandomAliveMember();
        Member defender = defenders.pickRandomAliveMember();
        if (attacker == null || defender == null) {
            return;
        }

        int healthBefore = defender.getHealth();
        try {
            attacker.fight(defender);
        } catch (DeadCharacterException ex) {
            System.out.println(" ! " + attacker.getName() + " cannot fight: " + ex.getMessage());
            return;
        }
        int healthAfter = Math.max(0, defender.getHealth());
        int damage = healthBefore - healthAfter;

        String result = damage > 0
                ? damage + " damage, health " + healthBefore + " -> " + healthAfter
                : "no damage, health " + healthAfter;
        String attackerLabel = attacker.getName() + " (" + gunName(attacker) + ")";
        String defenderLabel = defender.getName() + (defender.hasBodyArmor() ? " [armor]" : "");
        System.out.printf(" %-33s attacks %-28s : %s%n", attackerLabel, defenderLabel, result);

        if (damage > 0) {
            damageDealt.put(attacker, damageDealt.get(attacker) + damage);
        }
        if (!defender.isAlive()) {
            kills.put(attacker, kills.get(attacker) + 1);
            System.out.println("   x " + defender.getName() + " (" + defenders.getGroupName()
                    + ") has been eliminated by " + attacker.getName() + "!");
        }
    }

    private static void printSummary(Group heistGroup, List<Member> heistRoster,
                                     Group policeGroup, List<Member> policeRoster, int rounds) {
        System.out.println();
        System.out.println(LINE);
        System.out.println(" The battle ended after " + rounds + " rounds");
        System.out.println(LINE);

        // The battle ends only when one group is defeated, so there cannot be a tie
        Group winner = heistGroup.isDefeated() ? policeGroup : heistGroup;
        System.out.println(" " + winner.getGroupName() + " won!\n");

        printSurvivors(heistGroup, heistRoster);
        printSurvivors(policeGroup, policeRoster);

        // Best fighters of the battle (from both groups)
        List<Member> everyone = new ArrayList<>(heistRoster);
        everyone.addAll(policeRoster);
        Member topDamage = everyone.get(0);
        Member topKiller = everyone.get(0);
        for (Member m : everyone) {
            if (damageDealt.get(m) > damageDealt.get(topDamage)) {
                topDamage = m;
            }
            if (kills.get(m) > kills.get(topKiller)) {
                topKiller = m;
            }
        }
        System.out.println(THIN_LINE);
        System.out.println(" Most damage : " + topDamage.getName() + " (" + damageDealt.get(topDamage) + " damage)");
        System.out.println(" Most kills  : " + topKiller.getName() + " (" + kills.get(topKiller) + " kills)");
        System.out.println(LINE);
    }

    private static void printSurvivors(Group group, List<Member> roster) {
        System.out.println(" " + group.getGroupName() + " alive members: "
                + group.getNumberOfAliveMembers() + "/" + group.getSize());
        for (Member m : roster) {
            if (m.isAlive()) {
                System.out.printf("   - %-20s health: %2d, damage dealt: %2d, kills: %d%n",
                        m.getName(), m.getHealth(), damageDealt.get(m), kills.get(m));
            }
        }
        System.out.println();
    }

    private static String gunName(Member m) {
        return m.getGun() == null ? "none" : m.getGun().getClass().getSimpleName();
    }
}