import java.sql.*;
public class Create {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded!!!");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			System.out.println("Connection Established!!!");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create table kishore(sno number(3),sname varchar2(15),gender varchar2(5),marks number(3))");
			System.out.println("table is created!!!");
			stmt.close();
			con.close();
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		catch(ClassNotFoundException cne) {
			System.out.println(cne);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
