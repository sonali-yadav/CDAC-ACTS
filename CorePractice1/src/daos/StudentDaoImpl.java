package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import custexception.StudentHandlingException;
import pojos.Student;
import static utils.ConnectionProvider.*;

public class StudentDaoImpl implements IStudentDao {

	// data members
	private Connection conn;
	private PreparedStatement pst0, pst1, pst2, pst3, pst4, pst5;

	public StudentDaoImpl() throws ClassNotFoundException, SQLException {
		conn = getConnection();
		pst0 = conn.prepareStatement("select count(*) from students where course_name=? group by course_name");
		pst1 = conn.prepareStatement("select * from students where course_name=?");
		pst2 = conn.prepareStatement("select name from students where id=?");
		pst3 = conn.prepareStatement("update students set marks=?, phone_no=? where id=?");
		pst4 = conn.prepareStatement("select id from students where email=?");
		pst5 = conn.prepareStatement("delete from students where email=?");
	}

	@Override
	public List<Student> getStudentsByCourse(String courseName) throws SQLException, StudentHandlingException {
		pst0.setString(1, courseName);
		pst1.setString(1, courseName);
		List<Student> st = new ArrayList<>();
		try (ResultSet rst = pst0.executeQuery();) {
			if (rst.next()) {
				try (ResultSet rst1 = pst1.executeQuery();) {
					while (rst1.next()) {
						st.add(new Student(rst1.getInt(1), rst1.getString(2), rst1.getString(3), rst1.getString(4),
								rst1.getString(5), rst1.getString(6), rst1.getDouble(7)));
					}
				}
				return st;
			} else
				throw new StudentHandlingException("This course has no students!");
		}
	}

	@Override
	public String updateStudentDetails(int id, double newMarks, String newNumber)
			throws SQLException, StudentHandlingException {
		pst2.setInt(1, id);
		pst3.setDouble(1, newMarks);
		pst3.setString(2, newNumber);
		pst3.setInt(3, id);
		try (ResultSet rst = pst2.executeQuery();) {
			if (rst.next()) {
				int q = pst3.executeUpdate();
				if (q == 1) {
					return "Details Updated Successfully!";
				}
			} else
				throw new StudentHandlingException("Student Not Found!");
		}
		return "Could not update!";
	}

	@Override
	public boolean cancelStudentAdmission(String sEmail) throws SQLException, StudentHandlingException {
		pst4.setString(1, sEmail);
		pst5.setString(1, sEmail);
		try (ResultSet rst = pst4.executeQuery();) {
			rst.next();
			int id = rst.getInt(1);
			if (id > 0) {
				int q = pst5.executeUpdate();
				if (q == 1) {
					return true;
				}
			} else
				throw new StudentHandlingException("Student Not Found!");
		}
		return false;
	}
}