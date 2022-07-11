package dev.t1dmlgus.java.abstracts;

public abstract class Predator extends Animal{

    static int COUNT = 4;   // 추상클래스 상수는 static 선언이 필요하다(명시적)

    abstract String getFood();



}
