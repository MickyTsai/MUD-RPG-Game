package rpg;

import java.util.ArrayList;

public class Monster extends Character {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Demon> demons = new ArrayList<Demon>();
    protected ArrayList<Item> dropItemList = new ArrayList<Item>();  // 掉落物清單
    protected Item dropItem = new Item();  // 用來new出新掉落物

    public Monster() {
        setAnimals();  // 設定動物清單
        setDemons();  //設定魔物清單
    }

    private void setAnimals() {
        Animal animal = new Animal();
        animal.wolf();
        animals.add(animal);
        animal.lion();
        animals.add(animal);
        animal.boar();
        animals.add(animal);
        animal.elephant();
        animals.add(animal);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    private void setDemons() {
        Demon demon = new Demon();
        demon.demonWolf();
        demons.add(demon);
        demon.celestialHuang();
        demons.add(demon);
        demon.mountainDemon();
        demons.add(demon);
        demon.bahamut();
        demons.add(demon);
    }

    public ArrayList<Demon> getDemons() {
        return demons;
    }

    public ArrayList<Item> getDropItemList() {
        return dropItemList;
    }
}
