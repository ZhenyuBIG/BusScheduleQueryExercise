This is a Java app with Twilio API and using maven to manage. 
The purpose of this app is to get the bus schedule by sending a sms to a specific Twilio phone number. Depends on user's instruction, generate a corresponding response message and text back to the user:
  1. If the user text "1", reply which routes we have; 
  2. If the user text "2", reply which stops we have; 
  3. If the user text "1+route", reply the schedule of this route(e.g. 13 is for route 3); 
  4. If the user text "2+stop", reply the schedule of this stop(e.g. 2A is for stop A); 
  5. If the user text "route+stop+time", reply the specific schedule of this line(e.g. 3D1000 is for route 3 arrive at stop D at 10:00); 
  6. If the user text anything else, reply an error message and a direction.
	
To make this app work, you need: 
  1. Have a Java development environment with a Web server capable of running Java servlets;
  2. Have dependencis include twilio-java-sdk(http://search.maven.org/#browse%7C-1416163511) and mysql-connector-java( if you do not use maven or grandle, add these jars manually)
  3. Have a Twilio account and a Twilio phone number which can send and receive sms;
  4. Have a web server exposed on the Internet;
  5. Have a MySQL database running on your computer;

