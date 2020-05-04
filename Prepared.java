import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Prepared {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			PreparedStatement pst=con.prepareStatement("insert into kishore values (?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enetr the sno");
			int sno=sc.nextInt();
			System.out.println("Enter the sname");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter the gender");
			String gender=sc.nextLine();
			System.out.println("Enter the marks");
			int marks=sc.nextInt();
			pst.setInt(1,sno);
			pst.setString(2,name);
			pst.setString(3, gender);
			pst.setInt(4, marks);
			pst.executeUpdate();
			System.out.println("records Executed!!!!");
			pst.close();
			sc.close();
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
