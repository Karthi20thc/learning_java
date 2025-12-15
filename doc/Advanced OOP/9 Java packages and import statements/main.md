```java
Folder resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\16 Source-code-OOP-Part-2-Polymorphism-Organizing-Java-Classes-Packages-and-Import-Statements\Packages\src
2 printable files
(file list disabled)

resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\16 Source-code-OOP-Part-2-Polymorphism-Organizing-Java-Classes-Packages-and-Import-Statements\Packages\src\com\abc\first\Item.java
1	package com.abc.first;
2	
3	public class Item {
4	
5	    private String type;
6	
7	    public Item(String type) {
8	        this.type = type;
9	    }
10	
11	    @Override
12	    public String toString() {
13	        return "Item{" +
14	                "type='" + type + '\'' +
15	                '}';
16	    }
17	}
18	 
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\16 Source-code-OOP-Part-2-Polymorphism-Organizing-Java-Classes-Packages-and-Import-Statements\Packages\src\dev\lpa\Main.java
1	package dev.lpa;
2	
3	import com.abc.first.*;
4	
5	public class Main {
6	
7	    public static void main(String[] args) {
8	
9	        Item firstItem = new com.abc.first.Item("Burger");
10	        System.out.println(firstItem);
11	    }
12	}
```

Great — this section introduces **Java packages and import statements**, which are essential for organizing large applications.
This example is simple, but it demonstrates the core idea perfectly.

Let’s walk through it step-by-step and explain everything clearly.

---

# 🎯 **What This Lesson Teaches**

### ✔ What a package is

### ✔ How to create packages (`com.abc.first`, `dev.lpa`)

### ✔ How to import classes from other packages

### ✔ How to reference classes with or without imports

### ✔ Why package organization matters

---

# 📦 PART 1 — Understanding the Package Structure

You have two packages (folders):

```
src/
 ├── com/
 │     └── abc/
 │            └── first/
 │                  └── Item.java
 └── dev/
       └── lpa/
             └── Main.java
```

This folder structure is **exactly how Java packages work**.

---

# 📦 PART 2 — Inside com.abc.first.Item

```java
package com.abc.first;

public class Item {

    private String type;

    public Item(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                '}';
    }
}
```

### Explanation:

1. `package com.abc.first;`
   → This class belongs to the package **com.abc.first**
   → Must be inside the folder: `com/abc/first`

2. The class is **public**, so it can be imported and used by classes in other packages.

3. `toString()` returns a nice string version of the object.

---

# 🧠 Why Use Packages?

Packages help you:

* Organize code into logical groups
* Avoid class name conflicts (e.g., different companies having “Item” class)
* Control access between classes
* Make large projects manageable

---

# 🧑‍💻 PART 3 — Understanding dev.lpa.Main

```java
package dev.lpa;

import com.abc.first.*;

public class Main {

    public static void main(String[] args) {

        Item firstItem = new com.abc.first.Item("Burger");
        System.out.println(firstItem);
    }
}
```

### Explanation:

### 1. `package dev.lpa;`

This class belongs to the **dev.lpa** package.

---

### 2. `import com.abc.first.*;`

This imports **all public classes** from `com.abc.first`.
So you can refer to `Item` directly.

Equivalent to:

```java
import com.abc.first.Item;
```

---

### 3. This line is important:

```java
Item firstItem = new com.abc.first.Item("Burger");
```

Two things happening:

#### ✔ The variable type is written simply:

```java
Item firstItem
```

Because we imported the package.

#### ✔ The constructor call uses the **full package path**

```java
new com.abc.first.Item("Burger")
```

Why?

To show that **you can reference a class with or without import**.

Equivalent version **without fully qualified name**:

```java
Item firstItem = new Item("Burger");
```

Because we imported:

```java
import com.abc.first.*;
```

So Java already knows that `Item` is from this package.

---

# 🧩 Why write full package name here?

This is intentional teaching:

✔ You can **use import**
✔ Or you can **use fully-qualified class name**

This:

```java
Item item = new Item(...);
```

means → imported

This:

```java
new com.abc.first.Item(...);
```

means → no import needed

---

# 🧪 Output

When printing:

```java
System.out.println(firstItem);
```

It calls:

```java
toString()
```

So output:

```
Item{type='Burger'}
```

---

# 📌 Summary Table

| Concept                        | Explanation                               |
| ------------------------------ | ----------------------------------------- |
| **package com.abc.first**      | Defines class location                    |
| **import com.abc.first.***     | Allows using Item without full path       |
| **Fully qualified name**       | com.abc.first.Item                        |
| **Package = folder structure** | com/abc/first                             |
| **Why use packages?**          | Organization, avoid conflicts, clean code |

---

# 🎓 Want the next step?

I can also explain:

✔ How access modifiers work with packages (`public`, `protected`, default)
✔ How to structure real-world applications using packages
✔ Difference between **import static**, **normal import**, and **fully-qualified names**

Just tell me!
