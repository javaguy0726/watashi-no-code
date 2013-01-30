package test.com.sitename.selenium.base;


public class SeleniumUtilAbstract {

	protected static final long DEFAULT_TIMEOUT = 5000; // 5 seconds
	protected static final long DEFAULT_WAIT = 1000; // 1 second
	
	protected static String userbrowser = System.getProperty("test.browser");
	protected static String host = System.getProperty("test.host");
	protected static String userid = System.getProperty("test.userid");
	protected static String userpwd = System.getProperty("test.userpwd");
	
}

