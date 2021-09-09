/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 *
 * @author wewe23370030
 */
public class Weapon extends Item {

    private int attack;
    private int weight;
    private boolean initial;

    public Weapon() {
    }

    public void equiqpSword() {
        this.ability.addStr(2);
        this.ability.setCon(10);
    }

    public void equipAxe() {
        this.ability.addStr(4);
        this.ability.setCon(15);
    }

    public void equipWand() {
        this.ability.addStr(-2);
        this.ability.setCon(7);
    }

    public void equipBow() {
        this.ability.addStr(3);
        this.ability.setCon(9);
    }

    public void takeOffSword() {
        this.ability.addStr(-2);
        this.ability.setCon(-10);
    }

    public void takeOffAxe() {
        this.ability.addStr(-4);
        this.ability.setCon(-15);
    }

    public void takeOffWand() {
        this.ability.addStr(2);
        this.ability.setCon(-7);
    }

    public void takeOffpBow() {
        this.ability.addStr(-3);
        this.ability.setCon(-9);
    }

    public void sword() {
        this.setAttack(2);
        this.setWeight(10);
        this.setInitial(true);
        this.setName("劍");
    }

    public void axe() {
        this.setAttack(4);
        this.setWeight(15);
        this.setInitial(true);
        this.setName("斧頭");
    }

    public void wand() {
        this.setAttack(-2);
        this.setWeight(7);
        this.setInitial(true);
        this.setName("法杖");
    }

    public void bow() {
        this.setAttack(3);
        this.setWeight(9);
        this.setInitial(false);
        this.setName("弓箭");
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean getInitial() {
        return this.initial;
    }

    @Override
    public void printItem() {
        System.out.println("名稱:" + this.getName()
                + "\t重量:" + this.getWeight()
                + "\t攻擊力:" + this.getAttack());
    }
}
