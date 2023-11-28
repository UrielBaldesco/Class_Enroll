package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentGroups;


@WebServlet("/DisplayGroup")
public class DisplayGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentGroups> groups = new ArrayList<>();
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
			String username = "cs3220stu63";
			String password = "2EFFrIN537Ao";
			
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student_groups");
			
			while(rs.next()) {
				StudentGroups sg = new StudentGroups();
				sg.setGroupName(rs.getString("group_name"));
				groups.add(sg);
			}
			request.setAttribute("groups", groups);
		}catch(SQLException e) {
			throw new ServletException(e);
		}finally {
			try {
				if(c != null) c.close();
			}catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/DisplayGroup.jsp").forward(request, response);
	
	}

}
