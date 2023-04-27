package com.jsp.health.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.health.HealthDAO;
import com.jsp.health.HealthDTO;


@WebServlet("/Health1/MedicalDepartmentListController")
public class MedicalDepartmentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 private HealthDAO dao;

		public void init() {
			dao = HealthDAO.getInstance();
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department=request.getParameter("department");
		request.getSession().setAttribute("department", department);
		
	    HealthDAO dao = HealthDAO.getInstance();
	    ArrayList<HealthDTO> departmentArr = dao.HDepartmentList(department);
	    
	    request.setAttribute("departmentArr", departmentArr);
		request.getRequestDispatcher("medicalDepartmentList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
