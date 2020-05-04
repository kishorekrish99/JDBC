import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class BlobInsert {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","system");
			File f=new File("C:\\Users\\uppul\\Downloads\\bird.png");
			FileInputStream fis=new FileInputStream(f);
			PreparedStatement pst=con.prepareStatement("insert into blob values (?,?)");
			pst.setInt(1,321);
			pst.setBinaryStream(2,fis,(int)f.length());
			pst.executeUpdate();
			System.out.println("File Uploaded!!!");
			pst.close();
			fis.close();
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
