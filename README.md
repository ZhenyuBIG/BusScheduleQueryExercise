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

To run this app:
 1. schedules.sql is the sql script which can create a MySQL table and insert data;
 2. run com.mytwilio.servlet.ScheduleServlet.java on your web server and copy your public of this servlet into your twilio number's messaging request url.
 3. Text your twilio phone number according the rules I wrote above.
 
ps: 
 1. I'm working on more functions and for more complexed databases, planning to use Spring and Hibernate framework.
 2. My first Twilio Account is currently suspended due to a lack of funds :(
 3. Why I can't find a twilio number can both do voice and messaging work? I have to release and buy a new one and repeat this work. I think that's the main reason my account get suspended.


