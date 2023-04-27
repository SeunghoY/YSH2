package com.jsp.health.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.health.GuideDAO;
import com.jsp.health.GuideDTO;

//질문의 번호와 그번호에 해당하는 질문지 보내줌
@WebServlet("/Health1/GuideController")
public class GuideController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private GuideDAO dao;

		public void init() {
			dao = GuideDAO.getInstance();
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String part=request.getParameter("part");
		request.getSession().setAttribute("part", part);
		
		GuideDAO dao = GuideDAO.getInstance();
	    ArrayList<GuideDTO> GuideArr = dao.GuideListByhPart(part);
	    
	    request.setAttribute("GuideArr", GuideArr);
		request.getRequestDispatcher("guideByhPart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
