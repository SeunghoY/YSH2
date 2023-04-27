package com.jsp.health.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.health.HealthDAO;
import com.jsp.health.HealthDTO;

//예외처리까지 완료 
@WebServlet("/Health1/HospitalInsertController")
public class HospitalInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	 private HealthDAO dao;
	    
	    public void init() {
	        // Initialize the DAO
	    	dao = HealthDAO.getInstance();
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Display the insert form
	        request.getRequestDispatcher("hospitalInsertForm.jsp").forward(request, response);
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Handle form submission
	    	request.setCharacterEncoding("UTF-8");
	        String hImg = request.getParameter("hImg");
	        String hName = request.getParameter("hName");
	        String hAddress = request.getParameter("hAddress");
	        String hPart = request.getParameter("hPart");
	        System.out.println("hImg:"+hImg);
	        if(hImg.equals("")) {
	        	String message = "이미지를 삽입해주세요";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("hospitalInsertForm.jsp").forward(request, response);
	            
	        }
	        else if(hName.equals("")) {
	        	String message = "이름을 입력해주세요";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("hospitalInsertForm.jsp").forward(request, response);
	            
	        }
	        else if(hAddress.equals("")) {
	        	String message = "주소를 입력해주세요";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("hospitalInsertForm.jsp").forward(request, response);
	            
	        }
	        else if(hPart.equals("")) {
	        	String message = "부위를 선택해주세요";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("hospitalInsertForm.jsp").forward(request, response);
	            
	        }
	        else {
	        	HealthDTO healthDTO = new HealthDTO();
		        healthDTO.sethImg(hImg);
		        healthDTO.sethName(hName);
		        healthDTO.sethAddress(hAddress);
		        healthDTO.sethPart(hPart);
		        
		        int result = dao.HospitalCreate(healthDTO);
		        
		        if (result == 1) {
		        	
		        	String message = "병원등록성공";
		        	request.setAttribute("message", message);
		            request.getRequestDispatcher("bodyparts.jsp").forward(request, response);
		        	
		        } else {
		        	String message = "병원등록실패";
		        	request.setAttribute("message", message);
		            request.getRequestDispatcher("bodyparts.jsp").forward(request, response);
		        }
	        }
	        
	    }
	}

