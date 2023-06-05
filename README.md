# Senior Assessment: Section 3 - Mobile

This repository is created to showcase the authors _mobile automation testing abilities_.

This repo consist of a Java mobile automation framework, powered by appium. The only mobile operating system being used is **Android**.

Requirements:
 - Java Installed
 - Appium to be installed
 - Android Studio 
 - AVD Emulator device created
 
# Java mobile automation framework

After adding installing all the requirements, to run the automation tests on Windows, follow these steps:

1. Clone the repository to your local machine.
2. Set the capabilities.json to that of your Emulator device.
3. Start Appium server, by default the port should be 4723. If diffrent you can set that in the capabilities.json file.
4. Open a command prompt or PowerShell window.
5. Navigate to the root directory of the cloned repository.
6. Run the following command to execute the tests:
```
.\gradlew clean test
```
To run the automation tests on macOS, follow these steps:

1. Clone the repository to your local machine.
2. Set the capabilities.json in the root repo to that of the Android emulator.
3. Start Appium server, by default the port should be 4723. If diffrent you can set that in the capabilities.json file.
4. Open a terminal window.
5. Navigate to the root directory of the cloned repository.
6. Run the following command to execute the tests:
```
./gradlew clean test
```

After the build an "OUT" folder will be generated in the project root folder, it will be generated with a html file containing a breakdown of the test that 
were run.

# Note:
This framework was created and tested on a windows machine. MacOS is catered for but has not been tested upon.
