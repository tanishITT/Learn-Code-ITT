# Exception Handling in Java: `try`, `catch`, and `finally`

## 1. What is Exception Handling?

When a Java program runs, things can go wrong — a file might not exist, a number might be divided by zero, or a network call might fail. Java provides a structured way to deal with these situations using **exception handling**.

The three building blocks are:
* `try`
* `catch`
* `finally`

---

## 2. Breaking Down Each Block

### 2.1 The `try` Block

Wrap any code that has the **potential to fail** inside a `try` block.

```java
try {
    int result = 10 / 0; // this will blow up
}
```

Think of it as saying: *"Try running this, but be ready for things to go wrong."*

---

### 2.2 The `catch` Block

If something goes wrong inside `try`, the `catch` block **intercepts the error** and lets you respond to it.

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Oops! Can't divide by zero.");
}
```

Flow of control:
* Exception is thrown inside `try`
* Execution jumps immediately to `catch`
* The rest of `try` is skipped

---

### 2.3 The `finally` Block

The `finally` block runs **no matter what** — whether an exception occurred or not.

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception caught.");
} finally {
    System.out.println("I will always run.");
}
```

`finally` executes even if:
* No exception occurred
* There's a `return` statement inside `try` or `catch`
* The exception was not caught

---

## 3. Valid Ways to Combine Them

Java requires that every `try` is paired with **at least one** `catch` or `finally`.

### `try` + `catch`
```java
try {
    riskyMethod();
} catch (Exception e) {
    System.out.println("Handled: " + e.getMessage());
}
```
Use this when you want to **react to a specific failure**.

---

### `try` + `finally`
```java
try {
    riskyMethod();
} finally {
    System.out.println("Cleanup done.");
}
```
Use this when you **don't want to handle the exception here**, but still need to clean up. The exception will bubble up to the caller.

---

### `try` + `catch` + `finally`
```java
try {
    riskyMethod();
} catch (Exception e) {
    handleError(e);
} finally {
    cleanup();
}
```
The most complete form — handles the error **and** guarantees cleanup.

---

### ❌ `try` alone — Not allowed
```java
try {
    riskyMethod();
}
// Compile error: try must have catch or finally
```

---

## 4. The Thinking Behind the Design

Each keyword has one clear job:

| Block     | Purpose                          |
|-----------|----------------------------------|
| `try`     | Marks code that might fail       |
| `catch`   | Handles the failure              |
| `finally` | Guarantees post-execution cleanup |

This separation keeps code organized. You're not forced to handle every exception at every level — sometimes it makes more sense to **clean up locally** and let the exception travel up to a caller that knows what to do with it.

---

## 5. Practical Example — File Handling

### Without `try-finally` (risky):
```java
FileInputStream file = new FileInputStream("data.txt");
int data = file.read(); // exception here means...
file.close();           // ...this never runs
```

This causes resource leaks — the file stays open even after the program crashes.

### With `try-finally` (safe):
```java
FileInputStream file = new FileInputStream("data.txt");
try {
    int data = file.read();
} finally {
    file.close(); // guaranteed to run
}
```

Now `close()` is called regardless of what happens. The exception still propagates, but resources are properly released.

---

## 6. Modern Shortcut — Try-With-Resources

Java introduced a cleaner syntax for managing resources that need to be closed:

```java
try (FileInputStream file = new FileInputStream("data.txt")) {
    int data = file.read();
}
```

No explicit `finally` or `close()` needed. Java handles it automatically. Under the hood, this compiles to the same `try-finally` pattern shown above.

Any class that implements `AutoCloseable` can be used this way.
