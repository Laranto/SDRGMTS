package tptea.sdrgmts.util.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tptea.sdrgmts.model.CharacterTemplate;

/**
 * Interface to Load JSON Files filled with descriptions. 
 */
public class JSONLoader {

    public static final String DATA_ENTRY = "data";
    
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
    
    private JSONObject parseDataFile(String filePath){
        File f = new File(rootFile.getParent()+File.separator+filePath);
        try {
            JSONObject o = (JSONObject)((JSONObject)parser.parse(new FileReader(f))).get(DATA_ENTRY);
        return o;
        } catch(Exception e){
            e.printStackTrace();
            return new JSONObject();
        }
    }
    
    
    // TODO Probably this should not be called the CharacterTemplate, rather template or so...
    public CharacterTemplate buildGroupCharacter(String group){
        CharacterTemplate chara = new CharacterTemplate(group);
        JSONObject o = optionMap.get(group);
        for (CharacterTemplate.Characteristic c : CharacterTemplate.Characteristic.values()) {
            JSONArray fileList = (JSONArray) o.get(c.toString());
            fileList.forEach((k)->parseDataFile((String) k).forEach((u,v)->chara.addMappingEntry(c, ((Long) v).intValue(), (String) u)));
        }
        return chara;
    }
}
