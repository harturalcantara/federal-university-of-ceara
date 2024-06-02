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

import rest.model.PostFilmes;
import rest.util.DbUtil;

public class PostFilmesDAO {

	private static Connection connection = DbUtil.getConnection();

	public static PostFilmes addPostFilmes(int idautor,  String topico, String descricao, int idcategoria, InputStream input) {
		try {
			System.out.println("CA ESTOU! FIRME E FORTE");
			PreparedStatement pStmt = connection.prepareStatement("insert into postfilmes(idautor, topico, descricao, idcategoria) values (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, idautor);
			
			pStmt.setString(2, topico);
			pStmt.setString(3, descricao);
			pStmt.setInt(4, idcategoria);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				uploadFile(input, rs.getInt("id"));
				return new PostFilmes(rs.getInt("id"), rs.getInt("idautor"),  rs.getString("topico"), rs.getString("descricao"), rs.getInt("idcategoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static PostFilmes updateUser(int id, int idAutor, int idcategoria, String username, String password, InputStream input) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("update postfilmes set idAutor=?, username=?, password=? where id=?",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, idAutor);
			pStmt.setString(2, username);
			pStmt.setString(3, password);
			pStmt.setInt(4, id);
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				if(input != null)
					uploadFile(input, rs.getInt("id"));
				return new PostFilmes(rs.getInt("id"), rs.getInt("idAutor"), rs.getString("topico"), rs.getString("descricao"), rs.getInt("idcategoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void deletePostFilme(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("delete from postfilmes where id=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<PostFilmes> getAllPostFilme() {
		List<PostFilmes> users = new ArrayList<PostFilmes>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from postfilmes order by id");
			while (rs.next()) {
				PostFilmes user = new PostFilmes(rs.getInt("id"), rs.getInt("idAutor"), rs.getString("topico"), rs.getString("descricao"), rs.getInt("idcategoria"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public static PostFilmes getPostFilme(int id) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from postfilmes where id=?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new PostFilmes(rs.getInt("id"), rs.getInt("idAutor"),   rs.getString("topico"), rs.getString("descricao"),rs.getInt("idcategoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static PostFilmes getUserByUsername(String username) {
		try {
			PreparedStatement pStmt = connection.prepareStatement("select * from postfilmes where username=?");
			pStmt.setString(1, username);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new PostFilmes(rs.getInt("id"), rs.getInt("idAutor"), rs.getString("topico"), rs.getString("descricao"), rs.getInt("idcategoria"));
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
