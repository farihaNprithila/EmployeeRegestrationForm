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
import java.util.List;

@WebServlet("/all")
public class AllEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init(){
        employeeDAO=new EmployeeDAO();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void listUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> listUser =  employeeDAO.selectAllEmployee();
        System.out.println(listUser.toString());
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

}