package dev.t1dmlgus.designpettern.factoryPattern;


// 팩토리 메서드 패턴
public class ComputerFactory {

    public static Computer of(String type, String ram, String hdd, String cpu) {

        if ("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("Server".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }

        return null;
    }


}
