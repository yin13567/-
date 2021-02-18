package com.fuhao55170725.examsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuhao55170725.examsys.jpa.dao.UserInfoDao;
import com.fuhao55170725.examsys.jpa.entity.Userinfo;

/**
 * Servlet implementation class TestRes
 */
@WebServlet("/TestRes")
public class TestRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserInfoDao uid; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=null;
		out = response.getWriter();
		Userinfo ui=new Userinfo();
		ui.setAge(20);
		ui.setId(2);
        uid.modifyUserInfo(ui);
        uid.deleteUserInfo(2);
		
        out.println("<html>");
        out.println("<head>");
         out.println("<title>数据库测试</title>");  
         out.println("</head>");
         out.println("<body>");           
         //List<Userinfo>items=td.findAllUserInfo();
         List<Userinfo>items=uid.findAllUserInfo();
         out.println("<table>");
         out.println("<tr>");
     	out.println("<td>");
     	out.println("id");
     	out.println("</td>");
     	out.println("<td>");
     	out.println("用户id");
     	out.println("</td>");
     	out.println("<td>");
     	out.println("用户密码");
     	out.println("</td>");
     	out.println("<td>");
     	out.println("用户年龄");
     	out.println("</td>");
     	out.println("<td>");
     	out.println("用户性别");
     	out.println("</td>");
     	out.println("<td>");
     	out.println("用户电话");
     	out.println("</td>");
     	out.println("</tr>");
         for(int i=0;i<items.size();i++) {
         	Userinfo tmp=items.get(i);
         	out.println("<tr>");
         	out.println("<td>");
         	out.println(tmp.getId());
         	out.println("</td>");
         	out.println("<td>");
         	out.println(tmp.getUserid());
         	out.println("</td>");
         	out.println("<td>");
         	out.println(tmp.getUserpasswd());
         	out.println("</td>");
         	out.println("<td>");
         	out.println(tmp.getAge());
         	out.println("</td>");
         	out.println("<td>");
         	out.println(tmp.getGender());
         	out.println("</td>");
         	out.println("<td>");
         	out.println(tmp.getPhone());
         	out.println("</td>");
         	out.println("</tr>");
         }
         out.println("</table>");
         
         out.println("</body>");
         out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
