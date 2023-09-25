package test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements  HttpSessionListener ,HttpSessionAttributeListener                          
{
	@Override
	public void sessionCreated(HttpSessionEvent hse)
	{
		System.out.println("Session Created.....");
	}
	public void sessionDestroyed(HttpSessionEvent hse)
	{
		System.out.println("session expaired....");
	}
	public void attributeAdded(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attribute Addedd to Session....");
	}
	public void attributeRemoved(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attributr removed from session....!");
	}

}
