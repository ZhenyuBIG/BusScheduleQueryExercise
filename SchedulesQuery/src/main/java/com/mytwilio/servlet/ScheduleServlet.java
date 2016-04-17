package com.mytwilio.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;
import com.mytwilio.dao.SchedulesDAO;
import com.mytwilio.entity.Schedules;
import com.twilio.sdk.verbs.Message;

public class ScheduleServlet extends HttpServlet {

	private static final String DIRECTION = "Welcome to use Public Transport Query System: \n"+
    		"Send '1' to get our route list;\n"+
    		"Send '2' to get our stop list;\n"+
    		"Send '1+route' to get schedule for specific route(e.g. 13 is for route 3)\n"+
    		"Send '2+stop' to get schedule for specific stop(e.g. 2A is for stop A)";
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Get the message body which is sent from user
		String query = request.getParameter("Body");
		
		/*
		 * Depends on user's instruction, generate a corresponding response
		 * message: 
		 * If the user texted "1", reply which routes we have; 
		 * If the user texted "2", reply which stops we have; 
		 * If the user texted "1+route", reply the schedule of the route; 
		 * If the user texted "2+stop", reply the schedule of the stop; 
		 * If the user texted "route+stop+time", reply the specific schedule of this line; 
		 * If the user texted anything else, reply an error message and a direction.
		 */
		SchedulesDAO s = new SchedulesDAO();
		StringBuilder sb = new StringBuilder();
		ArrayList<Schedules> schedules = null;
		String body = null;
		
		if (query == null) {
			query = "No Query";
		}
		
		if (query.length() == 1) {
			if ("1".equals(query)) {
				sb.append("Our route list is: ");
				sb.append(s.getRoutes());
				body = sb.toString();
			} else if ("2".equals(query)) {
				sb.append("Our stop list is: ");
				sb.append(s.getStops());
				body = sb.toString();
			} else {
				body = "\nInvalid instruction!\n\n"+DIRECTION;
			}
		} else if (query.length() == 2) {
			if (((s.getRoutes().replace(" ", "")).contains(query.substring(1))) && "1".equals(query.substring(0, 1))) {
				sb.append("The schedule of Route " + query.substring(1) + ":\n");
				schedules = s.getSchedulesByRoute(query.substring(1));
				for (Schedules schedule : schedules) {
					String stop = schedule.getStop();
					String times = schedule.getTime();
					sb.append(stop + " - " + times + "\n");
				}
				body = sb.toString();
			} else if (((s.getStops().replace(" ", "")).contains(query.substring(1)))
					&& "2".equals(query.substring(0, 1))) {
				sb.append("The schedule of Stop " + query.substring(1) + ":\n");
				schedules = s.getSchedulesByStop(query.substring(1));
				for (Schedules schedule : schedules) {
					String route = schedule.getRoute();
					String times = schedule.getTime();
					sb.append(route + " - " + times + "\n");
				}
				body = sb.toString();
			} else {
				body = "\nInvalid instruction!\n\n"+DIRECTION;
			}
		} else {
			body = "\nInvalid instruction!\n\n"+DIRECTION;
		}

		// Create a TwiML response and add response.
		TwiMLResponse twiml = new TwiMLResponse();
		Message sms = new Message(body);
		try {
			twiml.append(sms);
		} catch (TwiMLException e) {
			e.printStackTrace();
		}

		response.setContentType("application/xml");
		response.getWriter().print(twiml.toXML());
		
		System.out.println(query);
		System.out.println(body);
	}

}
