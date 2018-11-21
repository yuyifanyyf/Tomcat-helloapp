package mypack;

import javax.servlet.http.*;
import java.io.*;

public class MyData implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable{
	private int data;
	public MyData() {}
	public MyData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("MyData is bound with a session.");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("MyData is unbound with a session.");
	}
	
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("A session is activate");
	}
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("A session will be passivate.");
	}
}
