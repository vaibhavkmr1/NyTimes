# NyTimes
This Application shows list of most popular articles in NY Times and their detail.

## Building the sample App 
Clone the repo : https://github.com/vaibhavkmr1/NyTimes.git

Building the sample then depends on your build tools.

## Android Studio (Recommended)
(These instructions were tested with Android Studio version 3.4.2,3.5.2)

Open Android Studio and select File->Open... or from the Android Launcher select Import project (Eclipse ADT, Gradle, etc.) and navigate to the root directory of your project.
Select the directory or drill in and select the file build.gradle in the cloned repo.
Click 'OK' to open the the project in Android Studio.
A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

## Gradle (command line)

Build the APK: ./gradlew build

## Eclipse
Download the latest Android SDK from Maven Central
Note: We publish both an AAR and a JAR; you may use whichever is more convenient based on your infrastructure and needs.

## Running the Sample App
Connect an Android device to your development machine.

## Android Studio
Select Run -> Run 'app' (or Debug 'app') from the menu bar
Select the device you wish to run the app on and click 'OK'
