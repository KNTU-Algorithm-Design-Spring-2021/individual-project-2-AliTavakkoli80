package ir.ac.kntu;

import java.util.HashMap;

public class AlgorithmWordFinder {

    private String result;

    public AlgorithmWordFinder(String inputString, HashMap<String, String> mapFromFile) {
        result = new String("");
        int first = 0;
        int last = inputString.length();
        while (first != last) {

            if (mapFromFile.containsValue(inputString.substring(first, last))) {
                result += (inputString.substring(first, last));
                result += (" ");
                first = last;
                last = inputString.length();
            } else {
                last--;
            }
        }


    }

    public String getResult() {
        return result;
    }
}
