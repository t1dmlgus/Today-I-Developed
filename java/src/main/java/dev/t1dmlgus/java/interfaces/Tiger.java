package dev.t1dmlgus.java.interfaces;

public class Tiger extends Animal implements Predator, Barkable{
    @Override
    public String feed() {
        return "호랑이";
    }

    @Override
    public void bark() {
        System.out.println(" 어흥 ");
    }
}
