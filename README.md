# 🎵 Spotify Clone (LLD-Based Music Player)

This project is a **Low-Level Design (LLD) implementation** of a simplified Spotify-like music player system.  
It demonstrates **system design patterns**, including Singleton, Strategy, Factory, and more, without using a database.  
The application simulates music library management, playlist creation, device connections, and flexible playback strategies.

---

## 🚀 Features
- **Music Library**
  - Add songs with title, artist, and file path.
  - Retrieve and manage songs dynamically.
- **Playlists**
  - Create playlists and add songs to them.
  - Load playlists for playback.
- **Playback Strategies**
  - **Sequential Playback** → Play songs in order.
  - **Random Playback** → Shuffle songs for random play.
  - **Custom Queue** → Create custom order queues.
- **Device Connectivity**
  - Connect to different audio devices (e.g., Bluetooth, AUX, etc.).
- **Playback Controls**
  - Play, pause, resume songs.
  - Navigate next/previous tracks.

---

## 🛠️ Design Patterns Used
- **Singleton Pattern** → Ensures only one instance of `MusicPlayerApplication`.
- **Factory Pattern** → Handles audio device creation.
- **Strategy Pattern** → Supports multiple playback strategies (Sequential, Random, Custom Queue).
- **Facade Pattern** → Provides a simplified interface (`MusicPlayerApplication`) for complex operations.
- **Observer (Optional)** → Can be extended for notifications/events (e.g., song finished).
