package com.jsp.health.controllers;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.health.HealthDAO;
import com.jsp.health.HealthDTO;

//미완
@WebServlet("/Health1/HospitalUpdateController")
public class HospitalUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private HealthDAO dao;
	
	public void init() throws ServletException {
		dao = HealthDAO.getInstance();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("hospitalUpdateForm.jsp").forward(request, response);//여기서 getParameter 로 parts.jsp 에서 넘겨받은값 안받아도,
		//hospitalUpdateForm 으로 넘어가짐
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("hId");
		int hId=Integer.parseInt(id);
        String hImg = request.getParameter("hImg");
        String hName = request.getParameter("hName");
        String hAddress = request.getParameter("hAddress");
        String hPart = request.getParameter("hPart");
        
        if(hImg.equals("")) {
        	String message = "바꿀이미지명을 입력해주세요";
        	request.setAttribute("message", message);
            request.getRequestDispatcher("hospitalUpdateForm.jsp").forward(request, response);
            
        }
        else if(hName.equals("")) {
        	String message = "바꿀 이름을 입력해주세요";
        	request.setAttribute("message", message);
            request.getRequestDispatcher("hospitalUpdateForm.jsp").forward(request, response);
            
        }
        else if(hAddress.equals("")) {
        	String message = "바꿀 주소를 입력해주세요";
        	request.setAttribute("message", message);
            request.getRequestDispatcher("hospitalUpdateForm.jsp").forward(request, response);
            
        }
        else if(hPart.equals("")) {
        	String message = "바꿀 부위를 선택해주세요";
        	request.setAttribute("message", message);
            request.getRequestDispatcher("hospitalUpdateForm.jsp").forward(request, response);
            
        }
        else {
        
        
        
        
	        HealthDTO healthDTO = new HealthDTO();
	        healthDTO.sethId(hId);
	        healthDTO.sethPart(hPart);
	        healthDTO.sethImg(hImg);
	        healthDTO.sethName(hName);
	        healthDTO.sethAddress(hAddress);
	       
	        String encodedhPart = URLEncoder.encode(hPart, "UTF-8");
	        int result = dao.HospitalUpdate(healthDTO);
	        
	        if (result == 1) {
	        	
	        	String message = "병원수정성공";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("parts.jsp?part="+encodedhPart).forward(request, response);
	        	
	        } else {
	        	String message = "병원수정실패";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("parts.jsp?part="+encodedhPart).forward(request, response);
	        }
		}
	}

}
