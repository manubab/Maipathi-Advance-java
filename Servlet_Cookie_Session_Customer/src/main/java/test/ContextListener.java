package test;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ContextListener implements ServletContextAttributeListener, ServletContextListener 
{
	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		
		System.out.println("Context initialized Successfully");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		System.out.println("....Context destroyed....");
		
	}
	
	public void attributeAdded(ServletContextAttributeEvent scae)
	{
		System.out.println("Attribute Added to context");
	}
	public void attributeRemoved(ServletContextAttributeEvent sce)
	{
		System.out.println("Attribute removed to Context");
	}

}
