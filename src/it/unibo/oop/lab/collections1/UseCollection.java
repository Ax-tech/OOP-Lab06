package it.unibo.oop.lab.collections1;

import java.util.*;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 100_000;
    private static final int TO_MS = 1_000_000;


    private UseCollection() {
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
    	final List<Integer> l1 = new ArrayList<>();
    	
    	for (int i = 1000; i < 2000; i++) {
    		l1.add(i);
    	}
    	
    	/*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> l2 = new LinkedList<>(l1);
    	
    	/*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int temp = l1.get(l1.size() - 1);
    	l1.set(l1.size() - 1, l1.get(l1.size() - l1.size()));
    	l1.set(l1.size() - l1.size(), temp);

    	/*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (Integer i: l1) {
    		System.out.println(i);
    	}
    	
    	/*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime(); //ArrayList compute time
    	
    	for (int i = 1; i <= ELEMS; i++) {
            l1.add(0, i);
        }
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + " into an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println(l1);
        
        time = System.nanoTime(); //LinkedList compute time
    	
    	for (int i = 1; i <= ELEMS; i++) {
            l2.add(0, i);
        }
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS
                + " into a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        System.out.println(l2);
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime(); //ArrayList compute time
    	
    	for (int i = 1; i <= ELEMS; i++) {
            l1.get(l1.size() / 2);
        }
    	
    	time = System.nanoTime() - time;
        System.out.println("Reading " + ELEMS
                + " in the middle of an ArrayList of size " + l1.size() + " took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
        
        time = System.nanoTime(); //LinkedList compute time
    	
    	for (int i = 1; i <= ELEMS; i++) {
            l2.get(l2.size() / 2);
        }
    	
    	time = System.nanoTime() - time;
    	System.out.println("Reading " + ELEMS
                + " in the middle of a LinkedList of size " + l1.size() + " took " 
        		+ time + "ns (" + time / TO_MS + "ms)");
        
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
    	final Map<String, Long> map = new HashMap<>();
    	
    	map.put("Africa", 1_110_635L);
    	map.put("Americas", 972_005_000L);
    	map.put("Antarctica", 0L);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000L);
    	map.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	long pop = 0;
    	for (Long l: map.values()) {
    		pop = pop + l;
    	}
    	System.out.println("Population of the World: " + pop);
    	
    }
}
