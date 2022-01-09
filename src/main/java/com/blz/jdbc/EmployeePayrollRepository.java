package com.blz.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {

    //Create JDBC connection for connect db data
    private Connection getConnection() {

        Connection connection = null;
        String dbUrl = "jdbc:mysql://localhost:3307/Payroll_Services";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, "root", "pass");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        } catch (ClassNotFoundException e) {
            System.out.println("drivers not loaded");
        }
        return connection;
    }
    //Retrieve Data method statement
    public List<EmployeeInfo> retrieveData() {
        //Collection list used for find data
        List<EmployeeInfo> employeeInfos = new ArrayList<>();

        try (Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            String sqlQuery = "select * from employee";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            //Iterator Data while loop through from employee_payroll table
            while (resultSet.next()) {
                //Called EmployeeInfo Object
                EmployeeInfo info = new EmployeeInfo();

                info.setId(resultSet.getInt("id"));
                info.setName(resultSet.getString("name"));
//                info.setGender(resultSet.getString("gender").charAt(0));
                info.setStartDate(resultSet.getDate("startDate"));
                info.setAddress(resultSet.getString("address"));
                info.setPhone(resultSet.getLong("phone"));
                employeeInfos.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeInfos;
    }

    public void updateSalary(String name, int basic_pay) {
        try(Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            //String sqlQuery = "update employee_payroll set salary = " +salary +" where name = " +name+ "'";
            String sqlQuery = String.format("update employee_payroll set basic_pay = %d where name = '%s'",basic_pay,name);
            int result = statement.executeUpdate(sqlQuery);
            if (result >= 1){
                System.out.println("BasicPay Updated");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}