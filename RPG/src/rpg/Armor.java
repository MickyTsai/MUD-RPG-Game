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
public class Armor extends Item {

    private int defense;
    private int weight;
    private boolean initial;

    public Armor() {
    }

    public void equipWoodenArmor() {
        this.ability.setDef(1);
        this.ability.setCon(10);
    }

    public void equipChainMail() {
        this.ability.setDef(2);
        this.ability.setCon(15);
    }

    public void equipPlateArmor() {
        this.ability.setDef(4);
        this.ability.setCon(20);
    }

    public void equipLeatherArmor() {
        this.ability.setDef(2);
        this.ability.setCon(9);
    }

    public void takeOffWoodenArmor() {
        this.ability.setDef(-1);
        this.ability.setCon(-10);
    }

    public void takeOffChainMail() {
        this.ability.setDef(-2);
        this.ability.setCon(-15);
    }

    public void takeOffPlateArmor() {
        this.ability.setDef(-4);
        this.ability.setCon(-20);
    }

    public void takeOffLeatherArmor() {
        this.ability.setDef(-2);
        this.ability.setCon(-9);
    }

    public void woodenArmor() {
        this.setDefense(1);
        this.setWeight(10);
        this.setInitial(true);
        this.setName("木甲");
    }

    public void chainMail() {
        this.setDefense(2);
        this.setWeight(15);
        this.setInitial(true);
        this.setName("鎖子甲");
    }

    public void plateArmor() {
        this.setDefense(4);
        this.setWeight(20);
        this.setInitial(true);
        this.setName("板甲");
    }

    public void leatherArmor() {
        this.setDefense(2);
        this.setWeight(9);
        this.setInitial(false);
        this.setName("皮甲");
    }

    public void setDefense(int attack) {
        this.defense = attack;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public int getDefense() {
        return this.defense;
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
                + "\t防禦力:" + this.getDefense());
    }
}
