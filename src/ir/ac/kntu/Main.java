package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    final static String filePath
            = "resources/words_alpha.txt";

    public static void main(String[] args) {

        // read text file to HashMap
        HashMap<String, String> mapFromFile = HashMapFromTextFile();

//        System.out.println(mapFromFile.toString());

        System.out.println(mapFromFile.containsValue("asd"));


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
                    map.put(number,name);
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
