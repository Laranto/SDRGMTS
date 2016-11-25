package tptea.sdrgmts.util.json;

import java.io.File;
import java.io.IOException;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * Interface to Load JSON Files filled with descriptions. 
 */
public class JSONLoader {
    
    private File rootFile;
    
    public JSONLoader() {
        try {
            rootFile = new File("resources"+File.separator+"main.json");
            if (!rootFile.exists()) {
                throw new IOException("main.json does not exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
