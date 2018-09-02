package usersservlet;

import usersmodel.*;


//import goodstype.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCLservlet
 */
@WebServlet("/loginCLservlet")
public class loginCLservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCLservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		String flag=request.getParameter("flag");
		usersBeanCL ubc=(usersBeanCL)request.getSession().getAttribute("mydatail");
		if(ubc==null)
		{
		     ubc=new usersBeanCL();		    
		     request.getSession().setAttribute("mydatail", ubc);
		}
		try {
			//String u=new goods().saveWrong(request.getParameter("username"));
			//String p=new goods().saveWrong(request.getParameter("password"));
			if(flag.equals("orlogin"))
			{
				String un=(String)request.getSession().getAttribute("username");
				if(un==null)
				{
					System.out.println("un="+un);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if(flag.equals("login"))
			{
				if(ubc.logincl(u, p)==true)
				{
					System.out.println("用户名="+u);
					request.getSession().setAttribute("username", u);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					System.out.println("用户名密码为空");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else if(flag.equals("showuserdatail"))
			{
				String s_username=(String)request.getSession().getAttribute("username");
				if(s_username==null)
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
					usersBean ub=ubc.showuser(s_username);
					request.setAttribute("ub", ub);
					request.getRequestDispatcher("showMyCat.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
