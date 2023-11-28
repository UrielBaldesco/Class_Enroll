package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentGroups;

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
	 private String username = "cs3220stu63";
	 private String password = "2EFFrIN537Ao";
	 private Connection c;


    public EditGroup() {
        super();
    }
    
    @SuppressWarnings("unchecked")
	private StudentGroups getGroupId(int id) {
    	
    	StudentGroups group = new StudentGroups();
    	try {
    		String sql = "select * from student_groups where idGroup = ? ";
    		PreparedStatement pstmt = c.prepareStatement(sql);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next()) {
    			group.setIdGroup(rs.getInt("idGroup"));
    			group.setGroupName(rs.getString("group_name"));
    		}
    		pstmt.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(c!=null)c.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		
    	}
    	return group;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idGroup"));
		request.setAttribute("group", getGroupId(id));
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idGroup"));
		String groupName = request.getParameter("groupName");
		
		try {
			String sql = "update student_groups set name = ? where idGroup = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, groupName);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("StudentInfo");
	}

}
