# Java Development Style Guide

This document outlines the standard coding practices and conventions for our Java projects.
Adhering to these guidelines ensures a clean, maintainable, and professional codebase that
is easy for all team members to read and collaborate on.

---

## Table of Contents
- [1. Naming Standards](#1-naming-standards)
- [2. Layout & Formatting](#2-layout--formatting)
- [3. Core Development Principles](#3-core-development-principles)
- [4. Robust Error Handling](#4-robust-error-handling)
- [5. Documentation & Annotations](#5-documentation--annotations)

---

## 1. Naming Standards

Clear naming patterns are the foundation of self-documenting code.

| Element | Convention | Examples |
|---|---|---|
| Classes & Interfaces | `PascalCase` — use nouns that clearly describe the object's responsibility | `AccountManager`, `DataValidator`, `EmailService` |
| Methods | `camelCase` — start with a verb to indicate the action being performed | `processTransaction()`, `fetchUserById()`, `isAuthorized()` |
| Variables | `camelCase` — choose descriptive, intention-revealing names. Avoid cryptic abbreviations or single-letter names (except for simple loop counters) | `retryAttempt`, `userEmail`, `totalPrice` |
| Constants | `SCREAMING_SNAKE_CASE` — always declare as `static final` | `MAX_LOGIN_ATTEMPTS`, `API_ENDPOINT_URL` |
| Packages | lowercase alphanumeric characters only — no underscores or camelCase | `com.ourcompany.project.module` |

---

## 2. Layout & Formatting

Consistency in layout reduces cognitive load during code reviews and debugging.

### Indentation
- Strictly use **4 spaces** per level.
- Never use tabs.

### Brace Placement
Follow the **"Egyptian"** style — the opening brace stays on the same line as the statement,
and the closing brace is on its own line.
```java
public void executeTask() {
    if (condition) {
        doSomething();
    } else {
        handleAlternative();
    }
}
```

### Line Breadth
- Limit code lines to **100–120 characters** to ensure readability without horizontal scrolling.

### Vertical Spacing
- Use **single blank lines** to separate logical blocks within methods and to separate method
  declarations.

---

## 3. Core Development Principles

### Immutability
Use the `final` keyword for variables, fields, and parameters whenever their values are not
intended to change after initialization.

### Eliminate Magic Numbers
Replace literal numbers or strings with **named constants** to provide context and ease of
maintenance.

### Encapsulation
Default to the most restrictive access level (`private`). Only widen visibility (`protected`
or `public`) when strictly necessary.

### Declaration Proximity
Declare local variables as close as possible to their first point of use.

### Method Design
- **Keep them lean** — aim for 5–20 lines. A method should perform exactly one logical task.
- **Parameter Limits** — if a method requires more than 3 or 4 arguments, encapsulate them
  into a dedicated Data Transfer Object (DTO).
- **Avoid Boolean Flags** — passing booleans as parameters often suggests a method is doing
  too much; consider splitting the method instead.

### Member Organization
Maintain a consistent internal class structure in this order:

1. Constants & Static Fields
2. Instance Variables
3. Constructors
4. Public Methods
5. Private / Helper Methods

### DRY (Don't Repeat Yourself)
Centralize logic. If logic is duplicated, refactor it into a reusable utility or method.

---

## 4. Robust Error Handling

### Catch Specifics
Never use `catch (Exception e)`. Always target the most specific exception type expected.

### Use Optionals
Return `Optional<T>` instead of `null` to explicitly represent the possible absence of
a value.

### No Silent Failures
Never leave a catch block empty. At a minimum, log the error. Ideally, wrap it in a custom
exception to maintain context.
```java
try {
    resource.load();
} catch (SpecificDataException e) {
    log.error("Initialization failed for: {}", resourceName, e);
    throw new ServiceException("System failed to start due to configuration error", e);
}
```

---

## 5. Documentation & Annotations

### Javadoc
Use Javadoc (`/** ... */`) for all public APIs — classes, interfaces, and public methods.
Always define `@param`, `@return`, and `@throws` clearly.

### Meaningful Comments
Use inline comments (`//`) to explain the **why** behind complex logic. The code itself
should be readable enough to explain the **what**.
