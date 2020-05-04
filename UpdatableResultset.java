import java.sql.*;
import java.util.Scanner;
public class UpdatableResultset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet res=stmt.executeQuery("select * from kishore");
			Scanner sc=new Scanner(System.in);
			//res.moveToInsertRow();
			while(true) {
				System.out.println("Enter the Sno");
				int sno=sc.nextInt();
				System.out.println("Enter the name");
				sc.nextLine();
				String name=sc.nextLine();
				System.out.println("Enter the gender");
				//sc.nextLine();
				String gender=sc.nextLine();
				System.out.println("Enter the marks");
				int marks=sc.nextInt();
				res.updateInt(1,sno);
				res.updateString(2, name);
				res.updateString(3,gender);
				res.updateInt(4,marks);
				res.insertRow();
				System.out.println("Row has been updated!!!");
				System.out.println("Do you want to enter another record(Y/N)");
				String option=sc.next();
				if(option.equals('n')||option.equals('N')) {
					break;
				}
				
			}
			sc.close();
			res.close();
			stmt.close();
			con.close();
		}
		catch(SQLException se) {
			System.out.println(se);;
		}
		catch(ClassNotFoundException cne) {
			System.out.println(cne);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
