package com.stackoverflow;

public class bar {

    public static void main(String[] args) {
        int array[] = {19, 3, 15, 7, 11, 9, 13, 5, 17, 1};
        int index = 0;
        int base10=0;
        for (int j=1; j <=100; j+=10) {
            System.out.print(j + " - " + (base10+=10) + "  | " );
            while(array[index] > 0) {
                System.out.print("*");
                array[index]--;
            }
            index++;
            System.out.println();
        }
    }
}

