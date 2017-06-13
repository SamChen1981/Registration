package com.km.registeandlogin.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.km.pojo.t_user;
import com.km.registeandlogin.server.hz_GerenxinxiService;



/**
 * Servlet implementation class GerenxinxiServlet
 * 
 * 查询个人信息
 */
@WebServlet("/GerenxinxiServlet")
public class hz_GerenxinxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hz_GerenxinxiServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 患者查询个人信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hz_GerenxinxiService ams = new hz_GerenxinxiService();
		
		HttpSession session=request.getSession();	
		t_user usersession = (t_user) session.getAttribute("user_name");
		
		t_user user = ams.getall(usersession);
		request.setAttribute("user", user);
		request.getRequestDispatcher("gerenxinxi.jsp").forward(request, response);
	}

}
