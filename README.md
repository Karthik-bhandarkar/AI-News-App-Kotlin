<div align="center">

<!-- Animated Header -->
<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=200&section=header&text=NewsFlow&fontSize=80&fontColor=fff&animation=twinkling&fontAlignY=35&desc=AI-Powered%20Android%20News%20App&descAlignY=60&descSize=22"   width="100%"/>

<!-- Typing SVG -->
<a href="https://git.io/typing-svg">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=22&pause=1000&color=7F52FF&center=true&vCenter=true&width=600&lines=Stay+Informed.+Stay+Smart.;Real-Time+News+%2B+Generative+AI;Built+with+Kotlin+%26+Jetpack+Compose;MVVM+%7C+Retrofit+%7C+Coroutines+%7C+Flow" alt="Typing SVG" />
</a>

<br/><br/>

<!-- Tech Badges -->
<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
<img src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white"/>
<img src="https://img.shields.io/badge/MVVM-FF6F00?style=for-the-badge&logo=architecture&logoColor=white"/>
<img src="https://img.shields.io/badge/Generative%20AI-8E44AD?style=for-the-badge&logo=googlegemini&logoColor=white"/>

<br/><br/>

<!-- Repo Stats -->
<a href="https://github.com/Karthik-bhandarkar/AI-News-App-Kotlin/stargazers">
  <img src="https://img.shields.io/github/stars/Karthik-bhandarkar/AI-News-App-Kotlin?style=social" alt="Stars"/>
</a>
<a href="https://github.com/Karthik-bhandarkar/AI-News-App-Kotlin/network">
  <img src="https://img.shields.io/github/forks/Karthik-bhandarkar/AI-News-App-Kotlin?style=social" alt="Forks"/>
</a>
<a href="https://github.com/Karthik-bhandarkar/AI-News-App-Kotlin/issues">
  <img src="https://img.shields.io/github/issues/Karthik-bhandarkar/AI-News-App-Kotlin?color=red" alt="Issues"/>
</a>
<img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT"/>
<img src="https://img.shields.io/github/last-commit/Karthik-bhandarkar/AI-News-App-Kotlin?color=blueviolet" alt="Last Commit"/>

</div>

---

## 🌟 What is NewsFlow?

**NewsFlow** is a modern Android news application built with **Kotlin** and **Jetpack Compose** that delivers breaking headlines and in-depth articles — in real time. Designed with clean architecture principles (MVVM) and enhanced with **Generative AI capabilities**, NewsFlow is where mobile development meets intelligent content delivery.

> 🎓 Built as part of an internship in   **Android Development & Generative AI** — a hands-on exploration of cutting-edge Android tooling and AI integration.

---

## ✨ Features at a Glance

<div align="center">

| Feature | Description | Status |
|:---:|:---|:---:|
| 🔴 **Live Headlines** | Fetches the latest news from News API in real time | ✅ Live |
| 📄 **Article Detail View** | Deep-dive into full article content | ✅ Live |
| 🎨 **Compose-First UI** | 100% declarative UI with Jetpack Compose | ✅ Live |
| 📡 **Real-Time Data** | Seamless API integration with live JSON parsing | ✅ Live |
| 🧠 **AI Summaries** | Generative AI to summarize long-form articles | 🔜 Soon |
| 🔊 **Voice Narration** | AI-generated text-to-speech reading | 🔜 Soon |
| 🎯 **Personalized Feed** | Recommendations based on reading patterns | 🔜 Soon |
| 🌙 **Dark Mode** | System-aware dark theme support | 🔜 Soon |

</div>

---

## 🖼️ Screenshots

<div align="center">

| Home Feed | Article Detail | AI Summary |
|:---:|:---:|:---:|
| <img src="screenshots/home.png" width="200" alt="Home Feed"/> | <img src="screenshots/detail.png" width="200" alt="Article Detail"/> | *Coming Soon* |

> 📸 Place your screenshots in the `/screenshots` folder as `home.png` and `detail.png` to populate this section.

</div>

---

## 🏗️ Architecture

<div align="center">

NewsFlow follows the **MVVM (Model-View-ViewModel)** architecture for a clean, testable, and scalable codebase.

</div>

```
📦 com.example.newsflow
 ┣ 📂 data
 ┃ ┣ 📂 api          → Retrofit API service & endpoints
 ┃ ┣ 📂 model        → News data models / POJOs
 ┃ ┗ 📂 repository   → Single source of truth for data
 ┣ 📂 ui
 ┃ ┣ 📂 screens      → Compose screens (Home, Detail, etc.)
 ┃ ┣ 📂 components   → Reusable Composable widgets
 ┃ ┗ 📂 theme        → App theme, colors, typography
 ┣ 📂 viewmodel      → StateFlow-driven ViewModels
 ┗ 📜 MainActivity.kt
```

### Data Flow

```
┌──────────────┐     HTTP      ┌───────────────┐     Parse     ┌──────────────────┐
│   News API   │ ─────────────▶│   Retrofit    │ ─────────────▶│  Data Repository │
└──────────────┘               └───────────────┘               └────────┬─────────┘
                                                                         │ StateFlow
                                                                         ▼
                                                               ┌──────────────────┐
                                                               │    ViewModel     │
                                                               └────────┬─────────┘
                                                                        │ Reactive
                                                                        ▼
                                                               ┌──────────────────┐
                                                               │  Composable UI   │
                                                               └──────────────────┘
```

---

## 🛠️ Tech Stack

<div align="center">

