```java
Folder resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\7 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-1\Polymorphism\src
2 printable files
(file list disabled)

resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\7 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-1\Polymorphism\src\Main.java
1	public class Main {
2	
3	    public static void main(String[] args) {
4	
5	        Movie theMovie = new Adventure("Star Wars");
6	        theMovie.watchMovie();
7	    }
8	}
9	 
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\7 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-1\Polymorphism\src\Movie.java
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
14	}
15	
16	class Adventure extends Movie {
17	
18	    public Adventure(String title) {
19	        super(title);
20	    }
21	
22	    @Override
23	    public void watchMovie() {
24	        super.watchMovie();
25	        System.out.printf(".. %s%n".repeat(3),
26	                "Pleasant Scene",
27	                "Scary Music",
28	                "Something Bad Happens");
29	    }
30	}
31	
32	class Comedy extends Movie {
33	
34	    public Comedy(String title) {
35	        super(title);
36	    }
37	
38	    @Override
39	    public void watchMovie() {
40	        super.watchMovie();
41	        System.out.printf(".. %s%n".repeat(3),
42	                "Something funny happens",
43	                "Something even funnier happens",
44	                "Happy Ending");
45	    }
46	}
47	
48	class ScienceFiction extends Movie {
49	
50	    public ScienceFiction(String title) {
51	        super(title);
52	    }
53	
54	    @Override
55	    public void watchMovie() {
56	        super.watchMovie();
57	        System.out.printf(".. %s%n".repeat(3),
58	                "Bad Aliens do Bad Stuff",
59	                "Space Guys Chase Aliens",
60	                "Planet Blows Up");
61	    }
62	}
```



Great — this is a **perfect example of Polymorphism**.
This code teaches you **what polymorphism is**, **how method overriding works**, and **why inheritance is powerful**.

Let’s break it down step-by-step in a simple, beginner-friendly way.

---

# 🎥 **1. What This Code Demonstrates**

### ✔ Inheritance

`Adventure`, `Comedy`, and `ScienceFiction` **extend** the `Movie` class.

### ✔ Method Overriding

Each subclass overrides `watchMovie()`.

### ✔ Polymorphism

The line:

```java
Movie theMovie = new Adventure("Star Wars");
```

creates an object of type `Adventure`, but **treats it like a Movie**.

This is the core of polymorphism.

---

# 🧠 **2. Understanding the Main Code**

```java
Movie theMovie = new Adventure("Star Wars");
theMovie.watchMovie();
```

### What happens?

1. **theMovie is declared as Movie**
   → So the compiler only knows Movie methods.

2. **theMovie is actually an Adventure object**
   → At runtime, Java calls Adventure's version of watchMovie().

This is **runtime polymorphism** or **dynamic method dispatch**.

---

# 🎬 **3. Understanding Movie.java**

```java
public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }
}
```

### Key things:

* `Movie` has a private field `title`.
* `watchMovie()` prints:

```
Star Wars is an Adventure film
```

Because:

```java
this.getClass().getSimpleName()
```

returns the **actual subclass name** (Adventure, Comedy, ScienceFiction).

---

# 🧭 **4. Subclasses (Adventure, Comedy, ScienceFiction)**

Each subclass:

✔ Calls the parent constructor (`super(title)`)
✔ Overrides `watchMovie()`
✔ Calls the parent method using `super.watchMovie()`
✔ Adds its own behavior

---

# 🎭 **Adventure class**

```java
@Override
public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3),
            "Pleasant Scene",
            "Scary Music",
            "Something Bad Happens");
}
```

Output:

```
Star Wars is an Adventure film
.. Pleasant Scene
.. Scary Music
.. Something Bad Happens
```

---

# 😂 **Comedy class**

```java
@Override
public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3),
            "Something funny happens",
            "Something even funnier happens",
            "Happy Ending");
}
```

---

# 👽 **ScienceFiction class**

```java
@Override
public void watchMovie() {
    super.watchMovie();
    System.out.printf(".. %s%n".repeat(3),
            "Bad Aliens do Bad Stuff",
            "Space Guys Chase Aliens",
            "Planet Blows Up");
}
```

---

# 🌟 **5. What Polymorphism Really Means Here**

Polymorphism = **one reference type, many object forms**

```java
Movie m1 = new Adventure("Indiana Jones");
Movie m2 = new Comedy("Hangover");
Movie m3 = new ScienceFiction("Interstellar");
```

Even though all are declared as **Movie**, each one behaves differently when you call:

```java
m1.watchMovie();
m2.watchMovie();
m3.watchMovie();
```

This is the power of polymorphism.

---

# 🎯 **6. Why This Code Is Important**

You learn:

| Concept           | Meaning                                       |
| ----------------- | --------------------------------------------- |
| Inheritance       | Subclasses reuse parent code                  |
| Method Overriding | Subclasses customize behavior                 |
| Polymorphism      | Same method call → different results          |
| Dynamic Binding   | Java decides at runtime which version to call |

---

# 🧩 **7. Mini Summary (Very Simple)**

* `Movie` is the parent class.
* `Adventure`, `Comedy`, and `ScienceFiction` are child classes.
* Each child class **overrides** `watchMovie()`.
* When you call `watchMovie()` on a Movie reference, Java calls the **child version** based on the actual object type.
* This is **runtime polymorphism**.

---

# 🎓 If you want, I can explain the next part:

In Part-2 of Polymorphism, they show **factory methods** and **random movie selection**.

Want that explanation too?
