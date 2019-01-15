

import java.util.*;

public class Logger {

	private static ArrayList REQUESTS, ERRORS;
	private static Date NOW;
	private static String HISTORY;
	
	public Logger() {
		
		REQUESTS = new ArrayList();
		ERRORS = new ArrayList();
		HISTORY = "";
		
	}
	
	public static void request(String client) {
		
		NOW = new Date();
		HISTORY += "\r\n"+ NOW + ": request from " + client;
	}
	
	public static void error(String client, String error) {
		
		HISTORY += "\r\n" + NOW + ": " + error + " while handling " + client;
		
	}
	public ArrayList getRequest() {
		
		return REQUESTS;
	}
	public ArrayList getErrors() {
		
		return ERRORS;
	}
	public static String getHistory() {
		
		return HISTORY;
	}





}
