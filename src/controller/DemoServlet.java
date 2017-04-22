package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import ws.*;
import ws.DemoStub;
import ws.DemoStub.Hello;
import ws.DemoStub.Sum;
import ws.DemoStub.SumResponse;
import ws.ProductWSStub.*;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			
			//Call for Demo Web service
			DemoStub ds = new DemoStub();
			ProductWSStub prod = new ProductWSStub();
			
			out.print(ds.hello(new Hello()).get_return());
			
			//Call for Sub Web service
			Sum s = new Sum();
			s.setA(5);
			s.setB(5);
			SumResponse res = ds.sum(s);
			out.print("<br>Sum: "+res.get_return());
			
			//Call for find web service
			Product p = prod.find(new Find()).get_return();
			out.print("<h3>Product Information</h3>");
			out.print("<br>Id: "+p.getId());
			out.print("<br>Name: "+p.getName());
			out.print("<br>Price: "+p.getPrice());
			
			//Call for findAll web Service
			out.print("<h3>List Product Information</h3>");
			for(Product pr : prod.findAll(new FindAll()).get_return())
			{
				out.print("<br>Id: "+pr.getId());
				out.print("<br>Name: "+pr.getName());
				out.print("<br>Price: "+pr.getPrice());
				out.print("<br>=======");
			}
			
			
			
			
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
