package com.stackoverflow.q2;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

// https://stackoverflow.com/questions/63027395/how-to-get-response-in-form-of-an-array/63027891#63027891
public class TestEmp {
    public static void main(String[] args) throws IllegalAccessException {
        // TODO Auto-generated method stub

        Employee emp1 = new Employee("Luke", "11");
        Employee emp2 = new Employee("Luke2", "12");

        Set<Employee> empSet = new LinkedHashSet<>();

        empSet.add(emp1);
        empSet.add(emp2);


        Object obj[] = empSet.toArray();

        Field[] fs = Employee.class.getDeclaredFields();
        String [][] empArry = new String[obj.length][fs.length];

        for(int i=0; i<obj.length; i++){
            Class a = (Class) obj[i].getClass();
            for(int j=0; j<fs.length; j++){
                Field f = fs[j];
                f.setAccessible(true);
                Object val = f.get(obj[i]);
                empArry[i][j] = (String) val;
            }
        }

        Arrays.asList(empArry).forEach(x -> System.out.println(x[0]+" "+x[1]));


    }
}
