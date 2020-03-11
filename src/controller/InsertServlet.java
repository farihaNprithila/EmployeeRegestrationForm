package controller;

import DAO.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class InsertServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String contact=request.getParameter("contact");
        Employee user=new Employee(firstName,lastName,username,password,address,contact);
        try {
            employeeDAO.insertEmployee(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("all");

    }
}
