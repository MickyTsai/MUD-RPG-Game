/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        Fight fight = new Fight();
        Monster monster = new Monster();


        //角色命名
        Player newPlayer = new Player();

        System.out.println("歡迎進入這個冒險國度");
        Thread.sleep(1500);
        System.out.print("請告訴我你的名字是?  ->");
        Thread.sleep(1500);
        String name = sc.next();
        newPlayer.getAbility().setName(name);
        System.out.println("你好 " + newPlayer.getAbility().getName() + " 請享受你的冒險");
        Thread.sleep(1500);
        System.out.println("這是一點小心意 希望對你有幫助");
        Thread.sleep(1500);
        System.out.println();

        newPlayer.wearWeapon(chooseWeapon()); //穿上武器
        newPlayer.wearArmor(chooseArmor()); //穿上防具
        System.out.println();
        System.out.println();
        System.out.println("~~~請享受你的冒險~~~");
        Thread.sleep(1500);
        System.out.println();
        System.out.println();

        int kindCount = 0; //過關的地圖數
        int kind = 0;

        while(true){
            //地圖選擇（隨機）


            if(kind == 0){
                kind = Random(1, 2);
            }
//            kind = 1;// 測試用
            if(newPlayer.isDead()){
                System.out.println("===你已重生 再接再厲!===");
                Thread.sleep(1500);
                System.out.println();
                System.out.println();
            }

            switch (kind){
                case 1:
                    System.out.println("你已進入地圖：森林~ 暗藏危險動物");
                    Thread.sleep(1500);
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("你已進入地圖：深淵~ 有著奇怪的惡魔盤據");
                    Thread.sleep(1500);
                    System.out.println();
                    System.out.println();
                    break;
            }
            if(newPlayer.isDead()){
                newPlayer.setPositon(0);//步數重算
                newPlayer = new Player(); //角色回到選完武器的初始
                newPlayer.ability.setName(name);
                newPlayer.wearWeapon(chooseWeapon()); //穿上武器
                newPlayer.wearArmor(chooseArmor()); //穿上防具
                System.out.println();
                System.out.println();

            }


            //地圖：森林
            while (kind == 1 && kindCount < 2 ){

                while(true){
                    if(newPlayer.isDead()){

                        break;
                    }

                    System.out.println("選擇行動");
                    System.out.println("1.繼續冒險");
                    System.out.println("2.顯示角色狀態 + 顯示裝備");
                    System.out.println("3.打開背包");
                    int choose;
                    try {
                        choose =  sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("沒有這個功能啦!快回去重來!");
                        sc.next();
                        continue;
                    }  // 防呆(抓取可能輸入非數字的錯誤)

                    switch (choose){
                        case 1:
                            System.out.println();
                            System.out.println("深入森林冒險" );
                            break;
                        case 2:
                            newPlayer.printAll();
                            break;
                        case 3:
                            if(newPlayer.getBag().size() == 0){
                                System.out.println("背包裡面空空如也");
                                System.out.println();
                                break;
                            }
                            System.out.println();
                            System.out.println();
                            newPlayer.supply();
                            System.out.println();
                            System.out.println("背包說明：");
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " status = 顯示道具功能 1~" +
                                    newPlayer.getBag().size());
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " use = 使用道具1~" +
                                    newPlayer.getBag().size());
                            System.out.println("輸入exit 來關閉背包");
                            System.out.println("(ex.裕顯示背包中第1個道具的功能，請打：1 status)");

                            String selectIntNum;
                            String selectStr;

                            while (true) {
                                sc.nextLine();  // 先清除scannar中的\n
                                selectIntNum = sc.next();
                                if(selectIntNum.equals("exit")) {
                                    break;
                                }

                                selectStr = sc.next();

                                int selectInt;
                                System.out.println();

                                try {
                                    selectInt = Integer.parseInt(selectIntNum);
                                } catch (NumberFormatException e) {
                                    System.out.println("輸入錯了喔!\n請參照ex，先打裕選擇的道具在背包的第幾個，再打1個空格，再打執行的功能喔！");
                                    continue;
                                }

                                if (selectInt < 1 || selectInt > newPlayer.getBag().size()) {
                                    System.out.println("恭喜獲得隱藏版道具!\n...才怪沒有這個東西啦!\n快去重新輸入!");
                                    continue;
                                }

                                if(selectStr.equals("use")){
                                    boolean bo = newPlayer.use(selectInt);
                                    if(bo){
                                        System.out.println("成功使用");
                                        break;
                                    }
                                    if(!bo){
                                        System.out.println("此道具無法使用");
                                        break;
                                    }
                                }else if(selectStr.equals("status")){
                                    newPlayer.getBag().get(selectInt - 1).printItem();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("沒有這個功能啦!快回去重來!");
                    }
                    if(choose == 1){
                        break;
                    }
                }


                //Boss戰
                if (newPlayer.getPositon() == 5){
                    System.out.println("遇到Boss !");
                    Thread.sleep(1500);
                    Animal boss = new Animal();
                    boss.elephant();
                    System.out.println("Boss是" + boss.ability.getName() + "!" );
                    Thread.sleep(1500);
                    fight.startFight(newPlayer, boss);

                    if(newPlayer.isDead()){

                        break;
                    }
                    kindCount++; //沒死＝勝利
                    kind = 2; //切換到另一張地圖
                    newPlayer.setPositon(0);//步數重算
                    if(kindCount == 1){
                        System.out.println("你已征服這個地圖");
                        Thread.sleep(1500);
                        System.out.println("你將前往深淵!!!");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println();
                        System.out.println("你已進入地圖：深淵~ 有著奇怪的惡魔盤據");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println();
                    }
                    break;
                }


                //事件
                int event = Random(0, 4);
//                event = sc.nextInt();// 測試用

                switch (event){
                    case 0://沒事發生
                        System.out.println();
                        System.out.println();
                        System.out.println("沒事發生，繼續走 ");
                        Thread.sleep(1500);
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;

                    case 1://遇到被動怪物 要先抓出怪物
//                        Animal animal = new Animal();
//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Animal animal = monster.genAnimal();//隨機挑怪物
                        System.out.println("遇到 " + animal.ability.getName() + " 雙方大眼瞪小眼 你要逃跑嗎? ");
                        Thread.sleep(1500);
                        System.out.println("選擇1：逃跑\n" + "選擇2：戰鬥\n" + "選擇3：使用道具 ");
                        int choose = sc.nextInt();

                        switch (choose){
                            case 1:
                                System.out.println("你選擇逃跑");
                                if(fight.isEscaping(newPlayer, animal)){
                                    System.out.println("逃跑成功");
                                }else{
                                    System.out.println("逃跑失敗 開始戰鬥");
                                    fight.startFight(newPlayer, animal);
                                }
                                break;
                            case 2:
                                System.out.println("你選擇拼了");
                                fight.startFight(newPlayer, animal);
                                break;
                            case 3:
                                if(newPlayer.getBag().size() == 0){
                                    System.out.println("背包裡面空空如也");
                                    Thread.sleep(1500);
                                    System.out.println("還想用道具!? 認命戰鬥吧");
                                    Thread.sleep(1500);
                                    fight.startFight(newPlayer, animal);
                                    break;
                                }
                                System.out.println();
                                System.out.println();
                                newPlayer.supply();
                                System.out.println();
                                System.out.println("背包說明：");
                                System.out.println("1~" + newPlayer.getBag().size() +
                                        " status = 顯示道具功能 1~" +
                                        newPlayer.getBag().size());
                                System.out.println("1~" + newPlayer.getBag().size() +
                                        " use = 使用道具1~" +
                                        newPlayer.getBag().size());
                                System.out.println("輸入exit 來關閉背包");
                                System.out.println("(ex.裕顯示背包中第1個道具的功能，請打：1 status)");

                                String selectIntNum;
                                String selectStr;

                                while (true) {
                                    sc.nextLine();  // 先清除scannar中的\n
                                    selectIntNum = sc.next();
                                    if(selectIntNum.equals("exit")) {
                                        System.out.println("背包關上!");
                                        break;
                                    }

                                    selectStr = sc.next();

                                    int selectInt;
                                    System.out.println();

                                    try {
                                        selectInt = Integer.parseInt(selectIntNum);
                                    } catch (NumberFormatException e) {
                                        System.out.println("輸入錯了喔!\n請參照ex，先打裕選擇的道具在背包的第幾個，再打1個空格，再打執行的功能喔！");
                                        continue;
                                    }

                                    if (selectInt < 1 || selectInt > newPlayer.getBag().size()) {
                                        System.out.println("恭喜獲得隱藏版道具!\n...才怪沒有這個東西啦!\n快去重新輸入!");
                                        continue;
                                    }

                                    if(selectStr.equals("use")){
                                        boolean bo = newPlayer.use(selectInt);
                                        if(bo){
                                            System.out.println("成功使用");
                                            break;
                                        }
                                        if(!bo){
                                            System.out.println("此道具無法使用");
                                            break;
                                        }
                                    }else if(selectStr.equals("status")){
                                        newPlayer.getBag().get(selectInt - 1).printItem();
                                        break;
                                    }
                                }
                                System.out.println("還想用道具!? 認命戰鬥吧");
                                fight.startFight(newPlayer, animal);
                                break;

                        }
                        if(newPlayer.isDead()){
                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;

                    case 2://遇到主動怪物

//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Animal animal2 = monster.genAnimal();//隨機挑怪物
                        System.out.println(animal2.ability.getName() + "主動攻擊你 逃不掉拉!");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println("戰鬥開始");
                        fight.startFight(newPlayer, animal2);

                        if(newPlayer.isDead()){

                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;


                    case 3: //遇到岔路
                        System.out.println();
                        System.out.println();
                        System.out.println("發現一個小叉路! 但看起來好恐怖 還是繼續往前吧 ");
                        Thread.sleep(1500);
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;

                    case 4://遇到寶箱
                        System.out.println();
                        System.out.println();
                        System.out.println("發現寶箱!!! ");
                        Thread.sleep(1500);
                        ArrayList<Item> treasureList1 = new ArrayList<Item>();
                        Item healingPotion = new Item();
                        healingPotion.healingPotion();
                        treasureList1.add(healingPotion);

                        Item powerIncreasePotion = new Item();
                        powerIncreasePotion.powerIncreasePotion();
                        treasureList1.add(powerIncreasePotion);

                        Weapon bow = new Weapon();
                        bow.bow();
                        treasureList1.add(bow);

                        newPlayer.getItem(treasureList1.get(Random(0, 2)));
                        Thread.sleep(1500);
                        System.out.println();


                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;
                }
                if(newPlayer.isDead()){
                    break;
                }
            }




            //地圖：深淵
            while (kind == 2 && kindCount < 2 ){
                while(true){
                    if(newPlayer.isDead()){

                        break;
                    }

                    System.out.println("選擇行動");
                    System.out.println("1.繼續冒險");
                    System.out.println("2.顯示角色狀態 + 顯示裝備");
                    System.out.println("3.打開背包");
                    int choose;

                    try {
                        choose =  sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("沒有這個功能啦!快回去重來!");
                        sc.next();
                        continue;
                    }  // 防呆(抓取可能輸入非數字的錯誤)

                    switch (choose){
                        case 1:
                            System.out.println();
                            System.out.println("深入深淵冒險" );
                            break;
                        case 2:
                            newPlayer.printAll();
                            break;
                        case 3:
                            if(newPlayer.getBag().size() == 0){
                                System.out.println("背包裡面空空如也");
                                System.out.println();
                                break;
                            }
                            System.out.println();
                            System.out.println();
                            newPlayer.supply();
                            System.out.println();
                            System.out.println("背包說明：");
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " status = 顯示道具功能 1~" +
                                    newPlayer.getBag().size());
                            System.out.println("1~" + newPlayer.getBag().size() +
                                    " use = 使用道具1~" +
                                    newPlayer.getBag().size());
                            System.out.println("輸入exit 來關閉背包");
                            System.out.println("(ex.裕顯示背包中第1個道具的功能，請打：1 status)");

                            String selectIntNum;
                            String selectStr;

                            while (true) {
                                sc.nextLine();  // 先清除scannar中的\n
                                selectIntNum = sc.next();
                                if(selectIntNum.equals("exit")) {
                                    break;
                                }

                                selectStr = sc.next();

                                int selectInt;

                                try {
                                    selectInt = Integer.parseInt(selectIntNum);
                                } catch (NumberFormatException e) {
                                    System.out.println("輸入錯了喔!\n請參照ex，先打裕選擇的道具在背包的第幾個，再打1個空格，再打執行的功能喔！");
                                    continue;
                                }

                                if (selectInt < 1 || selectInt > newPlayer.getBag().size()) {
                                    System.out.println("恭喜獲得隱藏版道具!\n...才怪沒有這個東西啦!\n快去重新輸入!");
                                    continue;
                                }

                                if(selectStr.equals("use")){
                                    boolean bo = newPlayer.use(selectInt);
                                    if(bo){
                                        System.out.println("成功使用");
                                        break;
                                    }
                                    if(!bo){
                                        System.out.println("此道具無法使用");
                                        break;
                                    }
                                }else if(selectStr.equals("status")){
                                    newPlayer.getBag().get(selectInt - 1).printItem();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("沒有這個功能啦!快回去重來!");
                    }
                    if(choose == 1){
                        break;
                    }
                }

                //Boss戰
                if (newPlayer.getPositon() == 5){
                    System.out.println("遇到Boss !");
                    Thread.sleep(1500);
                    Demon boss = new Demon();
                    boss.bahamut();
                    System.out.println("Boss是" + boss.ability.getName() + "!" );
                    Thread.sleep(1500);
                    fight.startFight(newPlayer, boss);

                    if(newPlayer.isDead()){

                        break;
                    }
                    kindCount++; //沒死＝勝利
                    kind = 1; //切換到另一張地圖
                    newPlayer.setPositon(0);//步數重算
                    if(kindCount == 1){
                        System.out.println("你已征服這個地圖");
                        Thread.sleep(1500);
                        System.out.println("你將前往森林!!!");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println();
                        System.out.println("你已進入地圖：森林~ 暗藏危險動物");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println();
                    }
                    break;
                }

                //事件
                int event = Random(0, 4);
//                event = sc.nextInt();// 測試用
                switch (event){
                    case 0://沒事發生
                        System.out.println();
                        System.out.println();
                        System.out.println("沒事發生，繼續走 ");
                        Thread.sleep(1500);
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;




                    case 1://遇到被動怪物 要先抓出怪物
//                        Animal animal = new Animal();
//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Demon demon = monster.genDemon();//隨機挑怪物
                        System.out.println("遇到 " + demon.ability.getName() + " 雙方大眼瞪小眼 你要逃跑嗎? ");
                        Thread.sleep(1500);
                        System.out.println("選擇1：逃跑\n" + "選擇2：戰鬥\n" + "選擇3：使用道具 ");
                        int choose = sc.nextInt();
                        switch (choose){
                            case 1:
                                System.out.println("你選擇逃跑");
                                if(fight.isEscaping(newPlayer, demon)){
                                    System.out.println("逃跑成功");
                                }else{
                                    System.out.println("逃跑失敗 開始戰鬥");
                                    fight.startFight(newPlayer, demon);
                                }
                                break;
                            case 2:
                                System.out.println("你選擇拼了");
                                fight.startFight(newPlayer, demon);
                                break;
                            case 3:
                                if(newPlayer.getBag().size() == 0){
                                    System.out.println("背包裡面空空如也");
                                    Thread.sleep(1500);
                                    System.out.println("還想用道具!? 認命戰鬥吧");
                                    Thread.sleep(1500);
                                    fight.startFight(newPlayer, demon);
                                    break;
                                }
                                System.out.println();
                                System.out.println();
                                newPlayer.supply();
                                System.out.println();
                                System.out.println("背包說明：");
                                System.out.println("1~" + newPlayer.getBag().size() +
                                        " status = 顯示道具功能 1~" +
                                        newPlayer.getBag().size());
                                System.out.println("1~" + newPlayer.getBag().size() +
                                        " use = 使用道具1~" +
                                        newPlayer.getBag().size());
                                System.out.println("輸入exit 來關閉背包");
                                System.out.println("(ex.裕顯示背包中第1個道具的功能，請打：1 status)");

                                String selectIntNum;
                                String selectStr;

                                while (true) {
                                    sc.nextLine();  // 先清除scannar中的\n
                                    selectIntNum = sc.next();
                                    if(selectIntNum.equals("exit")) {
                                        System.out.println("背包關上!");
                                        break;
                                    }

                                    selectStr = sc.next();

                                    int selectInt;
                                    System.out.println();

                                    try {
                                        selectInt = Integer.parseInt(selectIntNum);
                                    } catch (NumberFormatException e) {
                                        System.out.println("輸入錯了喔!\n請參照ex，先打裕選擇的道具在背包的第幾個，再打1個空格，再打執行的功能喔！");
                                        continue;
                                    }

                                    if (selectInt < 1 || selectInt > newPlayer.getBag().size()) {
                                        System.out.println("恭喜獲得隱藏版道具!\n...才怪沒有這個東西啦!\n快去重新輸入!");
                                        continue;
                                    }

                                    if(selectStr.equals("use")){
                                        boolean bo = newPlayer.use(selectInt);
                                        if(bo){
                                            System.out.println("成功使用");
                                            break;
                                        }
                                        if(!bo){
                                            System.out.println("此道具無法使用");
                                            break;
                                        }
                                    }else if(selectStr.equals("status")){
                                        newPlayer.getBag().get(selectInt - 1).printItem();
                                        break;
                                    }
                                }
                                System.out.println("還想用道具!? 認命戰鬥吧");
                                fight.startFight(newPlayer, demon);
                                break;
                        }
                        if(newPlayer.isDead()){

                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();
                        break;



                    case 2://遇到主動怪物

//                        animal = monster.getAnimals().get(Random(0, 3));//隨機挑怪物
                        Demon demon2 = monster.genDemon();//隨機挑怪物
                        System.out.println(demon2.ability.getName() + "主動攻擊你 逃不掉拉!");
                        Thread.sleep(1500);
                        System.out.println();
                        System.out.println("戰鬥開始");
                        fight.startFight(newPlayer, demon2);

                        if(newPlayer.isDead()){

                            break;
                        }
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();

                        break;

                    case 3: //遇到岔路
                        System.out.println();
                        System.out.println();
                        System.out.println("發現一個小叉路! 但看起來好恐怖 還是繼續往前吧 ");
                        Thread.sleep(1500);
                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();

                        break;

                    case 4://遇到寶箱
                        System.out.println();
                        System.out.println();
                        System.out.println("發現寶箱!!! ");
                        Thread.sleep(1500);
                        ArrayList<Item> treasureList2 = new ArrayList<Item>();
                        Item healingPotion = new Item();
                        healingPotion.healingPotion();
                        treasureList2.add(healingPotion);

                        Armor leatherArmor = new Armor();
                        leatherArmor.leatherArmor();
                        treasureList2.add(leatherArmor);

                        Item defenseIncreasePotion = new Item();
                        defenseIncreasePotion.defenceIncreasePotion();
                        treasureList2.add(defenseIncreasePotion);

                        newPlayer.getItem(treasureList2.get(Random(0, 2)));
                        Thread.sleep(1500);
                        System.out.println();

                        newPlayer.goOneStep();
                        System.out.println("你已經走了 " + newPlayer.getPositon() + " 步" );
                        System.out.println();

                        break;
                }
                if(newPlayer.isDead()){
                    break;
                }
            }

            if (kindCount == 2){
                break;
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("恭喜通關!!!你是真正的勇者");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
    }
    public static int Random (int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
    public static Weapon chooseWeapon(){
        //選擇起始武器（調用初始武器的ArrayList)
        Scanner sc = new Scanner(System.in);
        System.out.println("請選擇一個武器");
        ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
        Weapon w1 = new Weapon();
        w1.sword();
        System.out.print("選擇1 ");
        w1.printItem();
        weaponList.add(w1);

        Weapon w2 = new Weapon();
        w2.axe();
        System.out.print("選擇2 ");
        w2.printItem();
        weaponList.add(w2);

        Weapon w3 = new Weapon();
        w3.wand();
        System.out.print("選擇3 ");
        w3.printItem();
        weaponList.add(w3);

        System.out.print("選擇->");
        int chooseW;

        while (true) {
            try {
                chooseW = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("恭喜你獲得傳說之劍!\n...才怪沒有這個武器啦!快回去重選!");
                sc.next();
                continue;
            }

            if (0 < chooseW && chooseW < 4) {
                return weaponList.get(chooseW - 1);
            } else {
                System.out.println("恭喜你獲得傳說之劍!\n...才怪沒有這個武器啦!快回去重選!");
            }
        }

    } //選擇武器
    public static Armor chooseArmor(){
        //選擇起始防具（調用初始防具的ArrayList)
        Scanner sc = new Scanner(System.in);
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

        int chooseA;
        while (true) {
            try {
                chooseA = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("恭喜你獲得傳說之盾!\n...才怪沒有這個防具啦!快回去重選!");
                sc.next();
                continue;
            }
            if (0 < chooseA && chooseA < 4) {
                return armorList.get(chooseA - 1);
            } else {
                System.out.println("恭喜你獲得傳說之盾!\n...才怪沒有這個防具啦!快回去重選!");
            }
        }

    } //選擇防具
}