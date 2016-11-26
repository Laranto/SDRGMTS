package tptea.sdrgmts.model;

import com.sun.org.apache.xpath.internal.operations.Equals;
import java.util.HashMap;
import tptea.sdrgmts.util.json.ProbabilityMapper;

/**
 * Reprentation of a Shadowrun character with his stats, skills and background.
 */
public class Character {
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
    HashMap<Characteristic, ProbabilityMapper> probabilityMap;

    public Character(String group) {
        this.group = group;
        for (Characteristic c : Characteristic.values()) {
            probabilityMap.put(c, new ProbabilityMapper());
        }
    }
    
    public void addMappingEntry(String characteristic,int chance, String description) {
        addMappingEntry(Characteristic.valueOf(characteristic.toUpperCase().trim()), chance, description);
    }
    public void addMappingEntry(Characteristic characteristic,int chance, String description) {
        probabilityMap.get(characteristic).put(chance, description);
    }
}
