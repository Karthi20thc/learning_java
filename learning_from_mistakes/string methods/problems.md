Here is a **clean, simple list** of problems — no explanations, no details — just a **pure list** you can use to practice all String methods in Java.

---

# ✅ **Java String Practice Problem List**

1. Count vowels in a string
2. Reverse a string manually
3. Check if a string is a palindrome
4. Find first & last index of a character
5. Replace all vowels with `*`
6. Count words in a sentence
7. Extract username from an email
8. Convert a messy name to title case (e.g., "kArThIk" → "Karthik")
9. Remove all special characters in a string
10. Check if a string contains only digits
11. Compress repeating characters (e.g., aaabb → a3b2)
12. Find the most frequent character in a string
13. Count occurrences of a word (case-insensitive)
14. Remove duplicate characters from a string
15. Sort words alphabetically
16. Build a string of numbers 1–100 using StringBuilder
17. Reverse a string using StringBuilder
18. Compare String vs StringBuilder performance for concatenation
19. Find longest substring without repeating characters
20. Implement your own substring method (without using substring())
21. Remove duplicate words from a sentence
22. Find the longest palindromic substring
23. Check if two strings are anagrams
24. Count uppercase, lowercase, digits, and special chars
25. Rotate a string left by N characters
26. Check if one string contains another (manual, without contains())
27. Split a sentence into words and print each on new line
28. Replace multiple spaces with a single space
29. Check if a string starts and ends with the same character
30. Find all substrings of a string

---



Here are **practice problems** that will force you to use **almost every important built-in String method in Java**. I’ve grouped them by concept and difficulty so you can progress step-by-step.

---

# ✅ **Beginner Level — Core String Methods**

### **1. Count vowels**

**Methods to use:** `charAt()`, `length()`, `toLowerCase()`

> Write a program that counts how many vowels (a,e,i,o,u) are in a string.

---

### **2. Reverse a string**

**Methods:** `charAt()`, `length()`

> Reverse the given string manually (without using StringBuilder).

---

### **3. Check palindrome**

**Methods:** `equalsIgnoreCase()`, `charAt()`

> Check if a string reads the same forward and backward.

---

### **4. Find the index of a character**

**Methods:** `indexOf()`, `lastIndexOf()`

> Find the first and last occurrence of a character in a string.

---

### **5. Replace characters**

**Methods:** `replace()`, `replaceAll()`

> Replace all vowels in the string with `*`.

---

# 🟦 **Intermediate Level — Manipulation & Parsing**

### **6. Count words**

**Methods:** `trim()`, `split(" ")`

> Count the total number of words in a sentence.

---

### **7. Extract username from email**

**Methods:** `substring()`, `indexOf()`

> For input: `"karthik.mani@gmail.com"`
> Return `"karthik.mani"`.

---

### **8. Format a name**

**Methods:** `toUpperCase()`, `toLowerCase()`, `substring()`

> Convert `"kArThIk mAnI"` → `"Karthik Mani"`

---

### **9. Remove special characters**

**Methods:** `replaceAll("[^a-zA-Z0-9]", "")`

> Remove all non-alphanumeric characters.

---

### **10. Check if string contains only digits**

**Methods:** `matches("regex")`

---

# 🟩 **Advanced Level — Using Many Methods Together**

### **11. Compress repeating characters**

**Methods:** `charAt()`, `length()`, `StringBuilder`, `+=` (optional)

> `"aaabbccccd"` → `"a3b2c4d1"`

---

### **12. Find most frequent character**

**Methods:** `toCharArray()`, loops, `replace()`

---

### **13. Count occurrences of a word**

**Methods:**
`toLowerCase()`, `split()`, `equals()`

> Count how many times `"java"` appears in:
> `"Java is great. I love java because JAVA is powerful"`

---

### **14. Remove duplicate characters**

**Methods:**
`contains()`, `StringBuilder`, `indexOf()`

> `"banana"` → `"ban"`

---

### **15. Sort words alphabetically**

**Methods:** `split()`, `Arrays.sort()`, `join()`

---

# 🟪 **StringBuilder / StringBuffer Problems**

(Not String methods, but important for performance)

### **16. Build a string of numbers from 1 to 100**

**Methods:** `append()`, loops

---

### **17. Reverse string using StringBuilder**

**Methods:** `reverse()`

---

### **18. Check mutability difference**

> Write a program to compare time between:

* concatenating 10,000 strings using `String`
* concatenating using `StringBuilder`

---

# 🟥 **Very Advanced — Interview Hard Level**

### **19. Find longest substring without repeating characters**

**Methods:**
`contains()`, `substring()`, sliding window logic

---

### **20. Implement your own `substring`**

> Without using built-in `substring()`, manually extract text between indices.

---

### **21. Remove all duplicate *words***

**Methods:** `split()`, `toLowerCase()`, loops, `contains()`

> `"This is is a test Test this"` → `"This is a test"`

---

### **22. Find the longest palindromic substring**

**Methods:** `substring()`, loops, `equals()`

---

# 🔥 Want full solutions?

Tell me the **problem numbers**, and I’ll give:

* full Java code
* explanation
* test cases

Just say: **“give solution for 7 & 12”** or whichever you want.
