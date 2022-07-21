import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// 1)
public class ConnectionManager {
	private static final ConnectionManager cmanager = new ConnectionManager();
	
	public static ConnectionManager getInstance() {
		return cmanager;
	}
	//2)
	private static final String URL = null;
	private static final String USER = null;
	private static final String PASSWD = null;

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWD);		
	}
}




//3
//public class ABCDao {
//	
//	public ABCDao() {
//		
//	}
//	public void doSomething() {
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				con = ConnectionManager.getConnection();
//			} finally {
//				rs.close();
//				pstmt.close();
//				con.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
