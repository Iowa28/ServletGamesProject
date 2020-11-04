package ru.kpfu.AminovNiaz.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.kpfu.AminovNiaz.entities.User;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.UserRepository;
import ru.kpfu.AminovNiaz.services.DeleteDao;
import ru.kpfu.AminovNiaz.services.ProfileDao;
import ru.kpfu.AminovNiaz.services.RegDao;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String country = req.getParameter("country");
		String city = req.getParameter("city");
		String date = req.getParameter("date");
		
		try {
			if (req.getParameter("edit") != null) {
				
				int usersId = Integer.parseInt(req.getParameter("id"));
				
				ProfileDao dao = new ProfileDao();
				int usersInfoId = new UserRepository().getUsersInfoId(usersId);
				
				dao.editName(usersId, name);
				dao.editEmail(usersId, email);
				dao.editPassword(usersId, password);
				dao.editCountry(usersInfoId, country);
				dao.editCity(usersInfoId, city);
				dao.editDate(usersInfoId, date);
				
			} else if (req.getParameter("delete") != null){
				
				int usersId = Integer.parseInt(req.getParameter("id"));
				int usersInfoId = new UserRepository().getUsersInfoId(usersId);
				
				DeleteDao dao = new DeleteDao();
				dao.deleteUser(usersId);
				dao.delteUsersInfo(usersInfoId);
				
			} else if (req.getParameter("add") != null) {
				
				
				if (!name.equals("") && !email.equals("") && !password.equals("") && !country.equals("") && !city.equals("") && !date.equals("")) {
					User user = new User(name, email, password, country, city, date);
					new RegDao().addUser(user);
				}
			}
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("users", getUserList());
		
		res.sendRedirect(getServletContext().getContextPath() + "/admin");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
		String email = (String) session.getAttribute("email");
		int admin = (Integer) session.getAttribute("admin");
		
		if (email == null || admin == 0) {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error_page.jsp").forward(req, res);
			return;
		}
		
		req.setAttribute("users", getUserList());
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(req, res);
		
	}
	
	private List<User> getUserList() {
		List<User> users = null;
		try {
			users = new UserRepository().getAll();
		} catch (DbException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
}
