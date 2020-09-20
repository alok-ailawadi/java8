package com.bootcamptech.function;

import sun.security.krb5.internal.crypto.Des;

import java.util.Enumeration;
import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Employee> isFinanceDepartment = emp -> emp.department==Department.FINANCE;
    static Predicate<Employee> isSalesDepartmet = emp -> emp.department==Department.SALES;
    static Predicate<Employee> isDirector = emp -> emp.designation==Designation.DIRECTOR;

    public static void main(String[] args) {

        Employee emp1 = new Employee("Ashok", Department.FINANCE, Designation.DIRECTOR);
        Employee emp2 = new Employee("Kishor", Department.SALES, Designation.MANAGER);
        Employee emp3 = new Employee("Shah", Department.SALES, Designation.DIRECTOR);

        if(isFinanceDepartment.test(emp1)){
            System.out.println(emp1.name + " is from sales");
        }

        if(isFinanceDepartment.test(emp2)){
            System.out.println(emp1.name);
        }else{
            System.out.println("Not from finance hence not allowed entry");
        }

        /****** compostion with and *******/
        if(isFinanceDepartment.and(isDirector).test(emp1)){
            System.out.println(emp1.name + " is from Finance and is director");
        }

        if(isFinanceDepartment.or(isSalesDepartmet).test(emp3)){
            System.out.println(emp3.name + " is allowed entry to conference");
        }


    }

}

enum Department{

    SALES, FINANCE, TECH, MARKETIING, LEGAL;

}

enum Designation {

    MANAGER, LEAD, DIRECTOR, PRESIDENT;

}

class Employee{

    Employee(String name, Department department, Designation designation){
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    String name;
    Department department;
    Designation designation;
}

