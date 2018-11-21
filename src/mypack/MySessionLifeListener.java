package mypack;

import javax.servlet.*;
import javax.servlet.http.*;

public class MySessionLifeListener implements HttpSessionListener, HttpSessionAttributeListener{
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("A new session is created.");
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("A new session is to be destroyed.");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event)
	{
		System.out.println("Attribute(" + event.getName() + "/" + event.getValue() + ") is added into a session");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Attribute(" + event.getName() + "/" + 
				event.getValue() + ") is revomed from a session.");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Attribute(" + event.getName() + "/" + 
				event.getValue() + ") is replaced is a session.");
	}
}
