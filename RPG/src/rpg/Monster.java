package rpg;

import java.util.ArrayList;

public class Monster extends Character {
    private ArrayList<Animal> animals = new ArrayList<Animal>();  // 動物清單
    private ArrayList<Demon> demons = new ArrayList<Demon>();  // 魔物清單
    protected ArrayList<Item[]> animalDropItemList = new ArrayList<Item[]>();  // 動物掉落物清單
    protected ArrayList<Item[]> demonDropItemList = new ArrayList<Item[]>();  // 魔物掉落物清單

    public Monster() {
        setAnimals();  // 設定動物清單
        setDemons();  //設定魔物清單
    }

    private void setAnimals() {
        Animal wolf = new Animal();
        Animal lion  = new Animal();
        Animal boar = new Animal();
        Animal elephant = new Animal();
        wolf.wolf();
        animals.add(wolf);
        lion.lion();
        animals.add(lion);
        boar.boar();
        animals.add(boar);
        elephant.elephant();
        animals.add(elephant);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }  // 取得動物清單

    private void setDemons() {
        Demon demonWolf = new Demon();
        Demon celestialHuang = new Demon();
        Demon mountainDemon = new Demon();
        Demon bahamut = new Demon();
        demonWolf.demonWolf();
        demons.add(demonWolf);
        celestialHuang.celestialHuang();
        demons.add(celestialHuang);
        mountainDemon.mountainDemon();
        demons.add(mountainDemon);
        bahamut.bahamut();
        demons.add(bahamut);
    }

    public ArrayList<Demon> getDemons() {
        return demons;
    }  // 取得魔物清單

    public ArrayList<Item[]> getAnimalDropItemList() {
        return animalDropItemList;
    }  // 取得動物掉落物清單

    public ArrayList<Item[]> getDemonDropItemList() {
        return demonDropItemList;
    }  // 取得魔物掉落物清單
}
