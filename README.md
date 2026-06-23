# Jetpack Compose Side Effects Practice

This project is a learning playground for mastering **Jetpack Compose Side Effects** and modern Android development patterns. It features a simple "Round Counter" app that demonstrates how to handle non-UI logic safely during the composition lifecycle.

## 🚀 Features

- **Total Counter**: Add numeric values to a running total.
- **Round Logic**: Automatically resets the total and increments the "Round" when the sum exceeds 300.
- **Side Effect Integration**: Uses `LaunchedEffect` to trigger UI feedback (Snackbars) in response to state changes.
- **Hilt Dependency Injection**: Configured with Dagger Hilt for dependency management.
- **Modern UI**: Built entirely with Material 3 components like `Scaffold`, `SnackbarHost`, and `OutlinedTextField`.

## 🧠 What I Learned

### 1. Jetpack Compose Side Effects
Composition should ideally be side-effect free. To perform actions like showing a Snackbar when a state changes, we use **`LaunchedEffect`**.
- **Key-based triggers**: The effect re-runs only when the `round` key changes.
- **Coroutine Scope**: `LaunchedEffect` provides a coroutine scope that is automatically cancelled when the Composable leaves the composition.

### 2. Handling Kotlin 2.x + Hilt Compatibility
During development, I encountered a common metadata version mismatch between the latest Kotlin (2.4.0) and Hilt. 
- **The Issue**: `Provided Metadata instance has version 2.4.0, while maximum supported version is 2.3.0`.
- **The Fix**: Manually overriding the `kotlin-metadata-jvm` dependency in the KSP configuration to allow Hilt to parse newer Kotlin metadata formats.

### 3. Material 3 Scaffold & Snackbars
- Learned that `SnackbarHostState` requires a `SnackbarHost` inside a `Scaffold` to be visible.
- Practiced using `innerPadding` from `Scaffold` to ensure the layout respects system bars and UI components like Snackbars.

## 🛠 Tech Stack

- **Kotlin**: 2.4.0
- **Jetpack Compose**: Multi-platform compatible
- **Material 3**: Latest UI components
- **Hilt**: Dependency Injection
- **KSP**: Kotlin Symbol Processing (Faster than Kapt)

## 📸 How it Works

1. Enter a number in the text field.
2. Tap **Count**.
3. When the total hits **300**, the `round` increments.
4. `LaunchedEffect` detects the change in `round` and calls `snackbarHostState.showSnackbar()`.
