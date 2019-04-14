package Exe1;

import java.util.Scanner;

public class User extends Thread {

    private String in;
    private String out;

    public User() {    }

    public void run() {
        System.out.println("Type 'in' file name");
        Scanner scanner = new Scanner(System.in);
        in = scanner.next();
        System.out.println("Type 'out' file name");
        out = scanner.next();
        scanner.close();
        System.out.println("user part done");
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public void setIn(String in) {
        this.in = in;
    }
}
