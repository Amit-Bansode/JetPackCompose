# Jetpack Compose Side Effects & State Practice

A practical learning project focused on mastering **Jetpack Compose Side Effects**, state management, and resolving advanced configuration issues in modern Android development.

## 🚀 Key Features

- **Dynamic Round Counter**: A unit converter/counter app that tracks totals and increments "Rounds" when thresholds (e.g., 300) are exceeded.
- **Side Effect Mastery**: Implementation of both event-driven and state-driven side effects.
- **Material 3 Integration**: Robust use of `Scaffold`, `SnackbarHost`, and `OutlinedTextField` for a modern UX.
- **Dependency Injection**: Fully configured with **Dagger Hilt** and **KSP**.

## 🧠 Core Learning Concepts

### 1. Jetpack Compose Side Effects
This project explores two primary ways to handle logic that occurs outside the composition:
- **`rememberCoroutineScope`**: Used for **event-driven** side effects. In this app, it launches a coroutine from a Button's `onClick` to show a Snackbar manually.
- **`LaunchedEffect`**: Used for **state-driven** side effects. It allows triggering actions (like analytics or UI feedback) automatically when a specific state (like `round`) changes.

### 2. UI Persistence & Layout
- **Scaffold & SnackbarHost**: Learned the necessity of `SnackbarHost` within a `Scaffold` to make snackbars visible and manageable.
- **State Hoisting**: Managing `total`, `input`, and `round` states using `remember` and `mutableStateOf`.

## 🛠 Troubleshooting & Solutions

### 1. Hilt & Kotlin Metadata Conflict
**Issue**: `[Hilt] Provided Metadata instance has version 2.4.0, while maximum supported version is 2.3.0`.
**Cause**: Bleeding-edge Kotlin versions (2.4.0) produce metadata that Hilt's internal libraries cannot yet parse.
**Solution**: Overrode the `kotlin-metadata-jvm` dependency in the KSP configuration within `build.gradle.kts`:
```kotlin
ksp("org.jetbrains.kotlin:kotlin-metadata-jvm:${libs.versions.kotlin.get()}")
```

### 2. Syntax Errors: "Expecting member declaration"
**Issue**: Error triggered by invalid higher-order function parameter syntax.
**Lesson**: Functional parameters must have a name and a proper type declaration (e.g., `operation: (Int, Int) -> Int`) instead of just a lambda expression in the signature.

## 🛠 Tech Stack

- **Kotlin**: 2.4.0 (Latest)
- **Jetpack Compose**: Material 3
- **Dependency Injection**: Dagger Hilt
- **Processor**: KSP (Kotlin Symbol Processing)
- **Build System**: Gradle Version Catalog (toml)

---
*This project is part of a Jetpack Compose deep-dive curriculum.*
