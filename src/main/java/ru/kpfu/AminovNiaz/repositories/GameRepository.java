package ru.kpfu.AminovNiaz.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.AminovNiaz.entities.Game;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class GameRepository {
	
	public List<Game> getAll() throws DbException {
		ArrayList<Game> games = new ArrayList<Game>();
		
		try {
			Connection connection = new DbWrapper().getConnection();
			
			String sql = "select * from game;";
			
			ResultSet result = connection.createStatement().executeQuery(sql);
			while (result.next()) {
				String name = result.getString("name");
				String annotation = result.getString("annotation");
				double raiting = result.getDouble("raiting");
				
				games.add(new Game(name, annotation, raiting));
			}
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return games;
	}
	
	public List<Game> getListById(int categoryId) throws DbException {
		ArrayList<Game> games = new ArrayList<Game>();
		
		try {
			Connection connection = new DbWrapper().getConnection();
			
			String sql = "select * from game WHERE category_id = ?;";
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, categoryId);
			
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				String name = result.getString("name");
				String annotation = result.getString("annotation");
				double raiting = result.getDouble("raiting");
				
				games.add(new Game(name, annotation, raiting));
			}
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return games;
	}
	
	public Game getGameById(int gameId) throws DbException {
		Game game = null;
		
		try {
			Connection connection = new DbWrapper().getConnection();
			
			String sql = "select * from game WHERE id = ?;";
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, gameId);
			
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				String name = result.getString("name");
				String annotation = result.getString("annotation");
				double raiting = result.getDouble("raiting");
				
				game = new Game(name, annotation, raiting);
			}
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return game;
	}
	
	public int getGameId(String name) throws DbException{
		int id = -1;
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM game WHERE name = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			id = result.getInt("id");
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return id;
	}
	
	public int getGameId(int usersId) throws DbException{
		int gameId = -1;
		
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM favorite_game WHERE users_id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, usersId);
			
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				gameId = result.getInt("game_id");
			}
			
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return gameId;
	}
	
	public String getGameName(int gameId) throws DbException{
		String gameName = "";
		
		try {
			Connection con =  new DbWrapper().getConnection();
			
			String sql = "SELECT * FROM game WHERE id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, gameId);
			
			ResultSet result = ps.executeQuery();
			result.next();
			
			gameName = result.getString("Name");
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return gameName;
	}
	
	public boolean checkGameInDb(String gameName) throws DbException {
		try {
			Connection con = new DbWrapper().getConnection();
			
			String sql = "select * from game";
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("Name").equals(gameName)) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return false;
	}
}
