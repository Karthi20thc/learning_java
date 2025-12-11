Here is a **clear and beginner-friendly explanation** of what changed in this version of the code and what new OOP concepts you are supposed to learn.

---

# ✅ **1. This Version Introduces SETTERS**

In the previous example, the fields were **private**, and you only had getters.

Now you also have **setter** methods to modify those private fields.

Example:

```java
car.setMake("Porsche");
car.setModel("Carrera");
car.setDoors(2);
car.setConvertible(true);
car.setColor("black");
```

This is how you update private fields in an object.

---

# ✅ **2. Why Do We Use SETTERS? (Important OOP concept)**

Because fields are **private** (encapsulation), you must use setter methods to safely change values.

Setters allow:

* **validation**
* **restrictions**
* **computed logic**

---

# ⭐ **3. The Most Important Part: `setMake()`**

This method now includes **validation logic** using:

* null check
* conversion to lowercase
* a `switch` expression (Java 14+)

### Code:

```java
public void setMake(String make) {

    if (make == null) make = "Unknown";
    String lowercaseMake = make.toLowerCase();

    switch (lowercaseMake) {
        case "holden", "porsche", "tesla" -> this.make = make;
        default -> {
            this.make = "Unsupported ";
        }
    }
}
```

### ✔ Step-by-step explanation:

1️⃣ **Check for null**
If user passes null:

```java
car.setMake(null);
```

Then we automatically change it:

```java
make = "Unknown";
```

---

2️⃣ **Convert to lowercase**

```java
String lowercaseMake = make.toLowerCase();
```

This ensures `"Porsche"`, `"porsche"`, `"PORSCHE"` are treated the same.

---

3️⃣ **Only allow certain car makes**

Allowed:

* holden
* porsche
* tesla

If input matches one of these, update `this.make`.

Else:

```java
this.make = "Unsupported";
```

So:

```java
car.setMake("BMW");
```

→ make becomes `"Unsupported"`

---

# 🟢 **4. Other Setters Are Simple**

### No validation yet:

```java
public void setModel(String model) { this.model = model; }
public void setColor(String color) { this.color = color; }
public void setDoors(int doors) { this.doors = doors; }
public void setConvertible(boolean convertible) { this.convertible = convertible; }
```

These simply update values.

Later you may add rules like:

* doors must be 2 or 4
* color cannot be empty
* model must match brand, etc.

---

# 🟣 **5. describeCar() Works Same as Before**

```java
System.out.println(doors + "-Door " +
        color + " " +
        make + " " +
        model + " " +
        (convertible ? "Convertible" : ""));
```

---

# 🟠 **6. Main Creates Two Cars**

### 🚗 Car 1 → "car"

```
Porsche Carrera (2-door convertible black)
```

### 🚗 Car 2 → "targa"

```
Porsche Targa (2-door NOT convertible, red)
```

Two different objects created from the same class.

This teaches:

### ✔ Object creation

### ✔ Updating fields via setters

### ✔ Each object has its own data

---

# 🎯 What YOU Are Learning in This Lesson

| Concept                       | Explanation                                |
| ----------------------------- | ------------------------------------------ |
| **Encapsulation**             | Using private fields + getters + setters   |
| **Object creation**           | `Car car = new Car();`                     |
| **Validation inside setters** | e.g., `setMake()` restricts allowed values |
| **Switch expressions**        | Shorter syntax introduced in newer Java    |
| **Multiple objects**          | `car` and `targa` are independent          |

---

# 👍 If You Want, I Can Teach You the Next Topics:

* How to create constructors
* How to use inheritance (`ElectricCar extends Car`)
* How to override methods (`@Override`)
* How to build a real small OOP project

Just tell me:
**"Explain constructors"** or
**"Explain inheritance next"**
