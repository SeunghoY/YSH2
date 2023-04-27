package com.jsp.health.controllers;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.health.HealthDAO;


@WebServlet("/Health1/HospitaldeleteController")
public class HospitaldeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private HealthDAO dao;

	public void init() {
        // Initialize the DAO
		dao = HealthDAO.getInstance();
    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String Id = request.getParameter("hId");
	        int hId = Integer.parseInt(Id);

	        String part = (String) request.getSession().getAttribute("part");
	        String encodedPart = URLEncoder.encode(part, "UTF-8");

	       
	        int result = dao.Hospitaldelete(hId);
	        
	        if (result == 1) {
	        	System.out.println("Hospitaldelete successed");
	            response.sendRedirect("parts.jsp?part=" + encodedPart);
	        } else {
	        	System.out.println("Hospitaldelete failed");
	            response.sendRedirect("parts.jsp?part=" + encodedPart);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}


