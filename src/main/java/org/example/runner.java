package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.eventLog;


public class runner {
    private static HttpURLConnection connection;
    private String UserID = "bb59b5de-29c0-44a1-9788-d3f03719a886";
    public boolean loggedIn;
    
    public void goodLogin(eventLog event) {
    	System.out.println("Good Login at " + event.timestamp);
    	loggedIn = event.systemState.loggedIn;
    }
    
    public void badLogin() {
    	System.out.println("Bad Login");
    	loggedIn = false;
    }
    
    public void Logout(eventLog event) {
    	System.out.println("The user logged out at " + event.timestamp);
    	loggedIn = false;
    }
    
    public void visitAlerts(eventLog event) {
    	System.out.println("The user viewed the alerts page at " + event.timestamp);
    	loggedIn = event.systemState.loggedIn;
    }
    
    public void alertCreated(eventLog event) {
    	System.out.println(event.systemState.alerts.size() + " alert(s) was created at " + event.timestamp); 
    	//not accurate since get only returns 5 alerts which are being shown
    	
    }
    
    public void deleteAlerts(eventLog event) {
    	System.out.println("The alerts were deleted at " + event.timestamp);
    }
    
    public boolean checkAlerts(eventLog event, boolean valid_properties) {
    	if (event.systemState.alerts.size() <= 5 && valid_properties == true) {
    		System.out.println("Alerts are in a good state");
    		return true;
    	} else {
    		System.out.println("Alerts are in a bad state");
    		return false;
    	}
    }
    
    
    public static void main(String[] args) {
    	
    	final runner r = new runner();
        List<eventLog> events = new ArrayList<>();
        int alerts;
        boolean valid_properties = false;
        String JSONresponse = getEventLogs();
        //String JSONresponse = "[{\"id\":\"bb63caec-8a3c-4ff0-8975-86615468dc10\",\"timestamp\":\"2023-01-01T13:31:32.0695652Z\",\"eventLogType\":1,\"userId\":\"bb59b5de-29c0-44a1-9788-d3f03719a886\",\"systemState\":{\"userId\":\"bb59b5de-29c0-44a1-9788-d3f03719a886\",\"loggedIn\":true,\"alerts\":[]}}]";
        events = new Gson().fromJson(JSONresponse, new TypeToken<List<eventLog>>(){}.getType()); //Json response to type token
        for (eventLog event : events) { //for each event that occured before the GET HTTP request was sent
        	if (event.eventLogType == 5 && event.systemState.loggedIn == true) { //if any of these events are true
        		r.goodLogin(event); 
        	} else if (event.eventLogType == 6) { //UserLoggedOut
        		r.Logout(event);
        	} else if (event.eventLogType == 7) { //UserViewedAlerts
        		r.visitAlerts(event);
        	} else if (event.eventLogType == 0) { //AlertCreated
        		r.alertCreated(event);
        	} else if (event.eventLogType == 1) { //AlertsDeleted
        		r.deleteAlerts(event);
        	}
        	//Alerts
        	if (event.systemState.alerts != null) {
        		for (alert alert : event.systemState.alerts) { //alerts of each event
        			//making sure the properties are not null
            		if (alert.description != null && alert.heading != null && alert.imageURL != null && alert.url != null) { //alert.priceInCents != 0..
            			valid_properties = true;
            		} else {
            			valid_properties = false;
            		}
            	}
            	r.checkAlerts(event, valid_properties);
        	} else {
        		System.out.println("No alerts available");
        	}
        }
        if (events.isEmpty()) { r.badLogin(); } //since the user didn't successfully login, there were no events generated
        //System.out.println("Number of alerts " + systemState.alerts.size());
        //System.out.println(JSONresponse);
    }

    /*
    function: HTTP GET request to get user's event logs
    returns: JSON file with all event logs
     */
    public static String getEventLogs() {
    	String UserID = "bb59b5de-29c0-44a1-9788-d3f03719a886";
        BufferedReader reader;
        String line;
        String responseJSON = null;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("https://api.marketalertum.com/EventsLog/" + UserID);
            connection = (HttpURLConnection) url.openConnection();

            //request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            //System.out.println(status);
            if (status > 200) { //if connection wasn't successful
                // response we get is an input stream -> buffered reader
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else { //if connection was successful
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            responseJSON = responseContent.toString();
            //System.out.println(responseJSON);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJSON;
    }
}