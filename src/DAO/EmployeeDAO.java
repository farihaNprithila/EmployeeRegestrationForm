package DAO;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String url = "jdbc:mysql://localhost:3307/employeedatabase";
    private static final String user = "root";
    private static final String password = "123456789";
    public EmployeeDAO(){}
    //sql commands
    private static final String insert_users="INSERT INTO employee"+" (first_name,last_name,username,password,address,contact) VALUES "+" (?, ?, ?, ?, ?, ?);";
    private static final String select_user_by_id="select id,first_name,last_name,username,password,address,contact from employee where id=?";
    private static final String select_all_users="select * from employee";
    private static final String delete_users="delete from employee where id = ?;";
    private static final String update_users="update employee set first_name = ?, last_name =?, username =? password = ?, address =?, contact =? where id = ?;";

    /*public static void main(String [] args){
        Connection connection=getConnection();
    }*/
   // public static void main(String[] args) throws SQLException {
        //Employee employee=new Employee("Fariha","Nawaz","FNP","123","Mirpur-2","019********");
        //insertEmployee(employee);
        //List<Employee> e=selectAllEmployee();
        //Iterator<Employee> itr = e.listIterator();
        //while (itr.hasNext()) {
            //System.out.println(itr.next());
        //}
       // deleteEmployee(6);


    //}

    //connection with the database
    protected Connection getConnection(){
        Connection connection=null;
        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,password);
            //System.out.println("Yes");
        }catch (SQLException e){
            //System.out.println("Database not found");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            //System.out.println("Class not found");
            e.printStackTrace();

        }
        return connection;
    }
    //Insert users
    public void insertEmployee(Employee user) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_users)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //for updating the data

    public boolean updateEmployee(Employee user)throws SQLException{
        boolean value;
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_users)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.setInt(7,user.getId());
            value=preparedStatement.executeUpdate()>0;
        }
        return value;
    }

    //select user by id
    public Employee selectEmployee(int id) throws SQLException {
        Employee user=null;
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_user_by_id)){
            preparedStatement.setInt(1,id);
            //System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String first_name=resultSet.getString("first_name");
                String last_name=resultSet.getString("last_name");
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");
                String address=resultSet.getString("address");
                String contact=resultSet.getString("contact");
                user=new Employee(first_name,last_name,username,password,address,contact);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    //select all users

    public List<Employee> selectAllEmployee() throws SQLException, NullPointerException {
        List<Employee> users=new ArrayList<>();
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(select_all_users))
        {
            System.out.println(preparedStatement);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String first_name=resultSet.getString("first_name");
                String last_name=resultSet.getString("last_name");
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");
                String address=resultSet.getString("address");
                String contact=resultSet.getString("contact");
                users.add(new Employee(id,first_name,last_name,username,password,address,contact));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    //Deleting the user

    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(delete_users)){
            preparedStatement.setInt(1,id);
            rowDeleted=preparedStatement.executeUpdate()>0;
        }
        return rowDeleted;

    }
}
