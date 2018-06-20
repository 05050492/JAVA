#include <LWiFi.h>
#include "MCS.h"

char _lwifi_ssid[] = "1234";
char _lwifi_pass[] = "33213321";
MCSDevice mcs("DlT5qbfN", "RDexjDoKHlEBsL63");
MCSDisplayInteger  Temp("05050492");

int trigPin = 12;                 
int echoPin = 11;                  
long duration, cm, inches;
 
void setup() {
  Serial.begin (9600);            
  pinMode(trigPin, OUTPUT);       
  pinMode(echoPin, INPUT);

  while (WiFi.begin(_lwifi_ssid, _lwifi_pass) != WL_CONNECTED) {
    delay(1000);
  }
  while (!mcs.connected()) {
    mcs.connect();
  }

  mcs.addChannel(Temp);
  
}
 
void loop()
{
  digitalWrite(trigPin, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin, HIGH);    
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  pinMode(echoPin, INPUT);             
  duration = pulseIn(echoPin, HIGH);   
 
  cm = (duration/2) / 29.1;         // 將時間換算成距離 cm

  Serial.print("Distance : ");  
  Serial.print(cm);
  Serial.print("cm");
  Serial.println();
  
  delay(250);

  while (!mcs.connected()) {
    mcs.connect();
    if (mcs.connected()) {
    }
  }
  mcs.process(1000);

  int sensor = analogRead(A0);
  
  Temp.set(cm);
  delay(200);
}
