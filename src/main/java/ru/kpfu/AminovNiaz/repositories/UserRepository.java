package ru.kpfu.AminovNiaz.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.AminovNiaz.entities.User;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class UserRepository {
	
	public List<User> getAll() throws DbException{
		List<User> users = new ArrayList<User>();
		
		try {
			Connection connection = new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM users JOIN users_info on users.users_info_id = users_info.Id;";
			ResultSet result = connection.createStatement().executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("Id");
				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				String country = result.getString("country");
				String city = result.getString("city");
				String date = result.getString("date_of_birth");
				
				User user = new User(id, name, email, password, country, city, date);
				users.add(user);
			}
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return users;
	}
	
	public int getUsersInfoId(int id) throws DbException{
		int infoId = -1;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM users WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			infoId = result.getInt("users_info_id");
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return infoId;
	}
	
	public int getUsersId(String name, String email) throws DbException{
		int id = -1;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM users WHERE name = ? AND email = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			id = result.getInt("id");
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return id;
	}
	
	public String getUsername(String email) throws DbException{
		String name = "";
		try {
			Connection con =  new DbWrapper().getConnection();
			String sql = "SELECT * FROM users WHERE Email = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			name = rs.getString("Name");
			
		} catch (SQLException e) {
			throw new DbException();
		} 
		
		return name;
	}
}
