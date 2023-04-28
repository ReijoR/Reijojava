package com.clashroyaleclan.homepage;

public class ClanMember {

    @SerializedName("name")
    private String name;

    @SerializedName("trophies")
    private int trophies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
}