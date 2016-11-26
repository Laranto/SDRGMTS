package tptea.sdrgmts.model;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.HashMap;
import java.util.Random;
import tptea.sdrgmts.util.json.ProbabilityMapper;

/**
 * Reprentation of a Shadowrun character with his stats, skills and background.
 */
public class CharacterTemplate {
    public enum Characteristic {
        RACE("race"), NAME("name");
        
        private String characteristicDesc;
        private Characteristic(String c) {
            characteristicDesc = c;
        }
        @Override
        public String toString() {
            return characteristicDesc;
        }
    }
    String group;
    Random rand;
    HashMap<Characteristic, ProbabilityMapper<String>> probabilityMap;

    public CharacterTemplate(String group) {
        this.group = group;
        probabilityMap = new HashMap<>();
        rand = new Random();
        for (Characteristic c : Characteristic.values()) {
            probabilityMap.put(c, new ProbabilityMapper<>());
        }
    }
    
    public void addMappingEntry(String characteristic,Integer chance, String description) {
        addMappingEntry(Characteristic.valueOf(characteristic.toUpperCase().trim()), chance, description);
    }
    public void addMappingEntry(Characteristic characteristic,Integer chance, String description) {
        probabilityMap.get(characteristic).put(chance, description);
    }
    
    public String getRandom(Characteristic c){
        return probabilityMap.get(c).get(rand);
    }
}
