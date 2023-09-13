package bugSmasher.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bugSmasher.daointerface.BugsIntf;
import bugSmasher.exceptions.BugAlreadyExistsException;
import bugSmasher.exceptions.BugNotFoundException;
import bugSmasher.model.Bugs;
import bugSmasher.model.Bugs.Severity;
import bugSmasher.model.Bugs.bugStatus;

public class BugsDaoImpl implements BugsIntf {

	@Override
	public void addBug(Bugs b) throws BugAlreadyExistsException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String insert = "insert into bugs values (?,?,?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement s = con.prepareStatement(insert)) {

			s.setInt(1, b.getUid());
			s.setString(2, b.getTitle());
			s.setString(3, b.getDescription());
			s.setDate(4, (Date) b.getCreatedOn());
			s.setInt(5, b.getProjectId());
			s.setDate(6, (Date) b.getClosedOn());
			s.setString(7, b.getClosedby());
			s.setString(8, b.getAssignedTo());
			// ((Bugs) s).setString(2, b.getStatus());
			s.setBoolean(9, true);
			s.setObject(10, b.getStatus());
			s.setObject(11, b.getBugSevLevel());

			int count = s.executeUpdate();

			System.out.println("no of rows inserted : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);

	}

	@Override
	public Bugs getBug(int id) throws BugNotFoundException {

		Connection con = getConnection();

		if (con != null) {
			String select = "select * from bugs where bugId = ?";

			try (PreparedStatement s = con.prepareStatement(select)) {

				s.setInt(1, id);
				ResultSet rs = s.executeQuery();

				while (rs.next()) {
					int bugId = rs.getInt(1);
					String title = rs.getString(2);
					String desc = rs.getString(3);
					Date d = rs.getDate(4);
					int projectId = rs.getInt(5);
					Date d2 = rs.getDate(6);
					String closedby = rs.getString(7);
					String assignedTo = rs.getString(8);
					Boolean markedForClosing = rs.getBoolean(9);
					bugStatus bugstatus = (bugStatus) rs.getObject(10);
					Severity sevLevel = (Severity) rs.getObject(11);
					
					Bugs b = new Bugs(bugId,title,desc,d,projectId,d2,closedby,assignedTo,markedForClosing,bugstatus,sevLevel);

					return b;

				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				closeConnection(con);
			}
		}
		throw new BugNotFoundException("Bug with id :" + id + " not found");

	}

	@Override
	public void deleteBug(int bugId) throws BugNotFoundException {
		Connection con = getConnection();
		String delete = "DELETE FROM bugs where bugId = ?";;

		try (PreparedStatement s = con.prepareStatement(delete)) {

			s.setInt(1, bugId);
		   
			int count = s.executeUpdate();

			System.out.println("no of rows inserted : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);


	}

	@Override
	public void updateBug(int bugId) throws BugNotFoundException {
		// TODO Auto-generated method stub

	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BugSmasher?useSSL=false", "root",
					"Mansi@0504");
			if (con != null) {
				System.out.println("Connection Established successfully");
				return con;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
