package com.blz.jdbc;

import java.sql.Date;

public class EmployeePayrollService {
    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public static void main(String[] args) {

        EmployeePayrollService service = new EmployeePayrollService();
        //service.retrieveData();
        //service.retrieveDataUsingPreparedStatement();
        //service.updateSalary("Terrisa", 4500000);
        service.retrieveDataOfAggregateFunction();
    }

    private void retrieveDataOfAggregateFunction() {
        System.out.println(repository.retrieveDataOfAggregateFunction());;
    }

    private void retrieveDataUsingPreparedStatement() {
        System.out.println(repository.retrieveDataUsingPreparedStatement());
    }

    private void updateSalary(String name, int basic_pay) {
        //repository.updateSalary(name.toLowerCase(), basic_pay);
        repository.updateSalaryUsingPreparedStatement(name.toLowerCase(), basic_pay);
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }

}
