package controller;

import java.io.IOException;
import java.util.List;

import model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteGroup")
public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteGroup() {
        super();
    }

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student eachStudent = null;
		List<Student> studentList = (List<Student>)getServletContext().getAttribute("student");
		for(Student s : studentList) {
			if(s.getId()==id) {
				eachStudent = s;
				break;
			}
		}
		if(eachStudent != null) {
			studentList.remove(eachStudent);
		}
		response.sendRedirect("EditGroup");
	}

}
