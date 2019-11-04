package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        int principal;
        float annualInterest;
        int YEARS = 0;
        int MONTHS = YEARS * MONTHS_IN_YEAR;
        float monthlyInterest;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Please enter a value greater than $1000 and equal or less than $1,000,000");
        }
        while (true) {
            System.out.print("Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
                System.out.println("Please enter a value greater than 0 and less than or equal to 30");
        }
        while (true) {
            System.out.print("How many years: ");
            YEARS = scanner.nextInt();
            if (YEARS > 0 && YEARS <= 30)
                break;
            System.out.println("Please enter a value greater than 0 and less than or equal to 30");
        }
        int numberOfPayments = YEARS * MONTHS_IN_YEAR;
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments ) -1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}