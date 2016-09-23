package com.AlyssaMoore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        // Setting max and creating empty arraylist houses
        int max = 0;
        ArrayList houses = new ArrayList(100);

        // Creating bufReader to work with fileReader and reading first line in document for loop
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("recyclingreport-mainstreet.txt"));
            String line = bufReader.readLine();

        /* for each of 100 entries, take the number of crates (always at index 18) and if this number
         is greater than current max, replace current max with this number, then move on to next line */
            for (int x = 0; x < 100; x++) {
                int crates = line.charAt(18);
                if (crates >= max) {
                    max = crates;
                }
                line = bufReader.readLine();
            }

            // Closing the bufReader so I can reopen and return to beginning of document
            bufReader.close();

            // Reopening file and reading first line to begin for loop
            bufReader = new BufferedReader(new FileReader("recyclingreport-mainstreet.txt"));
            line = bufReader.readLine();

        /* for each of 100 entries, if number of crates (always at index 18) is equal to the max
           then take the house number (always equal to current place in loop) and add to ArrayList
           houses, then go to next line and repeat */
            for (int y = 0; y < 100; y++) {
                if (line.charAt(18) == max) {
                    houses.add(y);
                }
                line = bufReader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Sorry, there was an IOException.");
        }
        // Printing house numbers with most recycling bins
        System.out.println("Houses that recycled the most: " + houses);
    }
}