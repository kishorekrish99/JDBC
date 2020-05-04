import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BlobRetrive {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from blob");
			rs.next();
			Blob b=rs.getBlob(2);
			FileOutputStream fos=new FileOutputStream("krish.png");
			byte ab[]=b.getBytes(1,(int)b.length());
			fos.write(ab);
			fos.close();
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
