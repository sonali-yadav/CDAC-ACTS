package daos;

import java.sql.SQLException;
import java.util.List;

import custexception.StudentHandlingException;
import pojos.Student;

public interface IStudentDao {
	
	//Handling Method to Display All students by the specified course name
	List<Student> getStudentsByCourse(String courseName) throws SQLException, StudentHandlingException;
	
	//Handling Method to Update Student details (update marks & phone number)
	String updateStudentDetails(int id,double newMarks, String newNumber) throws SQLException, StudentHandlingException;
	
	//Handling Method to Cancel Student admission
	boolean cancelStudentAdmission(String sEmail) throws SQLException, StudentHandlingException;
}
