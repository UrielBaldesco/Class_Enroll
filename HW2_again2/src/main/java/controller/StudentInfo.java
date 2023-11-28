package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentGroups;
import model.Student;

@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentInfo() {
        super();
    }

//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		
//		List<StudentGroups> groups = new ArrayList<>();
//		groups.add(new StudentGroups("Dolphins"));
//		groups.add(new StudentGroups("Lakers"));
//		groups.add(new StudentGroups("Minnows"));
//		getServletContext().setAttribute("groups", groups);
//		
//		List<Student> student = new ArrayList<>();
//		student.add(new Student("Abby", "Sue", "Sue@gmail.com", "7", "Dolphins"));
//		student.add(new Student("Luke", "Sue", "Sue@gmail.com", "6", "Lakers"));
//		student.add(new Student("John", "James", "James@gmail.com", "5", "Minnows"));
//		student.add(new Student("Alice", "Jessica", "Jessica@gmail.com", "8", "Minnows"));
//		getServletContext().setAttribute("student", student);
//
//	}

	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<StudentGroups> groups = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		Connection c = null;
		
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
			String username = "cs3220stu63";
			String password = "2EFFrIN537Ao";
			
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students ");
			
			Statement groupStmt = c.createStatement();
			ResultSet grouprs = groupStmt.executeQuery("SELECT * FROM student_groups");
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setParent(rs.getString("parent_name"));
				student.setParentEmail(rs.getString("parent_email"));
				student.setGroupName(rs.getString("group_name"));
				students.add(student);
			}
//			request.setAttribute("students", students);
			getServletContext().setAttribute("students", students);
			
			while(grouprs.next()) {
				StudentGroups group = new StudentGroups();
				group.setIdGroup(grouprs.getInt("idGroup"));
				group.setGroupName(grouprs.getString("group_name"));
				groups.add(group);
			}
//			request.setAttribute("groups", groups);
			getServletContext().setAttribute("groups", groups);
			
		} catch(SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if(c != null) c.close();
			} catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/StudentInfo.jsp").forward(request, response);
	}

}
