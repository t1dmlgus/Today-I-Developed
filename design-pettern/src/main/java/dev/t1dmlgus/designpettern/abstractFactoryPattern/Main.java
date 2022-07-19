package dev.t1dmlgus.designpettern.abstractFactoryPattern;

public class Main {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.of(new PcFactory("2", "3","6:"));

        System.out.println("pc = " + pc);
    }
}
