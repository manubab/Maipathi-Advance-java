package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/reg")
public class UserRegisterServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		UserBean ub=new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		
		int k=new UserRegisterDAO().insert(ub);
		
		if(k>0) {
			pw.println("User Registeration successfully....!");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
			
		}
		
	}

}
