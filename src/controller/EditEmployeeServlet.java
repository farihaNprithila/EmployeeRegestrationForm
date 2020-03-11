package controller;

import DAO.EmployeeDAO;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class EditEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() {
        employeeDAO = new EmployeeDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            showEditForm(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee user=employeeDAO.selectEmployee(id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("employee-add.jsp");
        request.setAttribute("user",user);
        dispatcher.forward(request,response);

    }
}
