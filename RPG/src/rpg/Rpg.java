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
    public static void main(String[] args)throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //角色命名
        Player newPlayer = new Player();
        Player player = new Player();
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
        
        player = newPlayer;//將角色選完武器的狀態先暫存
        int kindCount = 0;
        while(true){
            
            int kind = Random(1, 3);
            kind = 1;
                    
            switch (kind){
                case 1:
                    System.out.println("進入地圖：森林");
                    break;
                case 2:
                    System.out.println("進入地圖：深淵");
                    break;
            }
                       
            
            //地圖：森林
            while (kind == 1 && kindCount < 2 ){
                
                if (newPlayer.getPositon() == 5){
                    //Boss戰
                    System.out.println("遇到Boss !");
                    
                    
                    
                    
                    
                    if(newPlayer.isDead()){
                        kindCount = 0; //步數重算
                        newPlayer = player; //角色回到選完武器的初始
                        break;
                    }
                }
                //事件
                int event =  sc.nextInt();
                switch (event){
                    case 0://沒事發生 
                        System.out.println("沒事發生，繼續走 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        break;
                    
                        
                        
                        
                    case 1://遇到被動怪物 要先抓出怪物
                        ArrayList<Animal> forest = new ArrayList<Animal>();
                        Animal animal1 = new Animal();
                        animal1.wolf();
                        forest.add(animal1);
                        Animal animal2 = new Animal();
                        animal2.lion();
                        forest.add(animal2);
                        Animal animal3 = new Animal();
                        animal3.boar();
                        forest.add(animal3);
                        
                        Animal animal = new Animal();
                        animal = forest.get(Random(0, 3));
                        
                        System.out.println("遇到" + animal.ability.getName() + "要逃跑嗎？ ");
                        System.out.println("選擇1：逃跑\n " + "選擇2：戰鬥 "); 
                        
                        int choose = sc.nextInt();       
                        switch (choose){
                            case 1:
                                System.out.println("你選擇逃跑");
                                Fight fight = new Fight();
                                if(fight.isEscaping(newPlayer, animal)){
                                    System.out.println("逃跑成功");
                                }else{
                                    System.out.println("逃跑失敗 開始戰鬥");
                                    fight.startFight(newPlayer, animal);
                                }    
                            case 2:
                                System.out.println("你選擇戰鬥");
                                Fight fight2 = new Fight();
                                fight2.startFight(newPlayer, animal);
                        }  
                        if(newPlayer.isDead()){
                            kindCount = 0; //步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }
                        newPlayer.goOneStep();
                        break;
                    
                        
                        
                    case 2://遇到主動怪物
                        System.out.println("遇到主動怪物，不能逃跑！ ");
                        
                        //只能戰鬥
                        newPlayer.setFighting(true);//角色進入戰鬥狀態
                        
                        //從深淵怪物ArrayList中隨機取一個怪物
//                        Moster moster2 = new Moster();
//                        moster2 = MosterList.get(Random());
//                        //戰鬥
//                        fight2.startFight(newPlayer, monster2);
                        
                        if(newPlayer.isDead()){
                            kindCount = 0; //步數重算
                            newPlayer = player; //角色回到選完武器的初始
                            break;
                        }    
                        newPlayer.goOneStep();
                    
                    
                    
                    
                    
                    case 3://遇到岔路
                        System.out.println("遇到岔路 ");
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        break;
                    
                    case 4://遇到寶箱

                        Item healingPotion = new Item();
                        healingPotion.healingPotion();
                        
                        switch(kind){
                            case 1:
                                ArrayList<Item> treasureList1 = new ArrayList<Item>();
                                treasureList1.add(healingPotion);
                                Item powerIncreasePotion = new Item();
                                powerIncreasePotion.powerIncreasePotion();
                                treasureList1.add(powerIncreasePotion);
                                Weapon bow = new Weapon();
                                bow.bow();
                                treasureList1.add(bow);
                                newPlayer.getItem(treasureList1.get(Random(0, 3)));
                                break;
                            case 2:
                                ArrayList<Item> treasureList2 = new ArrayList<Item>();
                                Armor leatherArmor = new Armor();
                                leatherArmor.leatherArmor();
                                treasureList2.add(leatherArmor);
                                Item defenseIncreasePotion = new Item();
                                defenseIncreasePotion.powerIncreasePotion();
                                treasureList2.add(defenseIncreasePotion);
                                treasureList2.add(healingPotion);
                                newPlayer.getItem(treasureList2.get(Random(0, 3)));
                                break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        break;
                }
                if(false){//人物死亡
                        kindCount = 0; //步數重算
                        newPlayer = player; //角色回到選完武器的初始
                        break;
                }
            }
            
            
            
            
            //地圖：深淵
            while (kind == 2 && kindCount < 2 ){
                
            }
        
            if (kindCount == 2){
                break;
            }    
        }   
    }
    public static int Random (int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
    

