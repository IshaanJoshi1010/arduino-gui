Arduino Java Serial GUI

This project provides a basic Java Swing GUI to control an Arduino board over serial communication. It uses the jSerialComm library for cross-platform serial port access.

Features

Turn Arduino signals on and off using GUI buttons
Control a servo motor (clockwise and counterclockwise)
Detect available serial ports using SerialTest.java
Simple, easy-to-use interface
Requirements

Java JDK 8 or higher
jSerialComm library (included as libs/jSerialComm-2.11.0.jar)
Arduino board with a compatible sketch for serial commands
Setup

Clone or download this repository.
Confirm libs/jSerialComm-2.11.0.jar is included. If missing or outdated, download from the jSerialComm website.
Connect your Arduino to your computer via USB.
Open main.java and update the serial port name to match your system (e.g., /dev/cu.usbmodemXXXX).
Use SerialTest.java to identify the correct port.
How to Run

Command Line
javac -cp libs/jSerialComm-2.11.0.jar:. ArduinoGUI.java main.java
java -cp libs/jSerialComm-2.11.0.jar:. main
IDE
Add libs/jSerialComm-2.11.0.jar to your project’s classpath
Run main.java as a Java application
File Descriptions

ArduinoGUI.java: Java Swing interface for user interaction
main.java: Entry point of the program
SerialTest.java: Lists available serial ports
libs/jSerialComm-2.11.0.jar: Serial communication library
testingCODE.txt: Example or test code for serial commands
Usage

Use "Signal On" and "Signal Off" to toggle digital signals
Use "Servo Clockwise" and "Servo Counter" to rotate a servo motor
Ensure your Arduino sketch interprets A, a, S, and s commands appropriately
Troubleshooting

If you get a "Failed to open port" error:
Check if the port name in main.java is correct
Ensure no other application is using the port
On Unix systems, check USB permissions
