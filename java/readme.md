# 인터페이스

여러클래스에 의존적이 아닌, 인터페이스를 통해 독립적으로 사용되기 때문에, 클래스 간 결합도를 낮출 수 있다.
<br>
그래서, 동일한 목적하에 객체에 같은 행동을 보장하기 위한 목적으로 사용됩니다.

- 인터페이스는 추상메서드와 상수 필드 만으로 구성된다.
- 추상메서드 - (abstract public 생략가능)
- 상수 - (public static final 생략가능)


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


# 추상클래스

실제 클래스의 공톡적인 부분(필드, 메서드)를 추출해서 선언한 클래스 <br>
따라서, 추상클래스를 상속받을 경우, **_공통부분을 재사용하며 필요한 기능들을 클래스 별로 재정의 하여 확장할 수 있다._** 



추상클래스는 일반클래스와 달리 단독으로 객체를 생성할 수 없다.

(중요) 추상메서드가 없어도 추상클래스 일 수 있다. 단, 추상클래스이기에 객체화 할 수 없다.



### 목적

추상 클래스를 상속받는 자식 클래스가 반드시 추상메소드를 재정의(오버라이딩) 하기 위함이다.
<br>
만약, 일반메소드로 구현한다면, 해당 메소드를 재정의(오버라이딩) 할 수도 있고 안할 수도 있다.

1. 공통된 필드와 메서드를 통일할 목적
    -> 필드와 메서드 이름을 통일하여, 구현클래스 입장에서 유지보수성을 높이고, 통일성을 유지할 수 있다. 

2. 추상클래스를 상속받으면, 주어진 필드와 메서드를 구현하여 활용할 수 있다.
3. 규격에 맞는 실체클래스 구현
   -> 

4. 추상클래스는 추상메서드를 재정의 함으로서, 상위클래스의 목적에 부합하는 구체적인 클래스를 구현할 수 있다.
5. 기능 재정의와 확장에 목적이 있습니다.



## 추상클래스 와 인터페이스 차이점
 

추상클래스는 extends 를 사용하여, 상위클래스의 특징을 재사용하거나 확장하는 목적으로 사용되며, 
<br>
인터페이스는 implements를 통해, 특정한 목적에 부합하는 인터페이스에 정의된 기능들을 강제하는 목적으로 사용됩니다.

따라서, 추상클래스와 인터페이스는 사용목적에 있어서 차이점이 있습니다.






