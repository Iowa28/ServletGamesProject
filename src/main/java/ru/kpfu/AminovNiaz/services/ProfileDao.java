package ru.kpfu.AminovNiaz.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class ProfileDao {
	
	public boolean editName(int id, String newName) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users SET name = ? WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, id);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean editEmail(int id, String newEmail) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users SET email = ? WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newEmail);
			ps.setInt(2, id);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean editPassword(int id, String newPassword) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users SET password = ? WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, id);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean editCountry(int usersInfoId, String newCountry) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users_info SET country = ? WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newCountry);
			ps.setInt(2, usersInfoId);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users_info", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean editCity(int usersInfoId, String newCity) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users_info SET city = ? WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newCity);
			ps.setInt(2, usersInfoId);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users_info", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean editDate(int usersInfoId, String newDate) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "UPDATE users_info SET date_of_birth = ? WHERE Id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newDate);
			ps.setInt(2, usersInfoId);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to users_info", rows);
			System.out.println();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}
	
	public boolean addFGame(int gameId, int usersId) throws DbException{
		int rows = 0;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			// Getting game's Id
			String sql = "INSERT INTO favorite_game(game_id, users_id) VALUES (?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, gameId);
			ps.setInt(2, usersId);
			
			rows = ps.executeUpdate();

			System.out.printf("%d rows added to favorite_game", rows);
			System.out.println();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		if (rows > 0) {
			return true;
		}
		return false;
	}	
}
