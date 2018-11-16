package ComparisonOfCollection;

import java.util.*;

public class Sets {
    private static Random rnd = new Random();
    private static final int NUMBERS_OF_TESTS = 100;
    private static final int SIZE = 100000;

    static <E extends Set> long instanceTest(E set) {
        long startTime, estimatedTime;
        startTime = System.nanoTime();
        for (int i = 0; i < SIZE;) {
            /*-100000 + rnd.nextInt(300000)*/
            if(set.add(rnd.nextInt(SIZE)))
                i++;
        }
        estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    static <E extends Set> long addTest(E set) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            set.add(-SIZE + rnd.nextInt(set.size()));
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERS_OF_TESTS;
    }

    static <E extends Set> long removeTest(E set) {
        long startTime, estimatedTime = 0;
        for (int i = 0; i < NUMBERS_OF_TESTS; i++) {
            startTime = System.nanoTime();
            set.remove(rnd.nextInt(set.size()));
            estimatedTime += (System.nanoTime() - startTime);
        }
        return estimatedTime / NUMBERS_OF_TESTS;
    }

    public static void main(String[] args) {
        HashSet<Integer> t1 = new HashSet<>();
        LinkedHashSet<Integer> t2 = new LinkedHashSet<>();
        TreeSet<Integer> t3 = new TreeSet<>();

        System.out.println("HashSet instance test time:\t" + instanceTest(t1));
        System.out.println("LinkedHashSet instance test time:\t" + instanceTest(t2));
        System.out.println("TreeSet instance test time:\t" + instanceTest(t3));
        System.out.println("HashSet add test time:\t" + addTest(t1));
        System.out.println("LinkedHashSet add test time:\t" + addTest(t2));
        System.out.println("TreeSet add test time:\t" + addTest(t3));
        System.out.println("HashSet remove test time:\t" + removeTest(t1));
        System.out.println("LinkedHashSet remove test time:\t" + removeTest(t2));
        System.out.println("TreeSet remove test time:\t" + removeTest(t3));
        /*
        При добавлении упорядоченной последовательности
                HashSet instance test time:	        7363683
                LinkedHashSet instance test time:	9690719
                TreeSet instance test time:	        25320910

                HashSet add test time:	            921
                LinkedHashSet add test time:	    27929
                TreeSet add test time:	            3063

                HashSet remove test time:	        677
                LinkedHashSet remove test time:	    750
                TreeSet remove test time:	        4895

        При добавлении случайных чисел от 0 до SIZE
                HashSet instance test time:	        97744588
                LinkedHashSet instance test time:	96489906
                TreeSet instance test time:	        402723891

                HashSet add test time:	            762
                LinkedHashSet add test time:	    29024
                TreeSet add test time:	            304

                HashSet remove test time:	        529
                LinkedHashSet remove test time:	    6636
                TreeSet remove test time:	        3174

            TreeSet явно лучше всего использовать, если нужно, что бы данные хранились в отсортированном виде
            HashSet универсален, используется в задачах, где не важен порядок хранения, и важна скорость
            LinkedHashSet довольно медленный, но сохраняет порядок добавления. Возможно, можно использовать его как
            некоторую очередь.
         */

    }
}