### Core

| Technology | Purpose | Badge |
|:---|:---|:---:|
| **Kotlin** | Primary language | ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white) |
| **Jetpack Compose** | Declarative UI framework | ![Compose](https://img.shields.io/badge/Compose-4285F4?style=flat&logo=jetpackcompose&logoColor=white) |
| **MVVM** | Architecture pattern | ![MVVM](https://img.shields.io/badge/MVVM-FF6F00?style=flat&logoColor=white) |
| **Coroutines + Flow** | Async data handling | ![Kotlin](https://img.shields.io/badge/Coroutines-7F52FF?style=flat&logo=kotlin&logoColor=white) |

### Networking & Data

| Library | Purpose | Badge |
|:---|:---|:---:|
| **Retrofit 2** | HTTP client for API calls | ![Retrofit](https://img.shields.io/badge/Retrofit-48B983?style=flat&logoColor=white) |
| **OkHttp** | Request logging & interceptors | ![OkHttp](https://img.shields.io/badge/OkHttp-3E4348?style=flat&logoColor=white) |
| **Gson / Moshi** | JSON deserialization | ![JSON](https://img.shields.io/badge/Gson-FF6F00?style=flat&logoColor=white) |

### AI & Intelligence

| Technology | Purpose | Badge |
|:---|:---|:---:|
| **Google Gemini** | Article summarization *(planned)* | ![Gemini](https://img.shields.io/badge/Gemini-8E44AD?style=flat&logo=googlegemini&logoColor=white) |
| **News API** | Real-time news content source | ![NewsAPI](https://img.shields.io/badge/NewsAPI-FF0000?style=flat&logoColor=white) |

</div>

---

## ⚙️ Getting Started

### Prerequisites

- Android Studio **Hedgehog** or later
- Android SDK **24.0+**
- Kotlin **2.0+**
- A valid **[News API Key](https://newsapi.org/)**

### Installation

**1. Clone the Repository**
```bash
git clone https://github.com/Karthik-bhandarkar/AI-News-App-Kotlin.git
cd AI-News-App-Kotlin
```

**2. Add Your API Key**

Open (or create) `local.properties` in the project root:
```properties
NEWS_API_KEY=your_api_key_here
```

Or update the constants file directly:
```kotlin
const val API_KEY = "your_api_key_here"
const val BASE_URL = "https://newsapi.org/v2/"
```

**3. Build & Run**
```bash
# Open in Android Studio and click Run ▶
# Or via terminal:
./gradlew assembleDebug
```

---

## 🤖 Generative AI Integration — Roadmap

<div align="center">

```
 ┌─────────────────────────────────────────────────────────────────┐
 │                  🧠  AI Features Roadmap                        │
 ├────────────────────┬────────────────────────────────────────────┤
 │  Smart Summaries   │  TL;DR from full articles using Gemini     │
 │  Voice Narration   │  AI text-to-speech news playback           │
 │  Personalization   │  Feed recommendations via ML               │
 │  Semantic Search   │  Search by meaning, not just keywords      │
 └────────────────────┴────────────────────────────────────────────┘
```

</div>

---

## 🗺️ Future Enhancements

- [x] 🔴 Live news headlines from News API
- [x] 📄 Article detail view
- [x] 🏗️ MVVM + Compose architecture
- [ ] 🤖 AI-powered article summarization (Gemini API)
- [ ] 🔊 Text-to-speech news reading
- [ ] 🎯 Personalized recommendations engine
- [ ] 🌙 Dark mode support
- [ ] 🔖 Bookmark & save articles offline
- [ ] 🌍 Category & country-based filtering
- [ ] 🔔 Breaking news push notifications
- [ ] 📊 Reading progress tracking

---

## 📚 Learning Outcomes

This project was a hands-on journey through modern Android development:

| Skill | What I Learned |
|:---|:---|
| ✅ **API Integration** | Connecting to and parsing real-world REST APIs |
| ✅ **Jetpack Compose** | Building reactive, declarative UIs |
| ✅ **MVVM Pattern** | Separating concerns for maintainable code |
| ✅ **Coroutines & Flow** | Managing async data streams elegantly |
| ✅ **Generative AI Concepts** | Applying AI to real mobile use cases |

---

## 🤝 Contributing

Contributions are welcome! Here's how:

1. 🍴 Fork the repository
2. 🌿 Create a new branch: `git checkout -b feature/your-feature`
3. 💾 Commit your changes: `git commit -m 'Add some feature'`
4. 📤 Push to the branch: `git push origin feature/your-feature`
5. 🔃 Open a Pull Request

---

## 🙏 Acknowledgements

- [**News API**](https://newsapi.org/) — Real-time news data
- [**Jetpack Compose**](https://developer.android.com/jetpack/compose) — Google's modern UI toolkit
- [**Joel Kanyi**](https://github.com/joelkanyi) — Original project inspiration
- Internship mentors and peers for guidance throughout this project

---

## 📬 Contact

<div align="center">

**Karthik Bhandarkar**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Karthik-bhandarkar)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:karthik@example.com)

*Developed with ❤️ as part of an Android Development & Generative AI Internship*

</div>

---

<!-- Footer Wave -->
<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=100&section=footer" width="100%"/>

<div align="center">

⭐ **Found this helpful? Give it a star — it means a lot!** ⭐

![Profile Views](https://komarev.com/ghpvc/?username=Karthik-bhandarkar&color=blueviolet&style=flat-square&label=Profile+Views)

</div>
