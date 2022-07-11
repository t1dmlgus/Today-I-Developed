# 인터페이스

## 메소드 오버로딩

``` java
    void feed(Tiger tiger) {
        System.out.println(" 호랑이 한테 먹이를준다. ");
    }
    void feed(Lion lion) {
        System.out.println(" 사자 한테 먹이를준다. ");
    }

    void feed(Crocodile crocodile) {
        System.out.println(" 악어 한테 먹이를준다. ");
    }

    void feed(Rabbit rabbit) {
        System.out.println(" 토끼 한테 먹이를준다. ");
    }
```

## 다형성(Polymorphism)

객체가 한 개 이상(여러개)의 자료형 타입을 갖게되는 특성을 다형성이라고 한다.

- tiger - Tiger 클래스의 객체, Predator 인터페이스의 객체
- lion - Lion 클래스의 객체, Predator 인터페이스의 객체


### IS - A 관계

자식클래스에 의해 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수 있다.

``` java
Animal tiger = new Tiger(); // Tiger is a Animal
Animal lion = new Lion(); // Tiger is a Animal

```

동물이 추가 될때마다 코드(분기문)이 추가되어야 한다.

``` java
public void bark(Animal animal) {
    if (animal instanceof Tiger) {
        System.out.println(" 어흥 ");
    } else if (animal instanceof Lion) {
        System.out.println(" 으르렁 ");
    } else if (animal instanceof Crocodile) {
        System.out.println(" 쩌억 ");
    } else if (animal instanceof Rabbit) {
        System.out.println(" 깡총 ");
    }
}
```

위 코드를 인터페이스로 구현해보자!

```java
    public void bark(Barkable animal) {
        animal.bark();
    }
```

<br>
<br>

따라서, Tiger 클래스는 다음과 같이 **_여러가지 자료형_** 으로 표현될 수 있다.

```java

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
```

```java
Tiger tiger = new Tiger(); // Tiger is a Tiger
Animal animal = new Tiger(); // Tiger is a Animal
Predator Predator = new Tiger(); // Tiger is a Predator
Barkable barkable = new Tiger(); // Tiger is a Barkable

```

또한, 인터페이스는 다중상속이 가능하며, 일반클래스는 단일상속만 가능하다.




## 핵심

인터페이스를 통해, 동물 종류에 의존적인 클래스에서 <br> -> **_독립적인 클래스_** 가 되었다.

## 상속과 인터페이스

상속도 마찬가지로 상위클래스 자료형으로 동일하게 독립적으로 사용될 수 있다.
하지만, 상속은 자식클래스가 부모클래스의 메소드를 오버라이딩하지 않고 사용할 수 있기 때문에 **_강제성_** 이 없다.
<br>
따라서, 상황에 맞게 상속을 사용할지, 인터페이스를 사용할지 결정해야하며 **_인터페이스는 메소드를 반드시 구현해야 하는 강제성_** 을 갖는다.




