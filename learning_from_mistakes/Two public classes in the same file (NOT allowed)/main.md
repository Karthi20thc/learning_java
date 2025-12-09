```java
public class Main{
  
  public static void main(String args[]){
   
      Student stu =  new Student("karthik");
       System.out.println(stu);
  }
}


public class Student{
    private String name;
    
    public Student(String name){
        this.name = name;
    }
} 
```
what is the problem here 


Your code has **two problems**:

---

## ✅ **1. Two public classes in the same file (NOT allowed)**

In Java, **a .java file can contain only one public class**, and the filename must match that class name.

You wrote:

```java
public class Main { ... }

public class Student { ... }
```

This will cause a compile-time error:

```
error: class Student is public, should be declared in a file named Student.java
```

### ✔ FIX

Put them in separate files:

**Main.java**

```java
public class Main {
    public static void main(String args[]) {
        Student stu = new Student("karthik");
        System.out.println(stu);
    }
}
```

**Student.java**

```java
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
```

---

## ❗ **2. Printing the object prints a hashcode, not the name**

Because you did:

```java
System.out.println(stu);
```

Java by default prints:

```
Student@7a81197d
```

You did **not override `toString()`**, so Java uses the default from Object class.

### ✔ FIX

Add a `toString()` method inside Student:

```java
@Override
public String toString() {
    return "Student name: " + name;
}
```

---

## ⭐ Final corrected `Student.java`:

```java
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student name: " + name;
    }
}
```

---

If you want, I can rewrite everything in a single file **without public for Student**, which also works.
