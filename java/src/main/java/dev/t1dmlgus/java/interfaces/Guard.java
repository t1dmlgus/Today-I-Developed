package dev.t1dmlgus.java.interfaces;

public class Guard {

    public void bark(Barkable animal) {
//        if (animal instanceof Tiger) {
//            System.out.println(" 어흥 ");
//        } else if (animal instanceof Lion) {
//            System.out.println(" 으르렁 ");
//        } else if (animal instanceof Crocodile) {
//            System.out.println(" 쩌억 ");
//        } else if (animal instanceof Rabbit) {
//            System.out.println(" 깡총 ");
//        }

        animal.bark();
    }
}
