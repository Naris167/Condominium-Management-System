package Week_4;

import java.util.ArrayList;

public class Network {
    public class Member { // Member is an inner class of Network
        private String name;
        private ArrayList<Member> friends;
        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void deactivate() {
            members.remove(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }

        public String getName(){
            return name;
        }
    }

    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public ArrayList<Member> getMembers () {
        return members;
    }
}