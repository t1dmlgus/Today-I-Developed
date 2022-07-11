package dev.t1dmlgus.java.interfaces;

public class Main {

    public static void main(String[] args) {


        ZooKeeper zooKeeper = new ZooKeeper();

        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Crocodile crocodile = new Crocodile();
        Rabbit rabbit = new Rabbit();

        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
        zooKeeper.feed(crocodile);
//        zooKeeper.feed(rabbit);


        System.out.println(" ============================ " );

        Guard guard = new Guard();
        guard.bark(tiger);
        guard.bark(lion);
        guard.bark(crocodile);
        guard.bark(rabbit);


    }
}
