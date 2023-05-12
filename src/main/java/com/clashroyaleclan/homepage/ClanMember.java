package com.clashroyaleclan.homepage;


public class ClanMember {

    @SerializedName("name")
    private String name;

    @SerializedName("trophies")
    private int trophies;

    @SerializedName("tag")
    private String tag;

    private int wins;
    private int losses;
    

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }


}

