package com.clashroyaleclan.homepage;


public class Player {
    @SerializedName("name")
    private String name;

    @SerializedName("trophies")
    private int trophies;

    @SerializedName("tag")
    private String tag;

    @SerializedName("expLevel")
    private int expLevel;

    @SerializedName("bestTrophies")
    private int bestTrophies;

    @SerializedName("wins")
    private int wins;

    @SerializedName("losses")
    private int losses;

    @SerializedName("clan")
    private String clanName;

    @SerializedName("clanTag")
    private String clanTag;




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

    public int getExpLevel() {
        return expLevel;
    }

    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    public int getBestTrophies() {
        return bestTrophies;
    }

    public void setBestTrophies(int bestTrophies) {
        this.bestTrophies = bestTrophies;
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

    public double getWinRate() {
        int totalMatches = wins + losses;
        return totalMatches > 0 ? ((double) wins / totalMatches) * 100 : 0;
    }

    public String getClanTag() {
        return clanTag;
    }
    
    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public String getClanName() {
        return clanName;
    }
    
    public void setClanName(String clanName) {
        this.clanName = clanName;
    }
    
    
}

