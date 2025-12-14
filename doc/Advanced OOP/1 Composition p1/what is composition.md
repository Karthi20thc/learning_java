**Composition in OOP** is a design principle where **one class is made up of other classes** — meaning **an object contains another object** and **controls its lifetime**.

In simple words:
👉 **“Has-a” relationship with strong ownership**

---

## Simple Definition

> **Composition** means creating complex objects by **combining simpler objects**, where the contained object **cannot exist independently** of the container.

---

## Real-World Example

### 🏠 House and Rooms

* A **House has Rooms**
* If the house is destroyed, the rooms are gone too

This is **composition**, not inheritance.

---

## Java Example (Basic)

```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;  // Car HAS an Engine

    Car() {
        this.engine = new Engine(); // created inside Car
    }

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
```

### Key Point

* `Car` **owns** `Engine`
* `Engine` is created **inside** `Car`
* `Engine` cannot exist without `Car`

---

## Why Composition Is Important

✅ Better **flexibility**
✅ Avoids tight coupling of inheritance
✅ Follows **“favor composition over inheritance”** principle
✅ Easier to change behavior

---

## Composition vs Inheritance

| Feature          | Composition | Inheritance |
| ---------------- | ----------- | ----------- |
| Relationship     | Has-a       | Is-a        |
| Flexibility      | High        | Low         |
| Coupling         | Loose       | Tight       |
| Runtime behavior | Can change  | Fixed       |
| Reusability      | Better      | Limited     |

---

## Composition vs Aggregation (Important!)

| Aspect          | Composition  | Aggregation   |
| --------------- | ------------ | ------------- |
| Ownership       | Strong       | Weak          |
| Object lifetime | Dependent    | Independent   |
| Example         | Car → Engine | Team → Player |

---

## Example Showing Composition Clearly

```java
class Heart {
    void beat() {
        System.out.println("Heart beating");
    }
}

class Human {
    private Heart heart = new Heart(); // composition

    void live() {
        heart.beat();
        System.out.println("Human is alive");
    }
}
```

💀 If `Human` dies → `Heart` dies
👉 **Pure composition**

---

## In Spring / Real Projects

You already use composition a lot:

```java
@Service
class OrderService {
    private final PaymentService paymentService;

    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

* `OrderService` **has** `PaymentService`
* This is **composition via dependency injection**

---

## One-Line Summary

> **Composition = building classes by including other classes, instead of inheriting from them**

---

If you want, I can also explain:

* Composition vs Aggregation with **UML**
* When to choose **inheritance vs composition**
* Composition in **Spring Boot / real microservices**
* MCQs (useful for interviews & exams)

Just tell me 👍
