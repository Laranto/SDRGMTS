package tptea.sdrgmts;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import tptea.sdrgmts.util.json.JSONLoader;

import tptea.sdrgmts.util.json.ProbabilityMapper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Chummer!");
        JSONLoader j = new JSONLoader();
        ProbabilityMapper map = new ProbabilityMapper();
        map.put(new Integer(72),"Human");
        map.put(new Integer(9),"Elf");
        map.put(new Integer(10),"Orc");
        map.put(new Integer(6),"Dwarf");
        map.put(new Integer(2),"Troll");
        Random rand = new Random();
        float a = 0;
        for (int i = 0; i<100000;i++){
        	if (map.get(rand)=="Elf"){
        		a++;
        	}
        }
        System.out.println(a/100000*100);
    }
    
}