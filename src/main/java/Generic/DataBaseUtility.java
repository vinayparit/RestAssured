package Generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	Statement state;

	/*
	 * Connecting to the database
	 */
	public void connectToDataBase() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet54", "root", "root");
	}

	/*
	 * Executing the query
	 */
	public void excuteQueryAndGetData(String Query, int colIndex, String expData) throws SQLException {

		state = con.createStatement();
		ResultSet result = state.executeQuery(Query);

		boolean flag = false;

		while (result.next()) {
			String actualData = result.getString(colIndex);
			if (actualData.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
			if (flag = true) {
				System.out.println("-----Data is Present----");
			} else {
				System.out.println("-----Data is Not Present----");
			}
		}
	}

	/*
	 * Closing Database connection
	 */

	public void disconnectDataBase() throws SQLException {
		con.close();
	}

}
