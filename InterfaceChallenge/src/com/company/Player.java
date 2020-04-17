package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String playerName;
    private int hitPoints;
    private int power;
    private String weapon;


    public Player(String playerName, int hitPoints, int power, String weapon) {
        this.playerName = playerName;
        this.hitPoints = hitPoints;
        this.power = power;
        this.weapon = weapon;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return playerName + " - " +
                "hitPoints=" + hitPoints +
                ", power=" + power +
                ", weapon='" + weapon;
    }

    @Override
    public List<String> write() {
        List<String> attributes = new ArrayList<>();
        attributes.add(this.playerName);
        attributes.add("" + this.hitPoints);
        attributes.add("" + this.power);
        attributes.add("" + this.weapon);
        return attributes;
    }

    @Override
    public void read(List<String> attributes) {
        if (attributes != null && attributes.size() > 0) {
            this.playerName = attributes.get(0);
            this.hitPoints = Integer.parseInt(attributes.get(1));
            this.power = Integer.parseInt(attributes.get(2));
            this.weapon = attributes.get(3);
        }
    }
}
