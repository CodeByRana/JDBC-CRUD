package com.blz.jdbc;

public class EmployeePayrollService {
    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public static void main(String[] args) {

        EmployeePayrollService service = new EmployeePayrollService();
        //service.retrieveData();
        service.updateSalary("Terrisa", 3000000);

    }
    private void updateSalary(String name, int basic_pay) {
        repository.updateSalary(name, basic_pay);
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }
}
