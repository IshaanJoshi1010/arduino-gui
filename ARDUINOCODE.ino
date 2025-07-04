#include <Servo.h>


Servo myServo;


const int ledPin = 13;
int currentAngle = 0; 

void setup() {

  Serial.begin(9600);
  
 
  pinMode(ledPin, OUTPUT);
  
  
  myServo.attach(9);  
  myServo.write(currentAngle); 
}

void loop() {
  
  if (Serial.available() > 0) {
    char command = Serial.read(); 
    
    if (command == 'A') {
      
      digitalWrite(ledPin, HIGH);
    } 
    else if (command == 'a') {
      
      digitalWrite(ledPin, LOW);
    } 
    else if (command == 'S') {
      
      if (currentAngle < 180) { 
        currentAngle+=50;
        myServo.write(currentAngle);
      }
    } 
    else if (command == 's') {
      
      if (currentAngle > 0) { 
        currentAngle-=50;
        myServo.write(currentAngle);
      }
    }
  }
}
