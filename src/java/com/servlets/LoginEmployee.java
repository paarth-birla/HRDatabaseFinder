package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.models.EmployeeModel;


@WebServlet("/LoginEmployee")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		
		int jobid = Integer.parseInt(request.getParameter("jobid"));
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		System.out.println(jobid);
		System.out.println(empid);
		if(loginDAO.checkCredential(jobid, empid))
		{
			EmployeeModel employeeModel = loginDAO.getDetails(jobid, empid);
			String name = employeeModel.getFirstname() + " " + employeeModel.getLastname();
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("employeeDetails", employeeModel);
			response.sendRedirect("employee/home.jsp");
		}
		else {
			System.out.println("error");
			response.sendRedirect("login.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
