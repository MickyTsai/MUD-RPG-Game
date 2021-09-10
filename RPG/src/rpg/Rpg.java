/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author mickytsai
 */
public class Rpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //角色命名
        Player newPlayer = new Player();
        System.out.println("歡迎進入遊戲");
        System.out.print("請輸入角色名稱->");
        newPlayer.getAbility().setName(sc.next());
        System.out.println("你好 " + newPlayer.getAbility().getName());
        System.out.println();
//        System.out.println(newPlayer); 
        

        //選擇起始武器（調用初始武器的ArrayList)
        System.out.println("請選擇一個武器");
        ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
        
        Weapon w1 = new Weapon();
        w1.axe();
        System.out.print("選擇1 ");
        w1.printItem();
        weaponList.add(w1);
        
        Weapon w2 = new Weapon();
        w2.bow();
        System.out.print("選擇2 ");
        w2.printItem();
        weaponList.add(w2);
        
        Weapon w3 = new Weapon();
        w3.wand();
        System.out.print("選擇3 ");
        w3.printItem();
        weaponList.add(w3);
        
        System.out.print("選擇->");
        int chooseW = sc.nextInt();
        System.out.println();
        newPlayer.wearWeapon(weaponList.get(chooseW - 1));
        newPlayer.printAll();
        System.out.println();
        
           
        //選擇起始防具（調用初始防具的ArrayList)
        System.out.println("請選擇一個防具");
        ArrayList<Armor> armorList = new ArrayList<Armor>();   
        
        Armor a1 = new Armor();
        a1.woodenArmor();
        System.out.print("選擇1 ");
        a1.printItem();
        armorList.add(a1);
        
        Armor a2 = new Armor();
        a2.chainMail();
        System.out.print("選擇2 ");
        a2.printItem();
        armorList.add(a2);
        
        Armor a3 = new Armor();
        a3.plateArmor();
        System.out.print("選擇3 ");
        a3.printItem();
        armorList.add(a3);
        
        System.out.print("選擇->");
        int chooseA = sc.nextInt();
        System.out.println();
        newPlayer.wearArmor(armorList.get(chooseA - 1));
        newPlayer.printAll();
        System.out.println();
//        System.out.println(Random(1, 2));
        
        int MapCount = 0;
//        while(true){
//            int Map = Random(1, 2);
//            
//        }   
    }
    public static int Random (int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
}

