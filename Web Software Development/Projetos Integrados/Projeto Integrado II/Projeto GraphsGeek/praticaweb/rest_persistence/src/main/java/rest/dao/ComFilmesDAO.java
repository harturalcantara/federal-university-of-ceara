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

import rest.model.ComFilmes;
import rest.util.DbUtil;

public class ComFilmesDAO {

	private static Connection connection = DbUtil.getConnection();

	public static ComFilmes addComFilmes(int idautor, int idtopico, String texto, InputStream input) {
		try {
			System.out.println("CA ESTOU! FIRME E FORTE");
			PreparedStatement pStmt = connection.prepareStatement("insert into comfilmes(idautor, idtopico, texto) values (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, idautor);
			pStmt.setInt(2, idtopico);
			pStmt.setString(3, texto);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				uploadFile(input, rs.getInt("id"));
				return new ComFilmes(rs.getInt("id"), rs.getInt("idautor"), rs.getInt("idtopico"), rs.getString("texto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static ComFilmes updateUser(int id, int idautor, int idtopico, String texto, InputStream input) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update comfilmes set idautor=?, idtopico=?, password=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, idautor);
			pStmt.setInt(2, idtopico);
			pStmt.setString(3, texto);
			pStmt.setInt(4, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				if(input != null)
					uploadFile(input, rs.getInt("id"));
				return new ComFilmes(rs.getInt("id"),rs.getInt("idautor"), rs.getInt("idtopico"), rs.getString("texto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deletePostFilme(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from comfilmes where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<ComFilmes> getAllUsers() {
		List<ComFilmes> users = new ArrayList<ComFilmes>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from comfilmes order by id");
			while (rs.next()) {
				ComFilmes user = new ComFilmes(rs.getInt("id"),rs.getInt("idautor"), rs.getInt("idtopico"), rs.getString("texto"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static ComFilmes getUser(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from comfilmes where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new ComFilmes(rs.getInt("id"),rs.getInt("idautor"), rs.getInt("idtopico"), rs.getString("texto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ComFilmes getUserByUsername(String username) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from comfilmes where username=?");
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new ComFilmes(rs.getInt("id"),rs.getInt("idautor"), rs.getInt("idtopico"), rs.getString("texto"));
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
