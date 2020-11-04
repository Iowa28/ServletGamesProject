package ru.kpfu.AminovNiaz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.kpfu.AminovNiaz.entities.User;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class RegDao {
	
	public void addUser(String name, String email, String password, int usersInfoId) throws DbException{
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "INSERT INTO users(Name, Email, Password, Users_info_id) VALUES (?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setInt(4, usersInfoId);
			int rows = ps.executeUpdate();
			
			System.out.printf("%d rows added to users", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException();
		}
		
	}
	
	public void addUser(User user) throws DbException{
		int usersInfoId = addEmptyToUserInfo();
		
		addUser(user.getName(), user.getEmail(), user.getPassword(), usersInfoId);
		
		ProfileDao dao = new ProfileDao();
		dao.editCountry(usersInfoId, user.getCountry());
		dao.editCity(usersInfoId, user.getCity());
		dao.editDate(usersInfoId, user.getDate());
	}
	
	public int addEmptyToUserInfo() throws DbException{
		int id = -1;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "INSERT INTO users_info DEFAULT VALUES;";
			PreparedStatement ps = con.prepareStatement(sql);
			int rows = ps.executeUpdate();
			
			System.out.printf("%d rows added to users_info", rows);
			System.out.println();
			
			sql = "SELECT * FROM users_info ORDER BY Id DESC LIMIT 1;";
			ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			result.next();
			
			id = result.getInt("Id");
		} catch (SQLException e) {
			throw new DbException();
		}
		return id;
	}
	
	public void addUserInfoId(int userId, int usersInfoId) throws DbException{
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users SET users_info_id = ? WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, usersInfoId);
			ps.setInt(2, userId);
			int rows = ps.executeUpdate();
			
			System.out.printf("%d rows added to users", rows);
			System.out.println();
			
			System.out.println("User successfully added.");
		} catch (SQLException e) {
			throw new DbException();
		}
	}
}
