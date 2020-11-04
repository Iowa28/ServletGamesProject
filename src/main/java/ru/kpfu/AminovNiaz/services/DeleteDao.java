package ru.kpfu.AminovNiaz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class DeleteDao {
	
	public void deleteUser(int usersId) throws DbException{
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "DELETE FROM users WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, usersId);
			int rows = ps.executeUpdate();
			
			System.out.printf("%d rows added to users", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	public void delteUsersInfo(int usersInfoId) throws DbException{
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "DELETE FROM users_info WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, usersInfoId);
			int rows = ps.executeUpdate();
			
			System.out.printf("%d rows added to users_info", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
