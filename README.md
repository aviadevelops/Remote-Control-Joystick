# Remote-Control-Joystick
Remote Control Joystick Android App - Project for Advanced Programming 2

![image](https://user-images.githubusercontent.com/72354692/123560511-50ce2a00-d7ab-11eb-9a60-852c9722f298.png)

![image](https://user-images.githubusercontent.com/72354692/123560516-575ca180-d7ab-11eb-9e39-f7190bf831ba.png)


# Summary
The Remote Control Joystick Android application offers full remote control of a flight via the FlightGear simulator - Use a joystick to control the aileron - X axis, and the elevator - Y axis, while using the rudder and throttle seekbars to smoothly control the various aspects of the flight. connects to the FlightGear server at a given ip and port, start autopilot and have fun!

# App Features
- [x] Connect to any FlightGear server all across the world by entering the server's ip and port and the corresponding fields.
- [x] Control the plane's Aileron and Elevator by using the responding joystick.
- [x] Adjust the plane's Throttle and Rudder by moving the corresponding seekbars up and down or left and right respectivly.

### Folder Structure
```
├── Remote-Control-Joystick
│   ├── app - source code for the application
│   │   ├── src - source code for the application
│   │   │   ├── main - source code for the application
│   │   │   │   ├── java
|   |   |   |   |   ├── com
|   |   |   |   |   |  ├── example
|   |   |   |   |   |  |   ├── RemoteControlJoystick - The folder that contains the code for the app
|   |   |   |   |   |  |   |  ├── model
|   |   |   |   |   |  |   |  | ├──  FGPlayer.kt - The model of the app - all the calcuations and communicating with the FlightGear server as a part from the MVVM architecture
|   |   |   |   |   |  |   |  ├── view_model
|   |   |   |   |   |  |   |  | ├──  ViewModel.kt - The class the connects the main activity to the model as part from the MVVM architecture
|   |   |   |   |   |  |   |  ├── views
|   |   |   |   |   |  |   |  | ├──  Joystick.kt - The class that contains all the logic and drawing of out custom joystick
|   |   |   |   |   |  |   |  | ├──  MainActivity.kt - The class the is responsible to the logic of the design and and responsiveness of the view
│   │   │   │   │   |  |   └──└──
│   │   │   │   ├── res - 
│   │   │   │   │   ├── layout - xml files and configuration
│   │   │   │   │   │   ├── activity_main.xml - xml desgin of the MainActivity.kt view
│   │   │   │   │   ├── drawable - graphics related xml files - design for the seekbars
│   │   │   │   │   └── 
│   │   │   │   └── AndroidManifest.xml - settings for the android app
└── └── └── └──

```
### Required installations
* FlightGear version 2020.3.8 For windows 7 and above
* Android Studio version 4.2.1 and above

### Compiling and Running
1. Download the Remote-Control-Joystick repository.
2. Open the FlightSimulator app.
3. In the settings of the FlightSimulator app, insert the folowing line: "--telnet=socket,in,10,127.0.0.1,6400,tcp".
4. Run the code of the Remote-Control-Joystick-main project on an emulator using Android Studio.


### Additional Links
* [UML Diagram](UML.pdf)
* [App Walkthrough Video](https://youtu.be/GbNHsQEV4QA)


