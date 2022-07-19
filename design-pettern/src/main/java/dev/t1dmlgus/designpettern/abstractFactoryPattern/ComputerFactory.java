package dev.t1dmlgus.designpettern.abstractFactoryPattern;


// 팩토리 메서드 패턴
public class ComputerFactory {

    public static Computer of(ComputerAbstractFactory factory) {

//        if ("PC".equalsIgnoreCase(type)) {
//            return new PC(ram, hdd, cpu);
//        } else if ("Server".equalsIgnoreCase(type)) {
//            return new Server(ram, hdd, cpu);
//        }

        return factory.createComputer();
    }


}
