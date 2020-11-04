package ru.kpfu.AminovNiaz.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.repositories.UserRepository;
import ru.kpfu.AminovNiaz.services.RegDao;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/reg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String pass1 = req.getParameter("password1");
		String pass2 = req.getParameter("password2");
		String checkbox = req.getParameter("checkbox");
		
		if (!name.equals("") && !mail.equals("")  && !pass1.equals("")  && !pass2.equals("")  && checkbox != null) {
			//WriteData(name, mail, pass1);
			
			RegDao dao = new RegDao();
			
			try {
				int usersInfoId = dao.addEmptyToUserInfo();
				dao.addUser(name, mail, pass1, usersInfoId);
			} catch (DbException e) {
				System.out.println(e.getMessage());
			}
			
			
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", mail);
			
			res.sendRedirect(getServletContext().getContextPath() + "/welcome");
		} else {
			
			res.sendRedirect(getServletContext().getContextPath() + "/reg");
		}
		
		
	}
	
	private void WriteData(String name, String mail, String password) {
		String[] header = {"name", "email", "password"};
		User user = new User(name, mail, password);
		
		FileWriter writer;
		try {
			writer = new FileWriter("C:\\Users\\ACER\\Desktop\\Other\\some.csv");
			ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
			
			csvBeanWriter.writeHeader(header);
			csvBeanWriter.write(user, header, getProcessors());
			csvBeanWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private CellProcessor[] getProcessors() {
        return new CellProcessor[]{
                new NotNull(),
                new NotNull(),
                new NotNull()
        };
    }
	
	private class User {
		private String name;
		private String email;
		private String password;
		
		public User(String name, String email, String password) {
			this.name = name;
			this.email = email;
			this.password = password;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
		public String toString() {
			return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
		}
	}

}
