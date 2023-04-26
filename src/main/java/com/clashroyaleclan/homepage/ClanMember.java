package com.clashroyaleclan.homepage;

public class ClanMember {

    private String name;
    private String tag;
    private String role;
    private int expLevel;
    private int trophies;
    private int donations;
    private int donationsReceived;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getExpLevel() {
        return expLevel;
    }

    public void setExpLevel(int expLevel) {
        this.expLevel = expLevel;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getDonations() {
        return donations;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    public int getDonationsReceived() {
        return donationsReceived;
    }

    public void setDonationsReceived(int donationsReceived) {
        this.donationsReceived = donationsReceived;
    }
}



