package tptea.sdrgmts;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import tptea.sdrgmts.model.CharacterTemplate;
import tptea.sdrgmts.util.json.JSONLoader;

import tptea.sdrgmts.util.json.ProbabilityMapper;

public class Main {
    
    private static void referenceRun(){
        ProbabilityMapper map = new ProbabilityMapper();
        map.put(new Integer(72),"Human");
        map.put(new Integer(9),"Elf");
        map.put(new Integer(10),"Orc");
        map.put(new Integer(6),"Dwarf");
        map.put(new Integer(2),"Troll");
        Random rand = new Random();
        float a = 0;
        for (int i = 0; i<100000;i++){
        	if (map.get(rand)=="Orc"){
        		a++;
        	}
        }
        System.out.println(a/100000*100);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello Chummer!");
        JSONLoader j = new JSONLoader();
        try{
        j.createOptionMap();
            CharacterTemplate c = j.buildGroupCharacter(j.getGroups().iterator().next());
            float a = 0;
            for (int i = 0; i<100000;i++){
                String race = c.getRandom(CharacterTemplate.Characteristic.RACE);
                if(i<20){
                    System.out.println(race);
                }
        	if (race.equals("Orc")){
        		a++;
        	}
            }
            System.out.println(a/100000*100);
        } catch (Exception e) {
            System.err.println("This is not good... :(");
            e.printStackTrace();
        }
                
        referenceRun();
    }
    
}