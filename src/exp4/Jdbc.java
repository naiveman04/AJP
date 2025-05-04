package exp4;

// 1st Step: Load and import package.
import java.sql.*;

public class Jdbc {

	public static void main(String[] args) throws Exception {
		
		// 2nd Step: Load and register the driver.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//3rd Step: Establish the connection.
		String url = "jdbc:mysql://localhost:3306/student1";
		String uName = "root";
		String password = "vedant632952#";
		
		Connection con = DriverManager.getConnection(url, uName, password);
		System.out.println("Connection established successfully.");
				
		//4th Step: Create a statement.
		Statement st = con.createStatement();
		
		//5th Step: Execute the query.
		String query = "select * from StudentInfo";
		//1st method in "Statement" interface (pre-paid statement)
		ResultSet rs1 = st.executeQuery(query);
		//2nd method in "Statement" interface (post-paid statement)
//		ResultSet rs2 = st.updateQuery("select *  from StudentInfo where roll_no ");
		
		//6th Step: Process the result.
		while(rs1.next()) {
			System.out.println(rs1.getInt(1) + rs1.getString(2) + rs1.getString(3));
		}
		
		//7th Step: Close the connection.
		con.close();
		rs1.close();
	}
	
}
