package MyLinkedList;

import ComparisonOfCollection.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static ComparisonOfCollection.Lists.SIZE;
import static ComparisonOfCollection.Lists.NUMBERS_OF_TESTS;

public class TestList {
    private static Random rnd = new Random();
    static <E extends List, T extends ILinkedList> void instanceTest(E list1, T list2) {
        System.out.println("Instance test time for LinkedList:" + Lists.instanceTest(list1));
        long startTime, estimatedTime;
        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list2.add(-100000 + rnd.nextInt(300000));
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Instance test time for MyLinkedTest:" + estimatedTime);
    }

    static <E extends List, T extends ILinkedList> void addTest(E list1, T list2) {
        System.out.println("Add by index test time for LinkedList:" + Lists.addTest(list1));
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            list2.add(rnd.nextInt(list2.size()), i);
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("Add by index test time for MyLinkedTest:" + estimatedTime/NUMBERS_OF_TESTS);
    }

    static <E extends List, T extends ILinkedList> void indexOfTest(E list1, T list2) {
        System.out.println("indexOf test time for LinkedList:" + Lists.indexOfTest(list1));
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            list2.indexOf(-100000+rnd.nextInt(300000));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("indexOf test time for MyLinkedList:" + estimatedTime/NUMBERS_OF_TESTS);
    }

    static <E extends List, T extends ILinkedList> void roundTest(E list1, T list2) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i <NUMBERS_OF_TESTS ; i++) {
            startTime = System.nanoTime();
            for (Object j: list1) {
            }
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("round test time for LinkedList:" + estimatedTime / NUMBERS_OF_TESTS);
        estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            for (Object j: list2) {
            }
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("round test time for MyLinkedList:" + estimatedTime / NUMBERS_OF_TESTS);
    }

    static <E extends List, T extends ILinkedList> void removeTest(E list1, T list2) {
        System.out.println("Remove by index test time for LinkedList:" + Lists.removeTest(list1));
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            list2.remove(rnd.nextInt(list2.size()));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("Remove by index test time for MyLinkedList:" + estimatedTime/NUMBERS_OF_TESTS);
    }

    public static void main(String[] args) {
        LinkedList<Double> list1 = new LinkedList<>();
        MyLinkedList<Double> list2 = new MyLinkedList<Double>();

        instanceTest(list1, list2);
        addTest(list1, list2);
        indexOfTest(list1, list2);
        roundTest(list1, list2);
        removeTest(list1, list2);

        /*
            Instance test time for LinkedList:          136935460   | Не нашёл причины, почему работает настолько
            Instance test time for MyLinkedTest:        232762748   | медленнее...
            Add by index test time for LinkedList:      2706385     | Из-за "двусвязности" обычного списка, работает
            Add by index test time for MyLinkedTest:    4534241     | заметно быстрее.
            indexOf test time for LinkedList:           2052117     | Видимо, из-за более простой реализации, работает
            indexOf test time for MyLinkedList:         1007743     | в 2-3 раза быстрее, по-другому объяснить не могу.
            round test time for LinkedList:             8616130     | Аналогично.
            round test time for MyLinkedList:           3727064     |
            Remove by index test time for LinkedList:   2292435     | Играет роль двусвязности обычного списка, из-за
            Remove by index test time for MyLinkedList: 3435151     | чего элементы во второй половине удаляются быстрее

        */
    }
}
