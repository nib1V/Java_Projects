package HeistGame.battle;

import HeistGame.person.Member;
import HeistGame.person.Character;
import java.util.ArrayList;
import java.util.List;
import static HeistGame.utilities.Utilities.getRandomVal;

public class Group {
    private final String groupName;
    private List<Member> members;

    public Group(String name){
        if (name.isEmpty()) throw new IllegalArgumentException("No Group name given");
        this.groupName = name;
        members = new ArrayList<Member>(0);
    }

    public String getGroupName(){return groupName;}
    public int getSize(){return members.size();}
    public int getNumberOfAliveMembers(){
        int sum = 0;
        for(int i = 0; i < members.size(); i++){
            if (members.get(i).isAlive()) sum++;
        }
        return sum;
    }

    boolean isDefeated(){return (getNumberOfAliveMembers() == 0);}
    public Member pickRandomAliveMember(){
        if (isDefeated() || getSize() == 0) return null;
        return members.get(getRandomVal(0, getSize() - 1));
    }

    public void addMember(Character member){
        if (member == null) throw new NullPointerException();
        members.add((Member) member);
    }
}
