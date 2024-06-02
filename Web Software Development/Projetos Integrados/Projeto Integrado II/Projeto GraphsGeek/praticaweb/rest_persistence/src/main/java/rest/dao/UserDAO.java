package rest.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import rest.model.User;
import rest.util.DbUtil;

public class UserDAO {

	private static Connection connection = DbUtil.getConnection();

	public static User addUser(String username, String password, String email, String nomecompleto, String endereco,
			String cidade, String estado, String pais, InputStream input) {
		try {
			
			PreparedStatement pStmt = connection.prepareStatement("insert into users(username, password, nomecompleto, email, endereco, cidade, estado, pais) values (?, ?, ?, ?, ?, ? ,? ,?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			pStmt.setString(3, nomecompleto);
			pStmt.setString(4, email);
			pStmt.setString(5, endereco);
			pStmt.setString(6, cidade);
			pStmt.setString(7, estado);
			pStmt.setString(8, pais);
			
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				uploadFile(input, rs.getInt("id"));
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),  rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User updateUser(int id, String username, String password, String email, String nomecompleto, String endereco,
			String cidade, String estado, String pais, InputStream input) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update users set username=?, password=?, email=?, nomecompleto=?, endereco=?, cidade=?, estado=?, pais=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println("Deu rim!");
			pStmt.setInt(9, id);
			System.out.println("Deu rim!2");
			pStmt.setString(1, username);
			System.out.println("Deu rim!2");
			pStmt.setString(2, password);
			System.out.println("Deu rim!2");
			pStmt.setString(3, nomecompleto);
			pStmt.setString(4, email);
			pStmt.setString(5, endereco);
			pStmt.setString(6, cidade);
			pStmt.setString(7, estado);
			pStmt.setString(8, pais);
			System.out.println("Deu rim!42");
			pStmt.executeUpdate();
			System.out.println("Deu rim!2");
			ResultSet rs = pStmt.getGeneratedKeys();
			
			if (rs.next()) {
				System.out.println("Deu rim!3");
				if(input != null)
					uploadFile(input, rs.getInt("id"));
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),  rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deleteUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from users where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users order by id");
			while (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),  rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static User getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),  rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserByUsername(String username) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from users where username=?");
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),  rs.getString("nomecompleto"), rs.getString("email"),
						rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static void uploadFile(InputStream uploadedInputStream, int id) {
		try {
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("uploads.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			String folder = prop.getProperty("folder");
			String filePath = folder + id;
			saveFile(uploadedInputStream, filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
