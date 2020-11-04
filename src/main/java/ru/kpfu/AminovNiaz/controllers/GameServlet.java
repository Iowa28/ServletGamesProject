package ru.kpfu.AminovNiaz.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.GameRepository;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	
	private String game = "tetris";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
		String email = (String) session.getAttribute("email");
		
		if (email == null) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error_page.jsp").forward(req, res);
			return;
		}
		
		Cookie[] cookies = req.getCookies();
		
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("game")) {
				game = cookie.getValue();
			}
		}
		
		try {
			if (!new GameRepository().checkGameInDb(game)) {
				System.out.println("Error! DB doesn't have this game.");
				return;
			}
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + game + ".jsp").forward(req, res);
	}
}
