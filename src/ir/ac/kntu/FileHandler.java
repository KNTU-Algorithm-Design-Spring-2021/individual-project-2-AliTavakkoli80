package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class FileHandler {

    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public HashMap<String, String> HashMapFromTextFile() {

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
