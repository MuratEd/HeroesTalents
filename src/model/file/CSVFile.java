package model.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that read the CSV file given
 */
public class CSVFile {
    String path;
    ArrayList<ArrayList<String>> table;

    /**
     * Constructor that set up the path of the CSV file
     * @param path Path of the CSV file
     */
    public CSVFile(String path) {
        this.path = path;
        this.table = new ArrayList<>();
        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading method for CSV file
     * @throws IOException Raise exception when file doesnt exist
     */
    public void readCSV() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String chainTmp;
        String[] tableTmp;
        ArrayList<String> lineTmp;
        while ((chainTmp = file.readLine()) != null) {
            lineTmp = new ArrayList<>();
            tableTmp = chainTmp.split(";");
            for(int i=0 ; i<tableTmp.length ; ++i) {
                lineTmp.add(tableTmp[i]);
            }
            this.table.add(lineTmp);
        }
        file.close();
    }

    /**
     * Get the full table
     * @return List of all values of the table, line by line
     */
    public ArrayList<ArrayList<String>> getTable() {
        return this.table;
    }

    /**
     * Get a specific line
     * @param line Index of line
     * @return List of all values of the line given
     */
    public ArrayList<String> getLine(int line) {
        return getTable().get(line);
    }

    /**
     * Get a specific value at a specific line
     * @param line Index of line
     * @param idx Index of value
     * @return Value of the line and index given
     */
    public String getValue(int line, int idx) {
        return getLine(line).get(idx);
    }
}
