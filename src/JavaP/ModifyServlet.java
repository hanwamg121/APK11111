package JavaP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyServlet extends HttpServlet {
	private int intid;

	/**
	 * Constructor of the object.
	 */
	public ModifyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)//��
			throws ServletException, IOException {
		String id = request.getParameter("id");
		intid =Integer.parseInt(id);
		request.getRequestDispatcher("../modify.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ShowBean show=new ShowBean();
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		if(type=="0")type="娱乐";
		else if(type=="1")type="金融";
		else if(type=="2")type="教育";
		else type="旅行";
		String developer = request.getParameter("developer");
		show.change(request, response, name, type, developer, intid);
		response.sendRedirect("ShowServlet");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}