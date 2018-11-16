package ComparisonOfCollection;

import java.util.*;

public class Maps {
    private static Random rnd = new Random();
    private static final int NUMBERS_OF_TESTS = 1000;
    private static final int SIZE = 10000;

    static <E extends Map> long instanceTest(E map) {
        long startTime, estimatedTime;
        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            /*-100000 + rnd.nextInt(300000)*/
            map.put(-SIZE + rnd.nextInt(SIZE*3), i);
        }
        estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    static <E extends Map> long addTest(E map) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            map.put(-SIZE + rnd.nextInt(SIZE*3), i);
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERS_OF_TESTS;
    }

    static <E extends Map> long removeTest(E map) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            map.remove(-SIZE + rnd.nextInt(SIZE*3));
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERS_OF_TESTS;
    }
    public static void main(String[] args) {
        HashMap<Integer, Double> t1 = new HashMap<>();
        LinkedHashMap<Integer, Double> t2 = new LinkedHashMap<>();
        TreeMap<Integer, Double> t3 = new TreeMap<>();

        System.out.println("HashMap instance test time:\t" + instanceTest(t1));
        System.out.println("LinkedHashMap instance test time:\t" + instanceTest(t2));
        System.out.println("TreeMap instance test time:\t" + instanceTest(t3));
        System.out.println("HashMap add test time:\t" + addTest(t1));
        System.out.println("LinkedHashMap add test time:\t" + addTest(t2));
        System.out.println("TreeMap add test time:\t" + addTest(t3));
        System.out.println("HashMap remove test time:\t" + removeTest(t1));
        System.out.println("LinkedHashMap remove test time:\t" + removeTest(t2));
        System.out.println("TreeMap remove test time:\t" + removeTest(t3));

        /*
        Размер 10 000 000:
                HashMap instance test time:	        4606224144
                LinkedHashMap instance test time:	5486287814
                TreeMap instance test time:	        9542953302

                HashMap add test time:	            273
                LinkedHashMap add test time:	    315
                TreeMap add test time:	            1188

                HashMap remove test time:	        360
                LinkedHashMap remove test time:	    390
                TreeMap remove test time:	        1531
        Размер 10 000:
                HashMap instance test time:	        2383355
                LinkedHashMap instance test time:	2680599
                TreeMap instance test time:	        5091261

                HashMap add test time:	            278
                LinkedHashMap add test time:	    228
                TreeMap add test time:	            483

                HashMap remove test time:	        364
                LinkedHashMap remove test time:	    205
                TreeMap remove test time:	        590
         В первую очередь ориентируемся на необходимость порядка, если он не нужен - HashMap, важна последовательность
         добавления - LinkedHashMap, важно, что бы было в отсортированном порядке - TreeMap.
         */

    }
}
