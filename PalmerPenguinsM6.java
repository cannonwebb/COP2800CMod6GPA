// PalmerPenguinsM6.java
// Cannon Webb
// 10/12/2026
// Reads the CSV file and parses data into arrays using user-defined methods

import java.io.*;
import java.util.*;

public class PalmerPenguinsM6 {

    static final String FILE_NAME = "PalmerPenguins.csv";

    // Constants representing species and count
    public static final int NUM_SPECIES = 3;
    public static final String SP_CHINSTRAP = "Chinstrap";
    public static final String SP_GENTOO = "Gentoo";
    public static final String SP_ADELIE = "Adelie";

    public static void main(String[] args) {

        // TODO 1: Call readSpeciesData()
        String[] speciesData = readSpeciesData();

        // TODO 2: Call initializeSpeciesCount()
        int[] speciesCount = initializeSpeciesCount();

        // TODO 3: Check if speciesData is empty
        if (isDataEmpty(speciesData)) {
            System.out.println("Error: No species data found.");
            return;
        }

        // TODO 4: Count species occurrences
        countSpecies(speciesData, speciesCount);

        // TODO 5: Print species counts
        printSpeciesCount(speciesCount);
    }

    /**
     * TODO 1:
     * Reads column 1 (species column) from the CSV file and returns a String[].
     */
    public static String[] readSpeciesData() {
        return CSVReader.readFile(FILE_NAME, 1);
    }

    /**
     * TODO 2:
     * Returns a new int array sized NUM_SPECIES to store species counts.
     */
    public static int[] initializeSpeciesCount() {
        return new int[NUM_SPECIES];
    }

    /**
     * TODO 3:
     * Returns true if the given String[] array is empty, false otherwise.
     */
    public static boolean isDataEmpty(String[] arr) {
        return arr.length == 0;
    }

    /**
     * TODO 4:
     * Iterates through speciesData and increments the appropriate speciesCount index.
     */
    public static void countSpecies(String[] speciesData, int[] speciesCount) {
        for (String species : speciesData) {
            if (species.equals(SP_CHINSTRAP)) {
                speciesCount[0]++;
            } else if (species.equals(SP_GENTOO)) {
                speciesCount[1]++;
            } else if (species.equals(SP_ADELIE)) {
                speciesCount[2]++;
            }
        }
    }

    /**
     * TODO 5:
     * Prints the count of each species using the predefined constants.
     */
    public static void printSpeciesCount(int[] speciesCount) {
        System.out.println(SP_CHINSTRAP + " count = " + speciesCount[0]);
        System.out.println(SP_GENTOO + " count = " + speciesCount[1]);
        System.out.println(SP_ADELIE + " count = " + speciesCount[2]);
    }
}

class CSVReader {
    public static String[] readFile(String FILE_NAME, int column) {
        List<String> columnValues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (column >= 0 && column < tokens.length) {
                    columnValues.add(tokens[column]);
                } else {
                    columnValues.add("");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        return columnValues.toArray(new String[0]);
    }
}