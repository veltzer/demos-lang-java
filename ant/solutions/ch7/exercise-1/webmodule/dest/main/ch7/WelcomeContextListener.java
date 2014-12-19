package main.ch7;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WelcomeContextListener implements ServletContextListener {

	/**
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}
	/**
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Welcome");

	}
}
