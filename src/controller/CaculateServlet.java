package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ws.CalculateStub;
import ws.CalculateStub.Cal;
import ws.CalculateStub.CalResponse;

/**
 * Servlet implementation class CaculateServlet
 */
public class CaculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalculateStub ca = new CalculateStub();
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		System.out.println("the id is=="+id);
		int i = Integer.parseInt(id);
		
		Cal c = new Cal();
		c.setA(8);
		c.setB(4);
		c.setV(i);
		CalResponse res = ca.cal(c);
		System.out.println("the response value is=="+res.get_return());
		out.write("<br>Result is :"+res.get_return());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
