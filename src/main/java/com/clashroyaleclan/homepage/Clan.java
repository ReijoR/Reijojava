package com.clashroyaleclan.homepage;

import java.util.List;

public class Clan {

    private String name;
    private String tag;
    private List<ClanMember> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ClanMember> getMembers() {
        return members;
    }

    public void setMembers(List<ClanMember> members) {
        this.members = members;
    }
}



