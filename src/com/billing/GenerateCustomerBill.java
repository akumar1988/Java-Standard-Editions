package com.billing;

import java.util.Scanner;

public class GenerateCustomerBill {

    Integer itemCost;
    Integer givenAmount;
    Integer balanceAmount;
    int Rs[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        GenerateCustomerBill generateCustomerBill = new GenerateCustomerBill();
        generateCustomerBill.process();
    }

    private void process() {
        Scanner scanner = null;
        scanner = new Scanner(System.in);
        System.out.print("Please Enter Item Cost In RS: ");
        itemCost = Integer.parseInt(scanner.next());
        System.out.print("Please Enter Amount In RS  : ");
        givenAmount = Integer.parseInt(scanner.next());
        System.out.println("Billing Is Under Process.........");
        try {
            Thread.sleep(1000);
            this.balance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void balance() throws Exception {
        {
            if ((givenAmount <= itemCost) || (givenAmount <= 0)) {
                throw new InvalidNumberException("Please Enter Valid Number Only");
            } else {
                for (int n : Rs) {
                    if (n == givenAmount) {
                        balanceAmount = givenAmount - itemCost;
                        this.amount();
                    }
                }
                throw new InvalidNumberException("Please Enter According to Indian Standard INR.");
            }
        }
    }

    private void amount() {
        Integer copy = balanceAmount, totalNotes = 0, count = 1;
        System.out.println("\nRs DEMONSTRATIONS : \n");
        for (int i = 0; i < 10; i++) {
            count = balanceAmount / Rs[i];
            if (count != 0) {
                System.out.println(Rs[i] + "\tx\t" + count + "\t= " + Rs[i] * count);
            }
            totalNotes = totalNotes + count;
            balanceAmount = balanceAmount % Rs[i];
        }
        System.out.println("--------------------------------");
        System.out.println("TOTAL\t\t\t= " + copy);
        System.out.println("--------------------------------");
        System.out.println("Total Number of Notes\t= " + totalNotes);
    }
}

