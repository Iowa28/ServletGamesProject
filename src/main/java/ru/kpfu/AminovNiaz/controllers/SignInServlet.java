package ru.kpfu.AminovNiaz.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.GameRepository;
import ru.kpfu.AminovNiaz.repositories.UserInfoRepository;
import ru.kpfu.AminovNiaz.repositories.UserRepository;
import ru.kpfu.AminovNiaz.services.LoginDao;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    
	    LoginDao loginDao = new LoginDao();
	    
	    if(!email.equals("") && !password.equals("")){
	    	
	      try {
			if(loginDao.isRegistered(email, password)){
				HttpSession session = req.getSession();
				
				Init(email, session);
				
			    resp.sendRedirect(getServletContext().getContextPath() + "/welcome");
			    return;
			  }
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
	    }
	    
	    //req.setAttribute("email", req.getParameter("email"));
	    resp.sendRedirect(getServletContext().getContextPath() + "/signin");
	}
	
	
	
	private void Init(String email, HttpSession session) {
		UserRepository userRepository = new UserRepository();
		GameRepository gameRepository = new GameRepository();
		UserInfoRepository userInfoRepository = new UserInfoRepository();
		
		String name = null;
		int usersId = -1;
		int userInfoId = -1;
		int favoriteGameId = -1;
		String country = null;
		String city = null;
		String date = null;
		String game = null;
		
		
		try {
			name = userRepository.getUsername(email);
			usersId = userRepository.getUsersId(name, email);
			userInfoId = userRepository.getUsersInfoId(usersId);
			favoriteGameId = gameRepository.getGameId(usersId);
			
			country = userInfoRepository.getCountry(userInfoId);
			city = userInfoRepository.getCity(userInfoId);
			date = userInfoRepository.getDate(userInfoId);
			game = gameRepository.getGameName(favoriteGameId);
			
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		session.setAttribute("country", country);
		session.setAttribute("city", city);
		session.setAttribute("date", date);
		session.setAttribute("favoriteGame", game);
	}

}
