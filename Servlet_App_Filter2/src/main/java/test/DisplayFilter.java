package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class DisplayFilter implements Filter
{
	public FilterConfig fc=null;
	public void init(FilterConfig fc)
	{
		this.fc=fc;
	}
	
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("=========== filterConfig=======");
	    pw.println("Filter Name :"+fc.getFilterName());
	    
	    Enumeration<String> e=fc.getInitParameterNames();
	    
	    while(e.hasMoreElements())
	    {
	    	String a=e.nextElement();
	    	pw.println("value of "+ a+"is "+fc.getInitParameter(a));
	    }
		
		
	}

}
