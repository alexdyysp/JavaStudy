package com.Study.Annotation.easyJUnit;

import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MyJUnit {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // 1. get Class Binary Object
        Class c = EmployeeDAOTest.class;
        Object object = c.newInstance();

        // 2. get method of Class
        Method[] methods = c.getMethods();

        // 3. iterate each Method Object and judge which method use annotation
        List<Method> beforeList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();

        for(Method method:methods){
            if(method.isAnnotationPresent(MyBefore.class)){
                beforeList.add(method);
            }else if(method.isAnnotationPresent(MyTest.class)){
                testList.add(method);
            }else if(method.isAnnotationPresent(MyAfter.class)){
                afterList.add(method);
            }
        }

        for(Method test:testList){
            // First, Run MyBefore
            for(Method method:beforeList){
                method.invoke(object);
            }
            // Second, Run Test
            test.invoke(object);

            for(Method method:afterList){
                method.invoke(object);
            }
        }

    }
}
