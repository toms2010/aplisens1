package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read{

	private ResultSet myRs = null;
	
	public void read(Statement myStmt, ListsInterface list){
		try {
			myRs=list.selectMethod(myStmt);
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				try {
					myRs.close();
					System.out.println("myRS Disconnect");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
