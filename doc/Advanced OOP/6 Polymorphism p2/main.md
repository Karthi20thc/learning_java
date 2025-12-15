```java
Folder resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\8 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-2\Polymorphism\src
2 printable files
(file list disabled)

resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\8 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-2\Polymorphism\src\Main.java
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
resource\Sec 8 Advanced OOP Composition, Encapsulation, and Polymorphism\8 Source-code-OOP-Part-2-Polymorphism-Polymorphism-Part-2\Polymorphism\src\Movie.java
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
40	}
41	
42	class Comedy extends Movie {
43	
44	    public Comedy(String title) {
45	        super(title);
46	    }
47	
48	    @Override
49	    public void watchMovie() {
50	        super.watchMovie();
51	        System.out.printf(".. %s%n".repeat(3),
52	                "Something funny happens",
53	                "Something even funnier happens",
54	                "Happy Ending");
55	    }
56	}
57	
58	class ScienceFiction extends Movie {
59	
60	    public ScienceFiction(String title) {
61	        super(title);
62	    }
63	
64	    @Override
65	    public void watchMovie() {
66	        super.watchMovie();
67	        System.out.printf(".. %s%n".repeat(3),
68	                "Bad Aliens do Bad Stuff",
69	                "Space Guys Chase Aliens",
70	                "Planet Blows Up");
71	    }
72	}
```



Great — this section teaches **factory methods** + **polymorphism**, which is an important OOP pattern.
You’ve already learned basic polymorphism in Part-1.
Part-2 shows how to **create objects dynamically** based on user input.

Let’s break down the entire code clearly and simply.

---

# 🎬 **1. Main Idea of This Code**

This code demonstrates:

### ✔ Polymorphism (same method, different behavior)

### ✔ Factory Method pattern (`getMovie()`)

### ✔ Dynamic object creation at runtime

### ✔ Method overriding (each movie type has its own `watchMovie()` output)

---

# 🧠 **2. Understanding Main.java**

```java
Scanner s = new Scanner(System.in);

while (true) {
    System.out.print("Enter Type (A for Adventure, C for Comedy, S for Science Fiction, or Q to quit): ");
    String type = s.nextLine();

    if ("Qq".contains(type)) {
        break;
    }

    System.out.print("Enter Movie Title: ");
    String title = s.nextLine();

    Movie movie = Movie.getMovie(type, title);
    movie.watchMovie();
}
```

### What’s happening?

1. Program asks user for a movie type:

   ```
   A → Adventure
   C → Comedy
   S → Science Fiction
   Q → Quit
   ```

2. Asks for a movie title.

3. This line is key:

```java
Movie movie = Movie.getMovie(type, title);
```

This means:

* You don’t create the movie object yourself.
* You ask the **factory method** to decide which subclass to create.

4. Then:

```java
movie.watchMovie();
```

This will run the **correct overridden method** due to polymorphism.

---

# 🏭 **3. Understanding getMovie() — Factory Method**

```java
public static Movie getMovie(String type, String title) {

    return switch (type.toUpperCase().charAt(0)) {
        case 'A' -> new Adventure(title);
        case 'C' -> new Comedy(title);
        case 'S' -> new ScienceFiction(title);
        default -> new Movie(title);
    };
}
```

### Purpose of a Factory Method:

✔ Centralizes object creation
✔ Allows returning **different subclasses**
✔ Helps achieve polymorphism cleanly

### Example:

Input:

```
type = "C"
title = "Hangover"
```

Then `getMovie()` returns:

```java
new Comedy("Hangover");
```

But the return type remains **Movie**.

---

# 🎥 **4. Polymorphism in Action**

You might write:

```java
Movie movie = Movie.getMovie("A", "Star Wars");
```

But Java decides at runtime that:

* This is actually an **Adventure** object.
* So when you call:

```java
movie.watchMovie();
```

Java calls:

### 🔥 Adventure’s overridden method, not Movie’s.

This is **runtime polymorphism**.

---

# 🎭 **5. Understanding Each Subclass**

### ✔ Adventure

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

### ✔ Comedy

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

### ✔ ScienceFiction

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

# 📌 **6. What You Learn From This Example**

### 🔹 **Inheritance**

Adventure, Comedy, and ScienceFiction extend Movie.

### 🔹 **Overriding**

Each subclass overrides `watchMovie()`.

### 🔹 **Polymorphism**

Movie reference → calls the correct subclass method.

### 🔹 **Factory Method**

`getMovie()` creates the right object based on input.

### 🔹 **Cleaner Code**

Main class never needs to write:

```java
new Adventure();
new Comedy();
new ScienceFiction();
```

It just calls:

```java
Movie.getMovie(type, title);
```

---

# 🧩 **7. Simple Summary**

| Concept              | Meaning                                       |
| -------------------- | --------------------------------------------- |
| **Factory Method**   | A method that decides which object to create. |
| **Polymorphism**     | Same method call → different behavior.        |
| **Overriding**       | Subclass changes parent's method.             |
| **Dynamic Dispatch** | Java picks the correct method at runtime.     |
| **Clean Design**     | Main program doesn't care about subclasses.   |

---

# 🎓 If you want, I can also explain:

✅ How to design your own factory pattern
✅ How polymorphism is used in real-world systems
✅ Why switch + factory method is common in Java

Would you like deeper examples?
