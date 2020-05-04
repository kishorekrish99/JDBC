import java.sql.*;
public class Batch {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			Statement stmt=con.createStatement();
			stmt.addBatch("insert into kishore values(565,'manideep','male',99)");
			stmt.addBatch("insert into kishore values(466,'deavnder','male',98)");
			stmt.executeBatch();
			System.out.println("Batch of insertion has been executed!!!");
			con.setAutoCommit(true);
			stmt.close();
			con.close();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		catch(ClassNotFoundException ce) {
			System.out.println(ce);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
