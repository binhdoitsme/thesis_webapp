package com.hanu.webapp.modules.students;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students/*")
@SuppressWarnings({"unused"})
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentController controller = new StudentControllerImpl();

    /**
     * GET /students
     * GET /students/{id}
     * GET /students/{id}/enrolments
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().println("{ \"id\": \"1\", \"name\": \"Binh\" }");
        response.flushBuffer();
    }
    
}
