package usersservlet;


import usersmodel.*;
import goodstype.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class usersCLservlet
 */
@WebServlet("/usersCLservlet")
public class usersCLservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersCLservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		try {
			String u=new goods().saveWrong(request.getParameter("username"));
			String tn=new goods().saveWrong(request.getParameter("truename"));
			String p=new goods().saveWrong(request.getParameter("password"));
			String eml=new goods().saveWrong(request.getParameter("email"));
			String tel=new goods().saveWrong(request.getParameter("phone"));
			String adr=new goods().saveWrong(request.getParameter("address"));
			String pst=new goods().saveWrong(request.getParameter("postcode"));
			String g=new goods().saveWrong(request.getParameter("grade"));
			usersBeanCL ubc=new usersBeanCL();
			if(ubc.register(u, tn, p, eml, tel, adr, pst, g))
			{
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
