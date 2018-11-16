package MyLinkedList;

import Shapes.MyPoint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class TestList {
    public static void main(String[] args) {
        LinkedList<MyPoint> test2 = new LinkedList<MyPoint>();
        for (int i = 0; i < 100; i++)
            test2.add(new MyPoint(i, i));
        System.out.println(Arrays.toString(test2.toArray()));
        /*
        Будет дублирование кода в тесте, лень было писать функции для красоты
         */
        /*MyLinkedList<MyPoint> test1 = new MyLinkedList<MyPoint>();
        LinkedList<MyPoint> test2 = new LinkedList<MyPoint>();
        for (int i = 0; i < 1000000; i++) {
            test1.add(new MyPoint(i, i));
            test2.add(new MyPoint(i, i));
        }
        Random rnd = new Random(38745763);
        long startTime, estimatedTime = 0;

        //-----------------------------------------------------------//
        for (int i = 0; i < 100; i++) {
            startTime = System.nanoTime();
            for (MyPoint j : test1) {
            }
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("MyList round time:\t" + estimatedTime/100);

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            startTime = System.nanoTime();
            for (MyPoint j : test2) {
            }
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("JavaList round time:\t" + estimatedTime/100);

        //-----------------------------------------------------------//

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(1000000);
            startTime = System.nanoTime();
            test1.indexOf(new MyPoint(rand, rand));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("MyList indexOf time:\t" + estimatedTime/100); //

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(1000000);
            startTime = System.nanoTime();
            test2.indexOf(new MyPoint(rand, rand));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("JavaList indexOf time:\t" + estimatedTime/100);
        //-----------------------------------------------------------//

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(1000000);
            startTime = System.nanoTime();
            test1.add(rand, new MyPoint(i, i));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("MyList add by index time:\t" + estimatedTime/100); //

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(1000000);
            startTime = System.nanoTime();
            test2.add(rand, new MyPoint(i, i));
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("JavaList add by index time:\t" + estimatedTime/100);
        //-----------------------------------------------------------//
        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(990000);
            startTime = System.nanoTime();
            test1.remove(rand);
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("MyList remove by index time:\t" + estimatedTime/100); //

        estimatedTime=0;
        for (int i = 0; i < 100; i++) {
            int rand = rnd.nextInt(990000);
            startTime = System.nanoTime();
            test2.remove(rand);
            estimatedTime += (System.nanoTime() - startTime);
        }
        System.out.println("JavaList remove by index time:\t" + estimatedTime/100);*/
        //-----------------------------------------------------------//
        /*
            MyList round time:	            7767237  | видимо, из-за более простой реализации, работает чуточку быстрее
            JavaList round time:	        9428691  | по-другому объяснить не могу
            MyList indexOf time:	        3570612     | аналогично, не смотяр на то, что обычный список двусвязный,
            JavaList indexOf time:	        4870185     | нет возможности определить, в какой половине находится искомое
            MyList add by index time:	    9247731  | уже начинает играть роль наличие ссылки на предыдущий элемент у
            JavaList add by index time:	    3106548  | ноды, намного быстрее добирается до 2ой половины списка
            MyList remove by index time:	7753994     | полностью аналогичная ситуация, описана выше
            JavaList remove by index time:	3029884     |
        */
    }
}
