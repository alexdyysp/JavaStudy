package com.Study.lambda;

@FunctionalInterface
interface IMath{
    int add(int x, int y);
}

interface IMath2{
    int add2(int x, int y);
}

public class TypeInferDemo {
    public static void main(String[] args){

        IMath lambda = (x,y) -> x + y;

        IMath[] lambdas = { (x,y) -> x+y };

        Object lambda2 = (IMath) (x,y) -> x+y;

        IMath createLambda = createLambda();

        TypeInferDemo demo = new TypeInferDemo();
        demo.test((IMath2) (x,y) -> x+y);
    }

    public void test(IMath math){

    }
    public void test(IMath2 math){

    }
    public static IMath createLambda(){
        return (x,y) -> x+y;
    }
}
