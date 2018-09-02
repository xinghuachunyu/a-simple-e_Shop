package goodsservlet;

import java.io.IOException;


import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goodsmodel.*;
import usersservlet.*;

/**
 * Servlet implementation class userdatailservlet
 */
@WebServlet("/userdatailservlet")
public class userdatailservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		 Writer writer = response.getWriter();
		    // �� �ͻ� �� ������ݡ�
		 writer.write("�������ĵ����");
		 String flag=request.getParameter("flag");
		 if(flag.equals("datail"))
		 {
		
			//String id=request.getParameter("id");
			String id=request.getParameter("id");
			try {
				goodsBeanCL gbc=new goodsBeanCL();
				goodsBean gb=gbc.showdatail(id);
				request.setAttribute("gb", gb);
				request.getRequestDispatcher("showdatail.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		 }
		 else if(flag.equals("dividepage"))
		 {
			String pageNow=(String)request.getParameter("pageNow");
			try {
				 goodsBeanCL gbc=new goodsBeanCL();
				 int pagecount=gbc.getPagecount();
				 request.setAttribute("pageNow", pageNow);
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		 }
		 else if(flag.equals("type"))
		 {
			 String goodstype=(String)request.getParameter("goodstype");
			 int pageNow=1;
			 String s_pageNow=request.getParameter("pageNow");
			 if(s_pageNow!=null)
			 {
				 pageNow=Integer.parseInt(s_pageNow);
			 }
			try {
				 goodsBeanCL gbc=new goodsBeanCL();
				 int pagecount=gbc.getgoodstypePagecount(goodstype);
				 ArrayList<goodsBean> al=gbc.typeGoodsByPage(pageNow,goodstype);
				 request.setAttribute("goodstype", goodstype);
				 request.setAttribute("pagecount",pagecount);
				 request.setAttribute("al", al);
				 request.getRequestDispatcher("goodstype.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.doGet(request, response);
	}

}
