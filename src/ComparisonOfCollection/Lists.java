package ComparisonOfCollection;

import java.util.*;

public class Lists {
    private static Random rnd = new Random();
    private static final int NUMBERSOFTESTS = 100;
    private static final int SIZE = 1000;

    static <E extends List> long instanceTest(E list) {
        long startTime, estimatedTime;
        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(-100000 + rnd.nextInt(300000));
        }
        estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    static <E extends List> long addTest(E list) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERSOFTESTS; i++) {
            startTime = System.nanoTime();
            list.add(rnd.nextInt(list.size()), i);
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERSOFTESTS;
    }

    static <E extends List> long removeTest(E list) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERSOFTESTS; i++) {
            startTime = System.nanoTime();
            list.remove(rnd.nextInt(list.size()));
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERSOFTESTS;
    }

    static <E extends List> long indexOfTest(E list) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERSOFTESTS; i++) {
            startTime = System.nanoTime();
            list.indexOf(-100000+rnd.nextInt(300000));
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERSOFTESTS;
    }

    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new LinkedList<>();
        System.out.println("ArrayList instance test time:\t" + instanceTest(t1));
        System.out.println("LinkedList instance test time:\t" + instanceTest(t2));
        System.out.println("ArrayList add by index time:\t" + addTest(t1));
        System.out.println("LinkedList add by index time:\t" + addTest(t2));
        System.out.println("ArrayList remove by index time:\t" + removeTest(t1));
        System.out.println("LinkedList remove by index time:\t" + removeTest(t2));
        System.out.println("ArrayList indexOf by value time:\t" + indexOfTest(t1));
        System.out.println("LinkedList indexOf by value time:\t" + indexOfTest(t2));

        /*
            Размер листа = 10 000 000 - аж подвисло, для 100 млн уже не хватало памяти.
            Изменял размер от 1 000 до 10 000 000, результаты у LinkedList улучшались, но быстрее ArrayList он не
            ставновился.
            Результаты для SIZE = 1 000:
                    ArrayList instance test time:	    430079
                    LinkedList instance test time:	    290417

                    ArrayList add by index time:	    497
                    LinkedList add by index time:	    2619

                    ArrayList remove by index time:	    435
                    LinkedList remove by index time:	2201

                    ArrayList indexOf by value time:	17848
                    LinkedList indexOf by value time:	17726

            Результаты для SIZE = 10 000 000:
                    ArrayList instance test time:	    498776607
                    LinkedList instance test time:	    1661921100

                    ArrayList add by index time:	    7245704
                    LinkedList add by index time:	    11809065

                    ArrayList remove by index time:	    6423243
                    LinkedList remove by index time:	13276352

                    ArrayList indexOf by value time:	409101
                    LinkedList indexOf by value time:	1283518

            Если честно, неожиданно. Я думал, что linkedList покажет себя лучше на удалении и вставке объектов.
            С такими результатами, лучше всегда использовать ArrayList. Но если абстрагироваться от этого теста
            то LinkedList используется в задачах, когда нужно часто вставлять и удалять элементы, а ArrayList
            можно использовать в остальных случаях.
         */

    }
}
