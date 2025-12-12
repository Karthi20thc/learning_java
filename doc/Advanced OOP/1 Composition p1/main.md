Great! This project is a **classic example of OOP concepts**:

### ✔ Composition

### ✔ Inheritance

### ✔ Encapsulation

### ✔ Polymorphism (will be used later)

Let me explain everything **clearly and simply** so you fully understand how this code works and why it is written this way.

---

# 🎯 **WHAT THIS PROJECT MODELS**

It models a **computer** made of different components:

* A **ComputerCase**
* A **Monitor**
* A **Motherboard**

All these components are **Products** (base class).

Then, the **PersonalComputer** class combines these parts → this is **composition**.

---

# 🧱 1. PRODUCT CLASS (BASE CLASS)

```java
public class Product {

    private String model;
    private String manufacturer;
    private int width;
    private int height;
    private int depth;

    public Product(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
```

### ✔ What this represents:

A **generic product** with common fields:

* `model`
* `manufacturer`
* (dimensions fields are unused but show potential future use)

### ✔ Why it exists:

So **Monitor**, **Motherboard**, and **ComputerCase** can *extend* this class and reuse this code.

This is **inheritance**.

---

# 🖥️ 2. MONITOR CLASS

```java
class Monitor extends Product {

    private int size;
    private String resolution;

    public Monitor(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public Monitor(String model, String manufacturer, int size, String resolution) {
        super(model, manufacturer);
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println(String.format(
                "Drawing pixel at %d,%d in color %s ", x, y, color));
    }
}
```

### ✔ Inherits from Product

Uses `super(model, manufacturer)` to call the parent constructor.

### ✔ Additional features of Monitor:

* `size`
* `resolution`
* `drawPixelAt()` → simulates drawing on screen
  (Useful for composition later)

---

# 💻 3. MOTHERBOARD CLASS

```java
class Motherboard extends Product {

    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots,
                       String bios) {
        super(model, manufacturer);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }
}
```

### ✔ Specialized fields:

* RAM slots
* Card slots
* BIOS version

### ✔ Special behavior:

`loadProgram()` — simulates a motherboard running a program.

---

# ⚙️ 4. COMPUTER CASE CLASS

```java
class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public ComputerCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }
}
```

### ✔ Specialized field:

* Power supply type

### ✔ Behavior:

* `pressPowerButton()` prints when the power button is pressed

---

# 🧩 5. PERSONAL COMPUTER (COMPOSITION)

```java
public class PersonalComputer extends Product {

    private ComputerCase computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(String model, String manufacturer,
                            ComputerCase computerCase, Monitor monitor,
                            Motherboard motherboard) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public ComputerCase getComputerCase() { return computerCase; }
    public Monitor getMonitor() { return monitor; }
    public Motherboard getMotherboard() { return motherboard; }
}
```

### ✔ PersonalComputer extends Product

It is also a product with:

* model
* manufacturer

### ✔ PersonalComputer **contains**:

* a case
* a monitor
* a motherboard

This is **composition** (HAS-A relationship):

* A PC **has a** Monitor
* A PC **has a** Motherboard
* A PC **has a** Case

### ✔ Getter methods allow accessing the components.

---

# 🧠 **KEY OOP CONCEPTS IN THIS CODE**

## 🔹 1. Inheritance (IS-A relationship)

* `Monitor` **is a** Product
* `Motherboard` **is a** Product
* `ComputerCase` **is a** Product
* `PersonalComputer` **is a** Product

They share fields like:

* model
* manufacturer

---

## 🔹 2. Composition (HAS-A relationship)

`PersonalComputer` **HAS**:

* a Monitor
* a ComputerCase
* a Motherboard

This is how real systems are designed.

---

## 🔹 3. Encapsulation

Fields like `model`, `manufacturer`, `size`, etc. are private → they cannot be accessed directly.

Instead, constructors or getters control access.

---

# ✔ Example of using this code in Main

You can create a working PC like this:

```java
public static void main(String[] args) {

    Monitor monitor = new Monitor("27inch UltraSharp", "Dell", 27, "2560x1440");
    Motherboard motherboard = new Motherboard("B550", "MSI", 4, 3, "v2.1.0");
    ComputerCase pcCase = new ComputerCase("H510", "NZXT", "650W PSU");

    PersonalComputer myPc = new PersonalComputer(
            "Custom Build", "Karthik",
            pcCase, monitor, motherboard
    );

    myPc.getComputerCase().pressPowerButton();
    myPc.getMotherboard().loadProgram("Windows");
    myPc.getMonitor().drawPixelAt(1200, 800, "blue");
}
```

Would output:

```
Power button pressed
Program Windows is now loading...
Drawing pixel at 1200,800 in color blue
```

---

# 🎯 Summary (Easy to Remember)

| Class            | Type            | Role                                     |
| ---------------- | --------------- | ---------------------------------------- |
| Product          | Parent class    | Common fields for all components         |
| Monitor          | extends Product | Has size, resolution, can draw pixels    |
| Motherboard      | extends Product | Can load programs                        |
| ComputerCase     | extends Product | Has power supply, can press power button |
| PersonalComputer | extends Product | **HAS** monitor, case, motherboard       |

---

# 🚀 Want me to explain polymorphism or help you add behavior to PersonalComputer (like turnOn(), drawLogo(), boot())?
