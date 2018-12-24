package src.View;

import java.util.Scanner;

public class IO {

    public String[] splitCommand() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        return strings;
    }
}
