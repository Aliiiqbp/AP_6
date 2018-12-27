package src.View;

import java.util.Scanner;

public class IO {

    public static String[] splitCommand() {      // this function is static
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        return strings;
    }
}