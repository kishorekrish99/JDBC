import java.sql.*;
public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
	Statement stmt=con.createStatement();
	stmt.executeUpdate("insert into kishore values(535,'monica','fmale',99)");
	System.out.println("Values Inserted!!!");
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
