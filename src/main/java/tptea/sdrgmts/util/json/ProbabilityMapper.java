package tptea.sdrgmts.util.json;

import java.util.Random;
import java.util.TreeMap;

public class ProbabilityMapper<T> 
{
    TreeMap<Integer,T> probabilityMap;
    Integer maxValue = 0;

    public ProbabilityMapper() 
    {
        probabilityMap = new TreeMap<>();
    }

    public void put(int key, T value) 
    {
        probabilityMap.put(maxValue, value);
        maxValue += key;
    }

    public T get(Random rand)
    {
        return probabilityMap.floorEntry(rand.nextInt(maxValue)).getValue();
    }
}
