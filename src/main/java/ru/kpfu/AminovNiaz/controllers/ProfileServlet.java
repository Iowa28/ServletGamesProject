package ru.kpfu.AminovNiaz.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.GameRepository;
import ru.kpfu.AminovNiaz.repositories.UserRepository;
import ru.kpfu.AminovNiaz.services.ProfileDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			
			HttpSession session = req.getSession();
			
			String name = (String) session.getAttribute("name");
			String email = (String) session.getAttribute("email");
			String country = (String) session.getAttribute("country");
			String city = (String) session.getAttribute("city");
			String date = (String) session.getAttribute("date");
			
			String newName = req.getParameter("name");
			String newEmail = req.getParameter("email");
			String newCountry = req.getParameter("country");
			String newCity = req.getParameter("city");
			String newDate = req.getParameter("date");
			String gameToAdd = req.getParameter("game").toLowerCase();
			
			//System.out.println(name + " to " + newName);
			//System.out.println(email + " to " + newEmail);
			
			ProfileDao dao = new ProfileDao();
			GameRepository gameRepository = new GameRepository();
			UserRepository userRepository = new UserRepository();
			
			try {
				int usersId = userRepository.getUsersId(name, email);
				int usersInfoId = userRepository.getUsersInfoId(usersId);
				int gameId = gameRepository.getGameId(gameToAdd);
				
				if (usersId != -1 && !name.equals(newName)) {
					boolean changedName = dao.editName(usersId, newName);
					if (changedName) {
						session.setAttribute("name", newName);
					}
				}
				
				if (usersId != -1 && !email.equals(newEmail)) {
					boolean changedEmail = dao.editEmail(usersId, newEmail);
					if (changedEmail) {
						session.setAttribute("email", newEmail);
					}
				}
				
				if (usersInfoId != -1 && (country == null || !country.equals(newCountry))) {
					boolean changedCountry = dao.editCountry(usersInfoId, newCountry);
					if (changedCountry) {
						session.setAttribute("country", newCountry);
					}
				}
				
				if (usersInfoId != -1 && (city == null || !city.equals(newCity))) {
					boolean changedCity = dao.editCity(usersInfoId, newCity);
					if (changedCity) {
						session.setAttribute("city", newCity);
					}
				}
				
				if (usersInfoId != -1 && (date == null || !date.equals(newDate))) {
					boolean changedDate = dao.editDate(usersInfoId, newDate);
					if (changedDate) {
						session.setAttribute("date", newDate);
					}
				}
				
				if (gameId != -1 && usersId != -1) {
					boolean addedGame = dao.addFGame(gameId, usersId);
					if (addedGame) {
						session.setAttribute("favoriteGame", gameToAdd);
					}
				}
			} catch (DbException e) {
				System.out.println(e.getMessage());
			}
			
			res.sendRedirect(getServletContext().getContextPath() + "/profile");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession();
			
			String email = (String) session.getAttribute("email");
			
			if (email == null) {
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/error_page.jsp").forward(req, res);
				return;
			}
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, res);
		} catch (ServletException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
