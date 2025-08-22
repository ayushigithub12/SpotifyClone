🎵 Spotify Clone (LLD using Design Patterns)
A Java-based Spotify Clone built with a strong focus on Low-Level Design (LLD) principles and System Design Patterns.
This project demonstrates how design patterns can be applied to build a scalable and extensible music player application without using databases or external frameworks.


🚀 Features
🎶 Song Library Management
Add songs with title, artist, and file path.
Store and manage them in a central library.
📂 Playlist Management
Create playlists.
Add/remove songs from playlists.
Load a playlist for playback.
🎧 Device Connectivity
Connect different audio devices (e.g., Bluetooth, Wired).
▶️ Music Controls
Play, pause, resume a song.
Skip to the next track.
Play the previous track.
🔀 Playback Strategies (Strategy Pattern)
Sequential Playback – play songs in order.
Random Playback – shuffle songs randomly.
Custom Queue Playback – user-defined queue order.
🏗 Design Patterns Used
Singleton Pattern → MusicPlayerApplication (single instance).
Strategy Pattern → multiple playback strategies.
Factory Pattern → device connection handling.
Observer Pattern → notify devices on song playback (if implemented).
Command Pattern → play/pause/next/previous actions.
