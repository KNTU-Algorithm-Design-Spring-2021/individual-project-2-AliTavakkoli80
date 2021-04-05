package ir.ac.kntu;

import java.util.Scanner;

public class InputManager {
    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputStringGetter(){
        System.out.println("Enter th input string : ");
        return scanner.nextLine();
    }
}
