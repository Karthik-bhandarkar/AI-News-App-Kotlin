# 📰 NewsFlow

<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&height=220&text=NewsFlow&fontSize=60&color=gradient" />
</p>

<p align="center">
  <b>A modern Android News App built with Kotlin, Jetpack Compose, MVVM, Retrofit, and Coroutines.</b>
</p>

---

## ✨ Features

- 📰 Real-time news from NewsAPI
- 📱 Modern UI with Jetpack Compose
- 🏗️ MVVM Architecture
- 🔄 Coroutines & StateFlow
- 🌐 Retrofit networking
- 📖 Article detail screen
- 🔍 Clean and scalable codebase
- 🤖 Ready for future Gemini AI integration

---

## 📸 Screenshots

> Add screenshots inside a `screenshots/` folder.

| Home | Details |
|------|---------|
| ![](screenshots/home.png) | ![](screenshots/detail.png) |

---

## 🏗 Architecture

```
UI (Compose)
      │
ViewModel
      │
Repository
      │
Retrofit
      │
NewsAPI
```

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- MVVM
- Retrofit
- OkHttp
- Gson
- Coroutines
- StateFlow
- Material 3

---

## 📂 Project Structure

```
app/
 ├── data/
 │   ├── api/
 │   ├── model/
 │   └── repository/
 ├── ui/
 ├── viewmodel/
 ├── utils/
 └── MainActivity.kt
```

---

## 🚀 Getting Started

### Clone

```bash
git clone https://github.com/Karthik-bhandarkar/AI-News-App-Kotlin.git
```

### API Key

Create `local.properties`

```properties
NEWS_API_KEY=YOUR_API_KEY
```

### Run

```bash
./gradlew installDebug
```

---

## 📋 Roadmap

- [x] Live News
- [x] Article Details
- [x] MVVM
- [ ] Bookmark Articles
- [ ] Dark Mode
- [ ] Search
- [ ] Gemini AI Summaries
- [ ] Offline Reading
- [ ] Push Notifications

---

## 🤝 Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Open a Pull Request.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Karthik Bhandarkar**

- GitHub: https://github.com/Karthik-bhandarkar
- LinkedIn: https://linkedin.com/in/karthik-bhandarkar

---

⭐ If you like this project, consider giving it a star!
