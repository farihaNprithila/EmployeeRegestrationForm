package controller;

import DAO.EmployeeDAO;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateEmployeeServlet")

public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String contact=request.getParameter("contact");

        Employee user=new Employee(id,firstName,lastName,username,password,address,contact);
        try {
            employeeDAO.updateEmployee(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("all");



    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

    }
}
