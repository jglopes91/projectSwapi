# Star Wars Character Browser

![Android](https://img.shields.io/badge/Android-application-3DDC84?logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?logo=openjdk&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-networking-48A9A6)

An Android application that consumes the Star Wars API (SWAPI) and presents a paginated list of characters in a simple, native mobile interface.

The project demonstrates a clean separation between the UI, presentation logic, and remote data access using AndroidX, a ViewModel, RecyclerView, Retrofit, and Gson.

## Features

- Browse Star Wars characters returned by SWAPI.
- Navigate through paginated API results.
- Display character data in a RecyclerView.
- Fetch remote data asynchronously with Retrofit.
- Deserialize API responses with Gson.
- Preserve presentation state with a ViewModel.

## Technology stack

| Area | Technology |
| --- | --- |
| Platform | Android |
| Language | Java |
| UI | AndroidX, ConstraintLayout, RecyclerView |
| Networking | Retrofit 2 |
| Serialization | Gson |
| Build system | Gradle |

## Prerequisites

- Android Studio
- Android SDK with API level 29
- An emulator or physical Android device with internet access

## Running the application

1. Clone the repository:

   ```bash
   git clone https://github.com/jglopes91/projectSwapi.git
   cd projectSwapi
   ```

2. Open the project in Android Studio.
3. Allow Gradle to synchronize the project.
4. Connect an Android device or start an emulator.
5. Run the `app` configuration.

Alternatively, build the debug APK from the command line:

```bash
./gradlew assembleDebug
```

The generated APK is placed under `app/build/outputs/apk/`.

## Data source

The application requests character data from the SWAPI `people/` endpoint and supports the API's `page` query parameter for pagination.

> **Compatibility note:** The project currently references the historical `https://swapi.co/api/` base URL. If that endpoint is unavailable, update `RetrofitAPI.java` to a maintained SWAPI-compatible endpoint before building.

## Project structure

```text
app/src/main/java/
  .../activiy/                       Activities and ViewModel
  .../adapter/                       RecyclerView adapter
  .../data/                          Retrofit client and API models
app/src/main/res/                    Layouts, styles, and resources
app/build.gradle                     Android module configuration
```

## Author

João Gabriel Lopes — [@jglopes91](https://github.com/jglopes91)
