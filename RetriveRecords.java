import java.sql.*;
public class RetriveRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select * from kishore");
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getInt(4));
			}
			res.close();
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
