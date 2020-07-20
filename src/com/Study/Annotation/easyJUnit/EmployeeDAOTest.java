package com.Study.Annotation.easyJUnit;

public class EmployeeDAOTest {

    @MyBefore
    public void init(){
        System.out.println("初始化......");
    }

    @MyAfter
    public void destroy(){
        System.out.println("析构........");
    }

    @MyTest
    public void testSave(){
        System.out.println("---保存中......");
    }

    @MyTest
    public void testDelete(){
        System.out.println("---删除中......");
    }
}
