package ru.kpfu.AminovNiaz.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.kpfu.AminovNiaz.entities.Category;
import ru.kpfu.AminovNiaz.entities.Game;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.GameRepository;
import ru.kpfu.AminovNiaz.repositories.CategoryRepository;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private final String ADMIN_EMAIL = "testing@mail.ru";
	private final int categoryTableSize = 3;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String search = req.getParameter("search");
		
		if (search != null) {
			
			GameRepository gameRepository = new GameRepository();
			
			try {
				int gameId = gameRepository.getGameId(search);
				
				Game searchedGame = gameRepository.getGameById(gameId);
				
				session.setAttribute("search", searchedGame);
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
			} catch (DbException e) {
				System.out.println(e.getMessage());
			}
			
			
			return;
		}
		
		for (Integer i = 1; i <= categoryTableSize; i++) {
			if (req.getParameter(i.toString()) != null) {
				
				session.setAttribute("games", getGameListById(i));
				break;
				
			} else if (i == categoryTableSize) {
				res.sendRedirect(getServletContext().getContextPath() + "/welcome");
				return;
			}
		}
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, res);
		//res.sendRedirect(getServletContext().getContextPath() + "/welcome");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		
		HttpSession session = req.getSession();
		
		
		String email = (String) session.getAttribute("email");
		
		if (email == null) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error_page.jsp").forward(req, res);
			return;
		} 
		
		if (isAdmin(email)) {
			session.setAttribute("admin", 1);
		} else {
			session.setAttribute("admin", 0);
		}
		
		session.setAttribute("games", getAllGameList());
		session.setAttribute("categories", getAllCategoriesList());
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(req, res);
		
	}
	
	private List<Game> getAllGameList() {
		List<Game> games = null; 
		try {
			games = new GameRepository().getAll();
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		return games;
	}
	
	private List<Game> getGameListById(int categoryId) {
		List<Game> games = null; 
		try {
			games = new GameRepository().getListById(categoryId);
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		return games;
	}
	
	private List<Category> getAllCategoriesList() {
		List<Category> categories = null; 
		try {
			categories = new CategoryRepository().getAll();
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		return categories;
	}
	
	private boolean isAdmin(String email) {
		if (email.equals(ADMIN_EMAIL)) {
			return true;
		}
		return false;
	}

}
