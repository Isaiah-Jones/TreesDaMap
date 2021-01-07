/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesdamap;

import java.io.*;
import java.util.*;

/**
 *CSC 255
 * Mr.Osborne
 * @author Isaiah J Jones
 * 10-30-17
 */
public class TreesDaMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Declare variable for the name of the text file
        String fileName = args[0];

        //Declare reference variables for TreeSet, File, and Scanner
        Map<String, Integer> tree = new TreeMap<>();
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        String word;
        String words;
        String[] wordarray = new String[30895];

        //Declare counter
        int count = 0;
        int x = 0;

        //Load wordarray[] with String from the text file without punctuation in lower case
        while (input.hasNext()) {
            word = input.next();
            words = word.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
            wordarray[count] = words.toLowerCase();
            count++;
        }

        //Load the TreeMap and Count how many individual words appear
        for (int i = 0; i < wordarray.length; i++) {
            String key = wordarray[i];

            if (key.length() > 0) {
                if (!tree.containsKey(key)) {
                    tree.put(key, 1);

                } else {
                    int value = tree.get(key);
                    value++;
                    tree.put(key, value);
                }
            }
        }

        //Create a Set for the entries
        Set<Map.Entry<String, Integer>> entrySet = tree.entrySet();

        //Print out the amount the unique words and how many times they appear
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
            x++;
        }

        System.out.println("The file " + fileName + " has " + count + " words and " + x + " unique words.");
    }
}
