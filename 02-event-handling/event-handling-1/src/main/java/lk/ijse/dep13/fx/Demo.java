package lk.ijse.dep13.fx;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        final var SCANNER = new Scanner(System.in);
        System.out.println("Hello");
        boolean flag = true;
        while (flag){
            //
            System.out.print("Enter something: ");
            String input = SCANNER.nextLine();
            if (input.equals("exit")){ flag = false;}
            System.out.println("Hey");
        }
        stop();
    }

    static void stop(){
        System.out.println("stop()");
    }
}
