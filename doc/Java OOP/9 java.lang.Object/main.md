Great — this small example teaches **four major Java OOP concepts** in a very clear way:

# ⭐ Inheritance

# ⭐ Method overriding

# ⭐ Calling `super.toString()`

# ⭐ Why every class extends `Object`

Let’s explain everything step-by-step.

---

# 🔵 **1. `Main extends Object` — Why is this here?**

```java
public class Main extends Object {
```

This is actually **not needed**, because:

👉 In Java, **every class automatically extends `Object`** even if you don’t write it.

So these two are the same:

```java
public class Main { }
public class Main extends Object { }
```

### ✔ `Object` is the top-most parent of ALL classes in Java.

It provides:

* `toString()`
* `equals()`
* `hashCode()`
* `getClass()`

That’s why every class has these methods available.

---

# 🟦 **2. The Student class**

```java
class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " is " + age;
    }
}
```

### This class is a **POJO**:

✔ private fields
✔ constructor
✔ overridden toString()

### Key concept:

### ✔ Overriding `toString()`

Default `toString()` from `Object` returns:

```
Student@37d31475
```

Because you override it:

```java
return name + " is " + age;
```

Now printing a Student object becomes readable:

```
Max is 21
```

---

# 🟩 **3. Inheritance: PrimarySchoolStudent extends Student**

```java
class PrimarySchoolStudent extends Student {
```

This means:

* it **inherits name & age**
* it inherits Student's constructor (via `super`)
* it **adds a new field** `parentName`

---

# 🔵 **4. Constructor in PrimarySchoolStudent**

```java
PrimarySchoolStudent(String name, int age, String parentName) {
    super(name, age);
    this.parentName = parentName;
}
```

### ✔ `super(name, age)` calls Student constructor

This sets:

* `name`
* `age`

Then child class sets:

* `parentName`

This shows how child classes build on top of parent classes.

---

# 🟣 **5. Overriding toString() in PrimarySchoolStudent**

```java
@Override
public String toString() {
    return parentName + "'s kid, " + super.toString();
}
```

This is very important. It combines:

### ✔ Child-specific info (`parentName`)

### ✔ Parent's `toString()` output

Example:

```
super.toString() → "Jimmy is 8"
parentName = "Carole"
```

Final output:

```
Carole's kid, Jimmy is 8
```

This shows **method overriding + super method call**.

---

# 🔥 **6. Polymorphism in action**

Even though both objects are different classes:

```java
Student max = new Student("Max", 21);
PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 8, "Carole");
```

Both can call `.toString()` and print meaningful output.

This is **polymorphism** — different classes providing different behavior for the same method name.

---

# 🧠 **7. What the code teaches you**

| Concept                    | Explanation                             |
| -------------------------- | --------------------------------------- |
| **Inheritance**            | PrimarySchoolStudent extends Student    |
| **Constructor chaining**   | `super(name, age)`                      |
| **Method overriding**      | Both override `toString()`              |
| **super.toString()**       | Child uses parent’s behavior            |
| **Object class hierarchy** | All classes automatically extend Object |
| **Encapsulation**          | fields are private                      |
| **Polymorphism**           | same method → different output          |

---

# 🎯 **8. Why override `toString()`?**

Because printing a class should show **useful information**:

```java
System.out.println(max);
```

becomes:

```
Max is 21
```

instead of:

```
Student@1b6d3586
```

---

# 🟢 Final Output (so you see how everything connects)

```
Max is 21
Carole's kid, Jimmy is 8
```

The second line is more complex because:

* Child class adds `parentName`
* Calls parent class's `toString()`
* Combines both in the final string

---

# If you like, I can also explain:

✔ why we don’t use `public` constructors here
✔ difference between overriding vs overloading
✔ how memory works with inheritance
✔ what happens step-by-step when `new PrimarySchoolStudent()` runs

Just tell me!
