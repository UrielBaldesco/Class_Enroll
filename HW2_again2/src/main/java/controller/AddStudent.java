
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Date;

import model.Student;
import model.StudentGroups;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AddStudent.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
			String name = request.getParameter("name"); // parameter is the name attribute from jsp
			String age = request.getParameter("age");
			String parent = request.getParameter("parent");
			String parentEmail = request.getParameter("parentEmail");
			String groupName = request.getParameter("groupName");

			Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
				String username = "cs3220stu63";
				String password = "2EFFrIN537Ao";
				
				c = DriverManager.getConnection(url, username, password);
//				Statement stmt = c.createStatement();
//				stmt.executeUpdate("insert into students(name, age, parent_name, parent_email, group_name) values ('" + name + "', '" + age + "', '" + parent + "', '" + parentEmail + "', '" + groupName + "' ) ");
//				ResultSet rs = stmt.getGeneratedKeys();
//				rs.next();
				String sql = "INSERT INTO students(name, age, parent_name, parent_email, group_name) VALUES (?, ?, ?, ?, ?)";
			    PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			    // Set parameters for the insert statement
			    pstmt.setString(1, name);
			    pstmt.setString(2, age);
			    pstmt.setString(3, parent);
			    pstmt.setString(4, parentEmail);
			    pstmt.setString(5, groupName);

			    // Execute the insert statement
			    pstmt.executeUpdate();

			    // Retrieve the generated keys
			    ResultSet rs = pstmt.getGeneratedKeys();
			    rs.next();
//				
				
			} catch (SQLException e) {
				throw new ServletException(e);
			}finally {
				try {
					if(c != null) c.close();
				}catch(SQLException e) {
					throw new ServletException(e);
				}
			}
						
			response.sendRedirect("StudentInfo");
	}

}
