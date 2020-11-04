package ru.kpfu.AminovNiaz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class LoginDao {
	
	public boolean isRegistered(String email, String pass) throws DbException{
		try {
			Connection con = new DbWrapper().getConnection();
			
			String sql = "select * from users";
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("Email").equals(email) && rs.getString("Password").equals(pass)) {
					System.out.println("Authentication was successful");
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return false;
	}
	
	

}
