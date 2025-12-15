```java
Folder resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\10 Source-code-OOP-Part-2-Polymorphism-Testing-the-runtime-type-using-the-instanceof-operator\Polymorphism\src
3 printable files
(file list disabled)

resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\10 Source-code-OOP-Part-2-Polymorphism-Testing-the-runtime-type-using-the-instanceof-operator\Polymorphism\src\Main.java
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
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\10 Source-code-OOP-Part-2-Polymorphism-Testing-the-runtime-type-using-the-instanceof-operator\Polymorphism\src\Movie.java
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
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\10 Source-code-OOP-Part-2-Polymorphism-Testing-the-runtime-type-using-the-instanceof-operator\Polymorphism\src\NextMain.java
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
20	
21	        Object unknownObject = Movie.getMovie("S", "Star Wars");
22	        if (unknownObject.getClass().getSimpleName() == "Comedy") {
23	            Comedy c = (Comedy) unknownObject;
24	            c.watchComedy();
25	        } else if (unknownObject instanceof Adventure) {
26	            ((Adventure) unknownObject).watchAdventure();
27	        } else if (unknownObject instanceof ScienceFiction syfy) {
28	            syfy.watchScienceFiction();
29	        }
30	    }
31	}
```

Great — this section teaches **how to test the actual runtime type of an object** using:

✔ `instanceof`
✔ pattern matching with `instanceof` (Java 16+)
✔ comparing class names (not recommended)
✔ safe vs unsafe casting

This is the final step of understanding **polymorphism + casting + type checking** in Java.

Let’s go step-by-step.

---

# 🎬 PART 1 — Review: Why Do We Need Type Checking?

You already learned:

```java
Movie m = Movie.getMovie("A", "Jaws");
m.watchMovie();
```

But **Movie references cannot call subclass-only methods**:

```java
m.watchAdventure(); // ❌ ERROR
```

To call subclass methods like `watchAdventure()`, you must **downcast**:

```java
((Adventure) m).watchAdventure();
```

BUT this will **crash the program** if `m` is not an Adventure.

So before casting, you must **check what the object really is**.

That's what `instanceof` is for.

---

# 🎥 PART 2 — Understanding NextMain.java

Let’s go section by section.

---

## ✅ 1️⃣ Basic polymorphism

```java
Movie movie = Movie.getMovie("A", "Jaws");
movie.watchMovie();
```

Works fine.

---

## ✅ 2️⃣ Downcasting

```java
Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
jaws.watchMovie();
```

This is **safe** because you know `"A"` produces an Adventure.

---

## ✅ 3️⃣ Object reference + cast

```java
Object comedy = Movie.getMovie("C", "Airplane");
Comedy comedyMovie = (Comedy) comedy;
comedyMovie.watchComedy();
```

Why this works:

* `Object` can hold **any type**.
* But to call child methods, you must cast.

---

# ⚠️ PART 3 — The Important Section:

```java
Object unknownObject = Movie.getMovie("S", "Star Wars");
```

We don’t know:

* Is it Adventure?
* Is it Comedy?
* Is it ScienceFiction?
* Is it plain Movie?

So we test it:

---

## ❌ 4️⃣ Testing with class name (NOT recommended)

```java
if (unknownObject.getClass().getSimpleName() == "Comedy") {
```

This works *sometimes*, but it's not reliable because of:

* String pool issues
* Class renaming
* Refactoring

Better to use `instanceof`.

---

## ✅ 5️⃣ Testing with instanceof

```java
else if (unknownObject instanceof Adventure) {
    ((Adventure) unknownObject).watchAdventure();
}
```

Meaning:

* If object is **an instance of Adventure**, call Adventure-only method.

This is **safe casting** because instanceof ensures no ClassCastException.

---

## 🆕 6️⃣ Pattern Matching for instanceof (Java 16+)

This line is powerful:

```java
else if (unknownObject instanceof ScienceFiction syfy) {
    syfy.watchScienceFiction();
}
```

Explanation:

* If object is a **ScienceFiction**
* Automatically cast it into a variable **syfy**
* No need to write `(ScienceFiction) unknownObject`

This is cleaner, safer, and modern Java.

---

# 📌 Summary of the Three Approaches

## ❌ Bad way

```java
unknownObject.getClass().getSimpleName() == "Comedy"
```

→ Should avoid string comparison.

---

## ✔ Good way (Classic Java)

```java
if (unknownObject instanceof Comedy) {
    ((Comedy) unknownObject).watchComedy();
}
```

---

## ⭐ Best way (Modern Java 16+)

```java
if (unknownObject instanceof Comedy c) {
    c.watchComedy();
}
```

Cleaner, safer, fewer errors.

---

# 🧠 POLYMORPHISM + INSTANCEOF — WHY IMPORTANT?

Because:

### 🔹 Polymorphism → You handle parent type (`Movie`)

But

### 🔹 Subclass methods exist only in child classes.

So to safely use child-specific methods:

1. Check type at runtime (`instanceof`)
2. Then safely cast

This prevents:

```
ClassCastException
```

---

# 🎯 What You Have Learned Across All Polymorphism Lessons

| Lesson | Concept                                      |
| ------ | -------------------------------------------- |
| Part 1 | Basic polymorphism + overriding              |
| Part 2 | Factory method + runtime type selection      |
| Part 3 | Casting and var and Object reference         |
| Part 4 | Using instanceof to test runtime type safely |

Together, these form the **complete foundation of polymorphism in Java**.

---

# 🧩 Final Mental Model

### ✔ The **object type** (runtime type)

→ Adventure, Comedy, SciFi
→ Determines which overridden method runs (`watchMovie()`)

### ✔ The **reference type** (compile-time type)

→ Movie, Object, var
→ Determines what methods you are allowed to call

### ✔ `instanceof`

→ Lets you safely check the true type before casting

### ✔ Downcasting

→ Lets you call subclass-specific methods safely

---

# 🎓 If you want, I can now:

✅ Give real-world examples of polymorphism
✅ Create diagrams of object vs reference type
✅ Create a quiz to test your understanding
✅ Rewrite this whole example with comments

Just tell me!
