package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String monsterName;
    private int hitPoints;
    private int power;

    public Monster(String monsterName, int hitPoints, int power) {
        this.monsterName = monsterName;
        this.hitPoints = hitPoints;
        this.power = power;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return monsterName + " - " +
                "hitPoints=" + hitPoints +
                ", power=" + power;
    }

    @Override
    public List<String> write() {
        List<String> attributes = new ArrayList<>();
        attributes.add(this.monsterName);
        attributes.add(String.valueOf(this.hitPoints));
        attributes.add("" + this.power);
        return attributes;
    }

    @Override
    public void read(List<String> attributes) {
        if (attributes != null && attributes.size()>0) {
            this.monsterName = attributes.get(0);
            this.hitPoints = Integer.parseInt(attributes.get(1));
            this.power = Integer.parseInt(attributes.get(2));
        }
    }
}
