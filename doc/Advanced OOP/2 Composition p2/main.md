Great! This version of the Computer Factory project introduces **encapsulation** and **composition** more strongly.
Let’s walk through the code step-by-step so you understand exactly what it is doing and why.

---

# 🚀 **WHAT THIS VERSION ADDS (Compared to Part-1)**

### ✔ A new method in `PersonalComputer`: `powerUp()`

### ✔ A private helper method: `drawLogo()`

### ✔ Direct access to components removed (no getters)

### ✔ PC controls its parts internally → **better encapsulation**

This is more realistic:
A real user does **not** access the motherboard or monitor directly — the computer does that internally.

---

# 🧱 1. MAIN METHOD — BUILDING A PC

```java
ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540 x 1440");
Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

PersonalComputer thePC = new PersonalComputer("2208", "Dell",
        theCase, theMonitor, theMotherboard);
```

### ✔ You are assembling a computer:

* Dell case
* Acer monitor
* Asus motherboard

This shows **composition**:

A PC **has-a** Case
A PC **has-a** Monitor
A PC **has-a** Motherboard

---

# 🟡 2. Commented old approach (direct access)

```java
// thePC.getMonitor().drawPixelAt(...)
// thePC.getMotherboard().loadProgram(...)
// thePC.getComputerCase().pressPowerButton();
```

In previous code, the PC exposed all its internal parts.
This breaks encapsulation.

Now, those getters are **removed**, meaning the PC has more control over its internal components.

---

# 🟢 3. NEW METHOD: `powerUp()`

```java
thePC.powerUp();
```

Inside `PersonalComputer`, this method is defined as:

```java
public void powerUp() {
    computerCase.pressPowerButton();
    drawLogo();
}
```

### ✔ What happens when powerUp() is called?

1. The computer presses its own power button
   Output:

   ```
   Power button pressed
   ```
2. It shows a startup logo
   (by drawing a yellow pixel on monitor)

---

# 🎨 4. PRIVATE METHOD: `drawLogo()`

```java
private void drawLogo() {
    monitor.drawPixelAt(1200, 50, "yellow");
}
```

### ✔ Why is it **private**?

* Because only the PC’s internal system should draw its startup logo
* Outsiders (users) should not call it

This is **encapsulation** done properly.

---

# 🔐 5. Getters removed

```java
// public ComputerCase getComputerCase() { ... }
// public Monitor getMonitor() { ... }
// public Motherboard getMotherboard() { ... }
```

These are commented out.

### ✔ Why?

Because external code should NOT reach inside the PC and directly manipulate its parts.

Imagine in real life:
You don’t press a motherboard button or draw pixels directly on the monitor.
You interact with the **computer**, and the computer interacts with its components.

This is **proper encapsulation**.

---

# ⚙️ 6. HOW COMPONENTS WORK INTERNALLY

## Monitor

```java
monitor.drawPixelAt(1200, 50, "yellow");
```

Simulates drawing a pixel → used for logo.

---

## Motherboard

```java
loadProgram("Windows OS");
```

(Not used here but available for future behavior.)

---

## ComputerCase

```java
pressPowerButton();
```

Called inside `powerUp()`.

---

# 💡 WHY THIS DESIGN IS BETTER?

### ✔ Main code is simpler

You just call:

```java
thePC.powerUp();
```

Everything else happens inside PC.

### ✔ Better abstraction

Users don’t handle motherboard directly.

### ✔ Better encapsulation

Internal details are hidden via private fields and private methods.

### ✔ Cleaner architecture (real-world-like)

This models how actual computers behave.

---

# OUTPUT OF `powerUp()`

When you run:

```java
thePC.powerUp();
```

You will see:

```
Power button pressed
Drawing pixel at 1200,50 in color yellow
```

---

# 🎯 SUMMARY

| Concept                 | How it appears here                                 |
| ----------------------- | --------------------------------------------------- |
| **Composition (HAS-A)** | PC has a Case, Monitor, Motherboard                 |
| **Encapsulation**       | PC hides its parts, no public getters               |
| **Private methods**     | `drawLogo()` only used inside `powerUp()`           |
| **Abstraction**         | User calls `powerUp()` instead of calling each part |
| **Realistic modeling**  | A PC controls its own boot sequence                 |

---

# 🚀 WANT NEXT STEP?

I can help you:

✔ Add a `shutDown()` method
✔ Add BIOS boot animation
✔ Create an interface for components (polymorphism)
✔ Explain how polymorphism fits into this project

Just tell me!
