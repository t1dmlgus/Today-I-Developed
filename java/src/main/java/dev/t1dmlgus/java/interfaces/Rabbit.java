package dev.t1dmlgus.java.interfaces;

public class Rabbit extends Animal implements Barkable{
    @Override
    public void bark() {
        System.out.println(" 깡총 ");
    }
}
