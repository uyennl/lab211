package J1LP0023.control;

import J1LP0023.model.Fruit;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.fruits.add(new Fruit("1","tao",10,"VietNam",20));
        manager.fruits.add(new Fruit("2","dua",30,"VietNam",10));
        manager.fruits.add(new Fruit("3","xoai",20,"VietNam",7));
        manager.fruits.add(new Fruit("4","oi",12,"VietNam",17));
        manager.fruits.add(new Fruit("5","coc",15,"VietNam",30));
        manager.fruits.add(new Fruit("6","man",19,"VietNam",15));

manager.getMenu();
    }
}
