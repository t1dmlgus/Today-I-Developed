package dev.t1dmlgus.java.interfaces;

public class Crocodile extends Animal implements Predator, Barkable{
    @Override
    public String feed() {
        return "악어";
    }

    @Override
    public void bark() {
        System.out.println(" 쩌억 ");
    }
}
