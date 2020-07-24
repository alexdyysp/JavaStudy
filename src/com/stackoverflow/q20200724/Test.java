package com.stackoverflow.q20200724;

import java.text.ParseException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        String inputstr = scanner.nextLine(); //you enter 02-07-1987

        String[] inputarr = inputstr.split(" ");
        Date date = new Date(Integer.valueOf(inputarr[2]), inputarr[1], Integer.valueOf(inputarr[0]));

        System.out.println(date.getDateString());

    }
}
