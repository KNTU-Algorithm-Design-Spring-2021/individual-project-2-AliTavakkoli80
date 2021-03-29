package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    final static String filePath
            = "resources/words.txt";

//    final static String filePath
//            = "resources/words_alpha.txt";

    public static void main(String[] args) {

        // read text file to HashMap
        HashMap<String, String> mapFromFile = HashMapFromTextFile();

//        System.out.println(mapFromFile.toString());

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        string.toLowerCase();
        System.out.println(string);
        String result = new String("");

        for (int i = 0; i < string.length(); i++) {
            String tmp = "";
            int j = 0;
            while (!mapFromFile.containsValue(tmp)) {
                tmp += string.charAt(j);
                j++;
            }
            result += tmp;
            result += " ";
        }
        System.out.println(result);

        System.out.println(mapFromFile.containsValue("abort"));


        // iterate over HashMap entries
//        for (Map.Entry<String, String> entry :
//                mapFromFile.entrySet()) {
//            System.out.println(entry.getKey() + " : "
//                    + entry.getValue());
//        }
    }

    public static HashMap<String, String> HashMapFromTextFile() {

        HashMap<String, String> map
                = new HashMap<String, String>();
        BufferedReader br = null;

        try {

            // create file object
            File file = new File(filePath);

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split the line by :
//                String[] parts = line.split(":");

                // first part is name, second is number
                String name = line;
                String number = String.valueOf(line.hashCode());

                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    map.put(number, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }

            }
        }

        return map;
    }
}
