package db_sample;

import java.sql.*;

//import com.mysql.jdbc.Connection;
//import java.util.Collection;
public class Sample1 {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/wed";

		String user = "root";
		String password = "";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connnection Established");
			String query = "SELECT * FROM ex1sample";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while (resultset.next()) {
				int id = resultset.getInt("id");
			String name = resultset.getString("name");
				System.out.println("ID: " + id + ", Name: " + name);
			}

		} catch (ClassNotFoundException  e) {
			System.out.println("JDBC Driver not found!");
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
