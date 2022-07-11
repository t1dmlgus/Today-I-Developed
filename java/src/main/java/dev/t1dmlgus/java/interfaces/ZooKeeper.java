package dev.t1dmlgus.java.interfaces;

public class ZooKeeper {


    // 메소드 오버로딩
//    void feed(Tiger tiger) {
//        System.out.println(" 호랑이 한테 먹이를준다. ");
//    }
//    void feed(Lion lion) {
//        System.out.println(" 사자 한테 먹이를준다. ");
//    }
//
//    void feed(Crocodile crocodile) {
//        System.out.println(" 악어 한테 먹이를준다. ");
//    }
//
//    void feed(Rabbit rabbit) {
//        System.out.println(" 토끼 한테 먹이를준다. ");
//    }

    void feed(Predator predator) {
        System.out.println(predator.feed() +" 한테 먹이를 준다.");

    }
}
