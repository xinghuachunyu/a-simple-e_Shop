package usersservlet;


import usersmodel.*;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goodsmodel.goodsBean;
import usersmodel.MyCatCL;

/**
 * Servlet implementation class MyCatServlet
 */
@WebServlet("/MyCatServlet")
public class MyCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
	    String goodsid=request.getParameter("goodsid");
	    String flag=request.getParameter("flag");
	   try {
		   MyCatCL mcl=(MyCatCL)request.getSession().getAttribute("mycat");
		    if(mcl==null)
		    {
		    	mcl=new MyCatCL();
		    	request.getSession().setAttribute("mycat", mcl);
		    }
		    if(flag.equals("buy"))
		    {
		    	 mcl.add(goodsid, "1");
		    }
		    else if(flag.equals("delet"))
		    {
		    	mcl.delet(goodsid);
		    }
		    else if(flag.equals("deletall"))
		    {
		    	mcl.deletall();
		    }
		    else if(flag.equals("updatenum"))
		    {
		    	String goodsID[]=request.getParameterValues("goodsid");
		    	String goodsNum[]=request.getParameterValues("goodsNum");
		    	for(int i=0;i<goodsID.length;i++)
		    	{
		    		mcl.update(goodsID[i], goodsNum[i]);
		    		System.out.println("id="+goodsID[i]+"newnum="+goodsNum[i]);
		    		//request.setAttribute("goodsid",goodsID[i]);
		    	}
		    	
		    }
		    else if(flag.equals("mycat"))
		    {
		    	
		    }
		    //ÏÔÊ¾¹ºÎï³µ
		    ArrayList<goodsBean> al=(ArrayList<goodsBean>)mcl.showTheCat();
		    request.setAttribute("goods", al);
		    request.getRequestDispatcher("MyCat.jsp").forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
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
