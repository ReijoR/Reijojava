package com.clashroyaleclan.homepage;

import java.util.List;

public class Clan {
    private String tag;
    private String name;
    private int clanWarTrophies;
    private List<ClanMember> memberList;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClanWarTrophies() {
        return clanWarTrophies;
    }

    public void setClanWarTrophies(int clanWarTrophies) {
        this.clanWarTrophies = clanWarTrophies;
    }

    public List<ClanMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<ClanMember> memberList) {
        this.memberList = memberList;
    }
}
