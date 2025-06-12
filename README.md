This is a Kotlin Multiplatform project targeting Android, iOS. It is a sample app showcasing [firebase-ai-kmp](https://github.com/SeanChinJunKai/firebase-ai-kmp) 

## Key Setup
* **`:composeApp/build.gradle.kts`**:
  * Kotlin iOS targets
  * Firebase AI KMP SDK dependency
* **`iosApp/iosApp/iOSApp.swift`**:
  * Configures the FirebaseApp for iOS

## Running

1.  **Prerequisites**:
  * [Environment Setup](https://www.jetbrains.com/help/kotlin-multiplatform-dev/quickstart.html#set-up-the-environment)
2.  **Firebase Console Setup**:
  * Create a Firebase Project
  * Click on AI Logic in Project Shortcuts on the left navigation sidebar
  * Enable both Gemini Developer API and Vertex AI Gemini API
  * Create an iOS app with Apple bundle ID as `io.github.seanchinjunkai.firebase-ai-sample`
  * Download the config file `GoogleService-Info.plist` and place it in `iosApp/iosApp` directory
  * Create an Android app with Android package name as `io.github.seanchinjunkai.firebase_ai_sample.`
  * Download the config file `google-services.json` and place it in `composeApp` directory
> [!NOTE]
> You can change the Apple Bundle ID and Android Package Name to your own desired name
3. **Build**:
  * Open the project in Android Studio.
  * In the `iosApp` directory, run `pod install`.
  * Either open the generated `.xcworkspace` in Xcode and run on a simulator or device, or run the iosApp target in Android Studio with the run configuration set to use the generated `.xcworkspace`.
