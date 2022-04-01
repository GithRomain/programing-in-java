package agh.ii.prinjava.lab09.lst09_03;

import agh.ii.prinjava.lab09.lst09_03.services.MoneyTransferService;

public class Main {
    private static void demo1() {
        System.out.println("demo1...");

        MoneyTransferService srv = new MoneyTransferService();
        srv.brokenMoneyTransfer(1, 2, 100);
    }

    private static void demo2() {
        System.out.println("\ndemo2...");

        MoneyTransferService srv = new MoneyTransferService();
        srv.unsuccessfulMoneyTransfer(1, 2, 100);
    }

    private static void demo3() {
        System.out.println("\ndemo3...");

        MoneyTransferService srv = new MoneyTransferService();
        srv.successfulMoneyTransfer(1, 2, 100);
    }

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }
}
