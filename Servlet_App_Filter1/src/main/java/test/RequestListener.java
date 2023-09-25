package test;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener
{
	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("......Request inialized.....");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("Request destroyed....");
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent sre)
	{
		System.out.println("Attribute inialized ....");
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae)
	{
		System.out.println("Removed Attribute....!");
	}

}
