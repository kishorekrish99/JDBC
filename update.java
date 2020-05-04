import java.sql.*;
public class update {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("update kishore set sname='krish' where marks=100");
			System.out.println("Row Updated!!!");
			stmt.close();
			con.close();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		catch(ClassNotFoundException cne) {
			System.out.println(cne);
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
