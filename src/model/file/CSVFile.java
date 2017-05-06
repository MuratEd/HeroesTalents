package model.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFile {
    String path;
    ArrayList<ArrayList<String>> table;

    public CSVFile(String path) {
        this.path = path;
        this.table = new ArrayList<>();
    }

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

    public ArrayList<ArrayList<String>> getTable() {
        return this.table;
    }

    public ArrayList<String> getLine(int line) {
        return getTable().get(line);
    }

    public String getValue(int line, int idx) {
        return getLine(line).get(idx);
    }
}
