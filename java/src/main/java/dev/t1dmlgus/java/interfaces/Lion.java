package dev.t1dmlgus.java.interfaces;

public class Lion extends Animal implements Predator, Barkable{

    @Override
    public String feed() {
        return "사자";
    }

    @Override
    public void bark() {
        System.out.println(" 으르렁 ");
    }
}
