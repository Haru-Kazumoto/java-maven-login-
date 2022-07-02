package Login.Page.Util;

import java.util.Scanner;

public class inputUtil {
    private static Scanner input = new Scanner(System.in);
    public static String Input(String Command){
        System.out.print(Command+" : ");
        return input.nextLine();
    }
}
