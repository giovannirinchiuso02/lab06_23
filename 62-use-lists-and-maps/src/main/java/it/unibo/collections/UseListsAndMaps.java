package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int INITIAL_VALUE = 1000;
    private static final int FINAL_VALUE = 2000;

    private UseListsAndMaps() {
    }

    private static double millisToAddElements(int size, List<Integer> l) {
        double time = System.currentTimeMillis();
        for(int i = 0; i < size ; i++) {
            l.add(0, i);
        }
        return System.currentTimeMillis() - time;
    }

    private static double millisToReadMiddleElement(int times, List<Integer> l) {
        int middleIndex = l.size() / 2;
        double time = System.currentTimeMillis();
        for(int i = 0; i < times; i++) {
            l.get(middleIndex);
        }
        return System.currentTimeMillis() - time;
    }


    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arrayList = new ArrayList<>();
        for(int i = INITIAL_VALUE; i < FINAL_VALUE; i++) {
            arrayList.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(final var element: arrayList) {
            System.out.println(element);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        System.out.println(millisToAddElements(100000, arrayList));
        System.out.println(millisToAddElements(100000, linkedList));
        


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        System.out.println(millisToReadMiddleElement(1000, arrayList));
        System.out.println(millisToReadMiddleElement(1000, linkedList));

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> worldMap = new HashMap<>();
        worldMap.put("Africa", 1_110_635_000L);        
        worldMap.put("America", 972_005_000L);
        worldMap.put("Antarctica", 0L);
        worldMap.put("Asia", 4_298_723_000L);
        worldMap.put("Europe", 742_452_000L);
        worldMap.put("Oceania", 38_304_000L);
        System.out.println(worldMap.toString());


        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0L;
        for(Long population: worldMap.values()) {
            worldPopulation = worldPopulation + population;
        }
        System.out.println(worldPopulation);
    
    }
}
