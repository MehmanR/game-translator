package util;

import java.util.Scanner;

public class InputUtil {

    public static String requeireString (String title) {
        Scanner sc = new Scanner(System.in);
        System.out.print(title + ": ");
        return sc.nextLine();
    }
    public static int requireInt (String title) {
        Scanner sc = new Scanner(System.in);
        System.out.print(title + ": ");
        return sc.nextInt();
    }


}
