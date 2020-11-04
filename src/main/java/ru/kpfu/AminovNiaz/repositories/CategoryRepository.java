package ru.kpfu.AminovNiaz.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.kpfu.AminovNiaz.entities.Category;
import ru.kpfu.AminovNiaz.exceptions.DbException;
import ru.kpfu.AminovNiaz.utils.DbWrapper;

public class CategoryRepository {

	public List<Category> getAll() throws DbException{
		List<Category> categories = new ArrayList<Category>();
		
		try {
			Connection connection = new DbWrapper().getConnection();
			
			String sql = "select * from category;";
			
			ResultSet result = connection.createStatement().executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				
				categories.add(new Category(id, name));
			}
		} catch (SQLException e) {
			throw new DbException();
		}
		
		return categories;
	}
}
