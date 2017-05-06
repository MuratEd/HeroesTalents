package model.file;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.*;

public class JSONFile {
    private String path;
    private String jsonText;

    public JSONFile(String path) {
        this.path = path;
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readJson();
    }

    public void readFile() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        String chainTmp;
        this.jsonText = "";
        while ((chainTmp = file.readLine()) != null) {
            jsonText += chainTmp;
        }
        file.close();
    }

    private void readJson() {
        JsonParser parser = Json.createParser(new StringReader(jsonText));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch(event) {
                case START_ARRAY:
                    System.out.println("Event START_ARRAY");
                    break;
                case END_ARRAY:
                    System.out.println("Event END_ARRAY");
                    break;
                case START_OBJECT:
                    System.out.println("Event START_OBJECT");
                    break;
                case END_OBJECT:
                    System.out.println("Event END_OBJECT");
                    break;
                case VALUE_FALSE:
                    System.out.println("Event VALUE_FALSE");
                    break;
                case VALUE_NULL:
                    System.out.println("Event VALUE_NULL");
                    break;
                case VALUE_TRUE:
                    System.out.println("Event VALUE_TRUE");
                    break;
                case KEY_NAME:
                    System.out.println("Event KEY_NAME");
                    break;
                case VALUE_STRING:
                    System.out.println("Event VALUE_STRING");
                    break;
                case VALUE_NUMBER:
                    System.out.println("Event VALUE_NUMBER");
                    break;
            }
        }
    }


}
