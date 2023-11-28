package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditStudent() {
        super();
    }
   
    @SuppressWarnings("unchecked")
	private Student getStudentId(int id) {
    	Student student = new Student();

		Connection c = null;

    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
			String username = "cs3220stu63";
			String password = "2EFFrIN537Ao";
        	c = DriverManager.getConnection(url, username, password);
        	
    		String sql = "select * from students where id = ?";
    		PreparedStatement pstmt = c.prepareStatement(sql);
    		pstmt.setInt(1,  id);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next()){
    			student.setId(rs.getInt("id"));
    			student.setName(rs.getString("name"));
    			student.setAge(rs.getInt("age"));
    			student.setParent(rs.getString("parent_name"));
    			student.setParentEmail(rs.getString("parent_email"));
    			student.setGroupName(rs.getString("group_name"));
    		}
        	pstmt.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return student;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", getStudentId(id));
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Student student = getStudentId(Integer.parseInt(request.getParameter("id")));
//		student.setName(request.getParameter("name"));
//		student.setParent(request.getParameter("parent"));
//		student.setParentEmail(request.getParameter("parentEmail"));
//		student.setAge(Integer.parseInt(request.getParameter("age")));	
//		student.setGroupName(request.getParameter("groupName"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name  = request.getParameter("name");
		String parent = request.getParameter("parent");
		String parentEmail = request.getParameter("parentEmail");
		int age = Integer.parseInt( request.getParameter("age") );
		String groupName = request.getParameter("groupName");
		
		Connection c = null;
		
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
			String username = "cs3220stu63";
			String password = "2EFFrIN537Ao";
        	c = DriverManager.getConnection(url, username, password);
        	
			String sql = "update students set name = ?,  age = ?, parent_name = ?, parent_email = ?, group_name = ? where id = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2,  age);
			pstmt.setString(3, parent);
			pstmt.setString(4, parentEmail);
			pstmt.setString(5, groupName);
			pstmt.setInt(6, id); // the numbers correlates to ? placeholder in query 
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("StudentInfo");
		
	}

}
/*
 * GuestBookEntry entry = new GuestBookEntry(name, message);
		List<GuestBookEntry> listEntries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		listEntries.add(entry);
 * */
 