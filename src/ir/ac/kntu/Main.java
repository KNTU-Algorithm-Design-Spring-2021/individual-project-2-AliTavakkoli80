package ir.ac.kntu;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
//    final static String filePath
//            = "resources/words.txt";

    final static String filePath
            = "resources/words_alpha.txt";

    private AlgorithmWordFinder algorithmWordFinder;
    private FileHandler fileHandler;
    private InputManager inputManager;
    private OutputManager outputManager;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler(filePath);
        InputManager inputManager = new InputManager(scanner);
        OutputManager outputManager = new OutputManager();

        HashMap<String, String> mapFromFile = fileHandler.HashMapFromTextFile();


        String string = inputManager.inputStringGetter().toLowerCase();
        AlgorithmWordFinder algorithmWordFinder = new AlgorithmWordFinder(string, mapFromFile);

        outputManager.showString(algorithmWordFinder.getResult());
    }
}
