```java
Folder resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\9 Source-code-OOP-Part-2-Polymorphism-Casting-with-classes-and-using-Object-and-var-references\Polymorphism\src
3 printable files
(file list disabled)

resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\9 Source-code-OOP-Part-2-Polymorphism-Casting-with-classes-and-using-Object-and-var-references\Polymorphism\src\Main.java
1	import java.util.Scanner;
2	
3	public class Main {
4	
5	    public static void main(String[] args) {
6	
7	//        Movie theMovie = Movie.getMovie("Science", "Star Wars");
8	//        theMovie.watchMovie();
9	
10	        Scanner s = new Scanner(System.in);
11	        while (true) {
12	            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
13	                    "S for Science Fiction, or Q to quit): ");
14	            String type = s.nextLine();
15	            if ("Qq".contains(type)) {
16	                break;
17	            }
18	            System.out.print("Enter Movie Title: ");
19	            String title = s.nextLine();
20	            Movie movie = Movie.getMovie(type, title);
21	            movie.watchMovie();
22	        }
23	    }
24	}
25	 
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\9 Source-code-OOP-Part-2-Polymorphism-Casting-with-classes-and-using-Object-and-var-references\Polymorphism\src\Movie.java
1	public class Movie {
2	
3	    private String title;
4	
5	    public Movie(String title) {
6	        this.title = title;
7	    }
8	
9	    public void watchMovie() {
10	
11	        String instanceType = this.getClass().getSimpleName();
12	        System.out.println(title + " is a " + instanceType + " film");
13	    }
14	
15	    public static Movie getMovie(String type, String title) {
16	
17	        return switch (type.toUpperCase().charAt(0)) {
18	            case 'A' -> new Adventure(title);
19	            case 'C' -> new Comedy(title);
20	            case 'S' -> new ScienceFiction(title);
21	            default -> new Movie(title);
22	        };
23	    }
24	}
25	
26	class Adventure extends Movie {
27	
28	    public Adventure(String title) {
29	        super(title);
30	    }
31	
32	    @Override
33	    public void watchMovie() {
34	        super.watchMovie();
35	        System.out.printf(".. %s%n".repeat(3),
36	                "Pleasant Scene",
37	                "Scary Music",
38	                "Something Bad Happens");
39	    }
40	
41	    public void watchAdventure() {
42	        System.out.println("Watching an Adventure!");
43	    }
44	}
45	
46	class Comedy extends Movie {
47	
48	    public Comedy(String title) {
49	        super(title);
50	    }
51	
52	    @Override
53	    public void watchMovie() {
54	        super.watchMovie();
55	        System.out.printf(".. %s%n".repeat(3),
56	                "Something funny happens",
57	                "Something even funnier happens",
58	                "Happy Ending");
59	    }
60	
61	    public void watchComedy() {
62	        System.out.println("Watching a Comedy!");
63	    }
64	}
65	
66	class ScienceFiction extends Movie {
67	
68	    public ScienceFiction(String title) {
69	        super(title);
70	    }
71	
72	    @Override
73	    public void watchMovie() {
74	        super.watchMovie();
75	        System.out.printf(".. %s%n".repeat(3),
76	                "Bad Aliens do Bad Stuff",
77	                "Space Guys Chase Aliens",
78	                "Planet Blows Up");
79	    }
80	
81	    public void watchScienceFiction() {
82	        System.out.println("Watching a Science Fiction Thriller!");
83	    }
84	}
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\9 Source-code-OOP-Part-2-Polymorphism-Casting-with-classes-and-using-Object-and-var-references\Polymorphism\src\NextMain.java
1	public class NextMain {
2	
3	    public static void main(String[] args) {
4	
5	        Movie movie = Movie.getMovie("A", "Jaws");
6	        movie.watchMovie();
7	
8	        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
9	        jaws.watchMovie();
10	
11	        Object comedy = Movie.getMovie("C", "Airplane");
12	        Comedy comedyMovie = (Comedy) comedy;
13	        comedyMovie.watchComedy();
14	
15	        var airplane = Movie.getMovie("C", "Airplane");
16	        airplane.watchMovie();
17	
18	        var plane = new Comedy("Airplane");
19	        plane.watchComedy();
20	    }
21	}
```


Great — this section introduces **casting**, **Object references**, and **var (local variable type inference)** in Java **together with polymorphism**.
This is one of the most important lessons for understanding how Java handles types at runtime.

Let's break it down clearly and simply.

---

# 🎬 PART 1 — Review of Polymorphism So Far

You already know:

```java
Movie movie = Movie.getMovie("A", "Jaws");
movie.watchMovie();
```

