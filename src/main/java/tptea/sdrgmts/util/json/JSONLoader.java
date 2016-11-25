package tptea.sdrgmts.util.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Interface to Load JSON Files filled with descriptions. 
 */
public class JSONLoader {
    
    private File rootFile;
    private JSONParser parser;
    
    public JSONLoader() {
        try {
            rootFile = new File("resources"+File.separator+"main.json");
            parser = new JSONParser();
            System.out.println(rootFile);
            if (!rootFile.exists()) {
                throw new IOException("main.json does not exist!");
            }

            JSONObject rootFileObject = (JSONObject) parser.parse(new FileReader(rootFile));
            System.out.println(rootFileObject.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
