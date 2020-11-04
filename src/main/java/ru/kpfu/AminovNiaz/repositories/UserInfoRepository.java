package ru.kpfu.AminovNiaz.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class UserInfoRepository {
	
	public String getCountry(int id) throws DbException{
		String country = "";
		
		try {
			Connection con =  new DbWrapper().getConnection();
			String sql = "SELECT * FROM users_info WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			country = rs.getString("Country");
			
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return country;
	}
	
	public String getCity(int id) throws DbException{
		String city = "";
		
		try {
			Connection con =  new DbWrapper().getConnection();
			String sql = "SELECT * FROM users_info WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			city = rs.getString("City");
			
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return city;
	}
	
	public String getDate(int id) throws DbException{
		String date = "";
		
		try {
			Connection con =  new DbWrapper().getConnection();
			String sql = "SELECT * FROM users_info WHERE id = ?;";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			date = rs.getString("date_of_birth");
			
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return date;
	}
}
