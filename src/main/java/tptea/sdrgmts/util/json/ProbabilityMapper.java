package tptea.sdrgmts.util.json;

import java.util.Random;
import java.util.TreeMap;

public class ProbabilityMapper {
	TreeMap<Integer,String> probabilityMap;
	Integer maxValue = 0;
	
	public ProbabilityMapper() {
		probabilityMap = new TreeMap<>();
	}
	
	public void put(int key, String value) {
		probabilityMap.put(maxValue, value);
		maxValue += key;
	}
	
	public String get(Random rand){
		return probabilityMap.floorEntry(rand.nextInt(maxValue)).getValue();
	}
}
