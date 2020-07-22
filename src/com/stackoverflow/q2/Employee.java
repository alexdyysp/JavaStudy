package com.stackoverflow.q2;

public class Employee {

        private String name;


        private String empId;

        public Employee(String name, String empId) {
            super();
            this.name = name;
            this.empId = empId;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    // equals and hashcode
        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", empId='" + empId + '\'' +
                    '}';
        }

}
