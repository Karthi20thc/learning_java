Sure! Let’s break down this Java code **step by step in a simple, beginner-friendly way**, so you understand **what each part does** and **why it is written that way**.

---

# ✅ **WHAT THIS PROGRAM DOES**

Your program demonstrates:

### ✔️ How to inspect a string

### ✔️ How to check if a string is empty or blank

### ✔️ How to find characters inside a string

### ✔️ How to compare strings

### ✔️ How to check prefixes, suffixes, and substring existence

### ✔️ How to print first and last character safely

---

# 📌 **1. `printInformation("Hello World")`**

This method receives a **String** and prints useful information.

### 🔍 **Inside `printInformation` method:**

```java
int length = string.length();
System.out.printf("Length = %d %n", length);
```

➡️ Prints how many characters the string has.

---

### 🔍 **Check if the string is empty**

```java
if (string.isEmpty()) {
    System.out.println("String is Empty");
    return;
}
```

* `.isEmpty()` → true when length == 0
  Example: `""` (empty string)

If string is empty → return (stop method), because there is nothing more to print.

---

### 🔍 **Check if the string is blank**

```java
if (string.isBlank()) {
    System.out.println("String is Blank");
}
```

* `.isBlank()` → true if string contains only whitespace
  Example: `"   "` or `"\n\t"`

➡️ A blank string is NOT empty but contains only spaces/tabs/newlines.

---

### 🔍 Print first and last character

```java
System.out.printf("First char = %c %n", string.charAt(0));
System.out.printf("Last char = %c %n", string.charAt(length - 1));
```

➡️ Print the first and last characters using `charAt`.

---

# 📌 **2. INDEX METHODS**

You explore how to find characters inside a string.

Given:

```java
String helloWorld = "Hello World";
```

### 🔍 Find position of a character:

```java
helloWorld.indexOf('r')
```

➡️ Finds the index of **first occurrence** of `'r'`.

---

### 🔍 Find position of a substring:

```java
helloWorld.indexOf("World")
```

➡️ Finds the starting index of `"World"`.

---

### 🔍 Find position of `'l'`

```java
helloWorld.indexOf('l')
helloWorld.lastIndexOf('l')
```

* `indexOf` → first `'l'`
* `lastIndexOf` → last `'l'`

---

### 🔍 Find `'l'` from a specific index

```java
helloWorld.indexOf('l', 3)
helloWorld.lastIndexOf('l', 8)
```

➡️ Search starting from a given position.

---

# 📌 **3. STRING COMPARISON**

### 🔍 Convert to lowercase

```java
String helloWorldLower = helloWorld.toLowerCase();
```

Now compare them:

### ✔️ Case-sensitive comparison

```java
if (helloWorld.equals(helloWorldLower))
```

➡️ Will be **false** because `"Hello World"` ≠ `"hello world"`.

---

### ✔️ Case-insensitive comparison

```java
if (helloWorld.equalsIgnoreCase(helloWorldLower))
```

➡️ Will be **true** because they contain same letters ignoring case.

---

# 📌 **4. CHECKING START / END / CONTAINS**

### Starts with?

```java
helloWorld.startsWith("Hello")
```

➡️ True — it begins with "Hello".

---

### Ends with?

```java
helloWorld.endsWith("World")
```

➡️ True — ends in "World".

---

### Contains substring?

```java
helloWorld.contains("World")
```

➡️ True — "World" is inside the string.

---

# 📌 **5. EXACT MATCH USING `contentEquals()`**

```java
if (helloWorld.contentEquals("Hello World")) {
    System.out.println("Values match exactly");
}
```

➡️ Works like `equals()`, but accepts a `CharSequence`.

---

# 🎯 Summary (Easy to Remember)

| Feature                     | Method                             |
| --------------------------- | ---------------------------------- |
| Length                      | `length()`                         |
| Empty string?               | `isEmpty()`                        |
| Blank string? (spaces only) | `isBlank()`                        |
| First & last char           | `charAt(0)` and `charAt(length-1)` |
| Find char                   | `indexOf('x')`                     |
| Find substring              | `indexOf("text")`                  |
| Last occurrence             | `lastIndexOf()`                    |
| Compare case-sensitive      | `equals()`                         |
| Compare ignoring case       | `equalsIgnoreCase()`               |
| Starts with text?           | `startsWith()`                     |
| Ends with text?             | `endsWith()`                       |
| Contains text?              | `contains()`                       |

---

# 🚀 Want me to rewrite this code in a simpler style?

Or explain each output line that will appear when the program runs?

Just tell me!