Even though the reference type is **Movie**, the actual object is **Adventure**, so Adventure’s `watchMovie()` method runs.

That is polymorphism.

---

# 🎬 PART 2 — New Things Being Added

This section adds:

### ✔ **Downcasting**

### ✔ **Object references**

### ✔ **var keyword (Java 10+)**

### ✔ **Subclass-specific methods** like:

* `watchAdventure()`
* `watchComedy()`
* `watchScienceFiction()`

---

# 🎥 Understanding the New Methods in Subclasses

Each subclass now has an extra method:

### Adventure

```java
public void watchAdventure() { ... }
```

### Comedy

```java
public void watchComedy() { ... }
```

### ScienceFiction

```java
public void watchScienceFiction() { ... }
```

These methods **do not exist in Movie**.

So you **can’t call them using a Movie reference**.

---

# 📌 Why Not?

```java
Movie m = new Adventure("Jaws");
m.watchAdventure();   // ❌ ERROR — Movie doesn't have watchAdventure()
```

Even though the object is Adventure, the reference type decides what methods you can call.

---

# 🎯 To call subclass-specific methods: You must **cast**.

---

# 🧠 PART 3 — Understanding NextMain.java

Let’s go line by line.

---

## ✅ 1️⃣ Basic polymorphism

```java
Movie movie = Movie.getMovie("A", "Jaws");
movie.watchMovie();
```

Works exactly as before.

---

## ✅ 2️⃣ Downcasting to access subclass method

```java
Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
jaws.watchMovie();
```

**What’s happening:**

* `getMovie("A")` returns an **Adventure** object.
* We cast it to **Adventure**.
* Now we can access **Adventure-only methods** like:

```java
jaws.watchAdventure();
```

### ❗ NOTE

You must cast only when you're sure the object really *is* of that subclass.

---

## ❌ What if the types don’t match?

Example:

```java
Adventure a = (Adventure) Movie.getMovie("C", "Airplane");  // ❌ Will crash
```

Because `"C"` makes a Comedy, not Adventure.

This will throw:

```
ClassCastException
```

---

## ✅ 3️⃣ Using Object references

```java
Object comedy = Movie.getMovie("C", "Airplane");
Comedy comedyMovie = (Comedy) comedy;
comedyMovie.watchComedy();
```

Why does this work?

* `Object` is the **topmost class** in Java.
* Anything can be stored in an Object reference.
* But to call **Comedy-specific methods**, we must cast to Comedy.

---

# 🎯 Why use Object reference?

To demonstrate:

* Every class in Java is an Object.
* But you lose access to class-specific methods unless you cast.

---

## ✅ 4️⃣ Using var (type inference)

```java
var airplane = Movie.getMovie("C", "Airplane");
airplane.watchMovie();
```

### What is `var` doing?

* `var` **does NOT mean dynamic typing** like JavaScript.
* Java infers the type at compile time.

`var airplane = Movie.getMovie("C", "Airplane");`

→ Java knows the type is **Movie**, because the return type is Movie.

That’s why this works:

```java
airplane.watchMovie();
```

But this does **not** work:

```java
airplane.watchComedy(); // ❌ Error: Movie doesn't have watchComedy()
```

---

## ✅ 5️⃣ var with explicit constructor

```java
var plane = new Comedy("Airplane");
plane.watchComedy();
```

Here:

* `var plane` becomes a **Comedy** reference.
* So we can call **Comedy-only methods**.

---

# ⭐ Putting It All Together — What You Learned

| Concept              | Explanation                                               |
| -------------------- | --------------------------------------------------------- |
| **Polymorphism**     | A Movie reference can point to Adventure / Comedy / SciFi |
| **Downcasting**      | Needed to access subclass methods                         |
| **Object reference** | Can hold any type, but needs casting                      |
| **var keyword**      | Infers type at compile time                               |
| **Runtime type**     | Determines which overridden method executes               |
| **Reference type**   | Determines which methods you can call                     |

---

# 📌 Final Mental Model

### ● **Object type (runtime type)**

What the object REALLY is
→ Decides which overridden method runs.

### ● **Reference type (compile-time type)**

What the variable is declared as
→ Decides which methods you can call.

Example:

```java
Movie m = new Comedy("Airplane");
m.watchMovie();      // ✔ OK
m.watchComedy();     // ❌ Compile error — Movie has no watchComedy()
```

To fix it:

```java
((Comedy)m).watchComedy();
```

---

# 🎓 If you want, I can create:

✅ Visual diagrams of object/reference types
✅ Real-world analogy to understand casting
✅ A quiz to check your understanding
✅ A rewritten version of the code with explanations in comments

Would you like that?
