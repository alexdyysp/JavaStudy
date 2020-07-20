package com.Study.Annotation;


import java.lang.reflect.Field;

public class TestClass {
    @TestAnnotation(testAnnoValue = "test attribute")
    private String testFieldA;

    @TestAnnotation
    private String testFieldB;

    public static void main(String[] args){
        Class c = TestClass.class;
        Field[] fields = c.getDeclaredFields();

        for(Field field:fields){
            TestAnnotation testAnnotation = field.getAnnotation(TestAnnotation.class);
            if(testAnnotation!=null){
                System.out.println("field: " + field.getName() + "value: " + testAnnotation.testAnnoValue());
            }
        }


    }
}
