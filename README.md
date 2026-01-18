# Focusary: A Professional Productivity & Deep Work Suite

Focusary is a professional-grade desktop ecosystem engineered in Java, designed to consolidate essential productivity tools into a single, high-performance workspace. By integrating time-management science with environmental customization, Focusary provides developers and students with the ultimate environment for deep work.

---

## 🚀 Key Features

### 1. Advanced Pomodoro Lifecycle Management

* **Precision Countdown:** A dedicated `PomodoroTimer` engine that handles session logic independently of the UI.
* **Work/Break Cycles:** Optimized for the 25/5 technique to maintain peak cognitive performance.
* **Motivational Overlay:** Integrated `QuoteManager` that serves high-impact professional quotes during active sessions.

### 2. Comprehensive Task & Note Ecosystem

* **Hierarchical To-Do Lists:** Manage deliverables through a robust `ToDoPanel` utilizing a custom `Task` data model.
* **Temporal Note-Taking:** A date-centric `NotesPanel` allowing users to persist and retrieve documentation linked to specific calendar dates.
* **Data Persistence:** Leverages Java Serialization to ensure your tasks and notes remain persistent across sessions.

### 3. Sensory & Environmental Control

* **Audio Workspace:** A multi-layered `SoundManager` supporting local audio playback via `SoundSelectorPanel` and `SongSelectorPanel`.
* **Dynamic Visuals:** Custom `BackgroundManager` that handles real-time wallpaper transitions with serialization support (`backgrounds.ser`).
* **Fluid Navigation:** Implements `CardLayout` architecture for seamless switching between productivity modules without window clutter.

### 4. Smart Workspace Dashboard

* **Real-time Synchronization:** A central digital clock and adaptive greeting system that reacts to the user's current time of day.

---

## 🖼️ Graphical User Interface (GUI)

### 🖥️ Main Dashboard

The central hub featuring the synchronized digital clock, adaptive greetings, and primary navigation controllers.

> **[INSERT_SCREENSHOT_MAIN_DASHBOARD_HERE]**

### ⏱️ Pomodoro Focus Mode

The minimalist timer interface featuring a high-visibility countdown, session controls, and floating motivational quotes.

> **[INSERT_SCREENSHOT_POMODORO_TIMER_HERE]**

### 📝 Task & Daily Notes Module

The productivity workspace where tasks are tracked and date-specific notes are archived.

> **[INSERT_SCREENSHOT_NOTES_AND_TODO_HERE]**

### 🎵 Personalization & Media Settings

The configuration panel for selecting ambient soundscapes and high-resolution background aesthetics.

> **[INSERT_SCREENSHOT_SETTINGS_SELECTOR_HERE]**

---

## 🛠️ Technical Stack & Architecture

* **Language:** Java (JDK 8+)
* **UI Framework:** Java Swing / AWT
* **Architecture Pattern:** Manager-Component Pattern (Decoupled Logic)
* **State Management:** Java Object Serialization (`.ser`)
* **Layout Engine:** `CardLayout` for single-page application (SPA) behavior.

---

## 📂 Project Structure

The project follows a modular directory structure to separate concerns between source code and assets:

```text
Focusary/
├── Backgrounds/                # High-resolution UI wallpapers
├── Sounds/                     # Ambient focus music and audio assets
└── src/                        # Source Code
    ├── MainFrame.java          # Application Entry Point & Navigation
    ├── PomodoroTimer.java      # Core Timing Logic
    ├── PomodoroPanel.java      # Timer UI Component
    ├── ToDoPanel.java          # Task Management Interface
    ├── Task.java               # Task Data Model
    ├── NotesPanel.java         # Note Archival Interface
    ├── Note.java               # Note Data Model
    ├── SoundManager.java       # Audio Playback Engine
    ├── SongSelectorPanel.java  # Audio Selection Logic
    ├── BackgroundManager.java  # Image Serialization & Management
    ├── BackgroundPanel.java    # Custom UI Rendering Engine
    ├── QuoteManager.java       # Motivational Content Engine
    └── backgrounds.ser         # Serialized State Data

```

---

## 📥 Installation & Setup

### Prerequisites

* Java Development Kit (JDK) 8 or higher.
* A terminal/command prompt.

### Quick Start

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/Focusary.git
cd Focusary

```


2. **Prepare Assets:**
* Place `.jpg` images in the `/Backgrounds` directory.
* Place `.wav` or supported audio files in the `/Sounds` directory.


3. **Compile the source:**
```bash
javac -d bin src/*.java

```


4. **Launch the application:**
```bash
java -cp bin MainFrame

```



---

## 🤝 Contributing

I welcome contributions.

1. Fork the Project.
2. Create your Feature Branch (`git checkout -b feature/NewFeature`).
3. Commit your changes (`git commit -m 'Add NewFeature'`).
4. Push to the Branch (`git push origin feature/NewFeature`).
5. Open a Pull Request.

---

**Focusary** | *Engineered for Excellence in Productivity*
