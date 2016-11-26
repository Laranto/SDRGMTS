package tptea.sdrgmts.util.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Interface to Load JSON Files filled with descriptions. 
 */
public class JSONLoader {
    
    private File rootFile;
    private JSONParser parser;
    private HashMap<String,JSONObject> optionMap;
    public JSONLoader() {
        try {
            rootFile = new File("resources"+File.separator+"main.json");
            parser = new JSONParser();
            System.out.println(rootFile);
            if (!rootFile.exists()) {
                throw new IOException("main.json does not exist!");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createOptionMap() throws IOException, ParseException {
        JSONObject rootFileObject = (JSONObject) parser.parse(new FileReader(rootFile));
        optionMap = new HashMap<>();
        System.out.println(rootFileObject.toString());
        for (Object key : rootFileObject.keySet()) {
            optionMap.put((String)key, (JSONObject)(rootFileObject.get(key)));
        }
    }
    
    public Set<String> getGroups(){
        return optionMap.keySet();
    }
    
    // TODO Probably this should not be called the Character, rather template or so...
    public tptea.sdrgmts.model.Character buildGroupCharacter(String group){
        tptea.sdrgmts.model.Character c = new tptea.sdrgmts.model.Character(group);
        JSONObject o = optionMap.get(group);
        // TODO Get the file array from the JSON
        // TODO For each file fill the characteristic in the character
        
        return c;
    }
}
