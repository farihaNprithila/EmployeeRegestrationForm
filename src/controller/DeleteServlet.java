package controller;

import DAO.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet()
public class DeleteServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init(){
        employeeDAO=new EmployeeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        try {
            employeeDAO.deleteEmployee(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("employee-list.jsp");
    }
}
