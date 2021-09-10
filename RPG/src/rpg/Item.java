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
public class Item {

    Ability ability = new Ability();
    Character character = new Character();
    private String name;
    private boolean useable;
    private int price;
    private String useage = "";
    private int duration;
    private int itemUseage = 0; //道具功能編號 1.治療 2.力量增強 3.防禦增強 4.豬肉 5.動物屠殺 6.惡魔屠殺

    public Item() {
    }

    public int getItemUseage(){
        return itemUseage;
    }
    
    public void setUseage(String useage, int itemUseage) {
        this.useage = useage;
        this.itemUseage = itemUseage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUseable(boolean initial) {
        this.useable = initial;
    }

    public boolean getUseable() {
        return this.useable;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }

    public void healingPotion() {
        setName("治療藥水");
        setUseable(true);
        setPrice(3);
        setUseage("回復3點血量", 1);
    }

    public void powerIncreasePotion() {
        setName("力量增強藥水");
        setUseable(true);
        setPrice(2);
        setUseage("+2力量，持續兩次攻擊，戰鬥結束後消失", 2);
        setDuration(2);
    }

    public void defenceIncreasePotion() {
        setName("防禦增強藥水");
        setUseable(true);
        setPrice(2);
        setUseage("+2防禦，持續兩次攻擊，戰鬥結束後消失", 3);
        setDuration(2);
    }

    public void leather() {
        setName("動物皮");
        setUseable(false);
        setPrice(1);
    }

    public void wolfLeg() {
        setName("狼腿");
        setUseable(false);
        setPrice(1);
    }

    public void lionClaw() {
        setName("獅爪");
        setUseable(false);
        setPrice(1);
    }

    public void pork() {
        setName("豬肉");
        setUseable(true);
        setPrice(2);
        setUseage("回復2點血量，-1防禦", 4);
    }

    public void amimalSlayerMark() {
        setName("動物屠殺者徽章");
        setUseable(true);
        setPrice(4);
        setUseage("與動物戰鬥時，+1攻擊力,+1命中", 5);
    }

    public void heartOfGhost() {
        setName("幽魂之心");
        setUseable(false);
        setPrice(1);
    }

    public void wolfTooth() {
        setName("狼牙");
        setUseable(false);
        setPrice(1);
    }

    public void glass() {
        setName("玻璃");
        setUseable(false);
        setPrice(1);
    }

    public void demomSlayerMark() {
        setName("惡魔屠殺者徽章");
        setUseable(true);
        setPrice(4);
        setUseage("與魔物戰鬥時，+1攻擊力,+1命中", 6);
    }


    
    public void printItem() {
        System.out.print("名稱:" + this.name + "\t價格:" + this.price);
        if (useable) {
            System.out.println("\t用途:" + useage);
            return;
        }
        System.out.println("無功能");
    }
}
