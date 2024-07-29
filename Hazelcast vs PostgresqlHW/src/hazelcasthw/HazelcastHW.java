package hazelcasthw;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastHW {

    public static void main(String[] args) {

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        IMap<Integer, String> map = hazelcastInstance.getMap("map");

        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            map.put((int) Math.random(), "value" + i);
        }
        long endTime = System.nanoTime();
        long putDuration = endTime - startTime;
        System.out.println("Time taken to put 10,000 entries: " + putDuration / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            map.get(i);
        }
       
        endTime = System.nanoTime();
        long getDuration = endTime - startTime;
        System.out.println("Time taken to get 10,000 entries: " + getDuration / 1_000_000.0 + " ms");

    }
}
