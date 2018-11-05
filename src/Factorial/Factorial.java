package Factorial;

public class Factorial {

    static int recFactorial(int n){
        if (n==1) {
            return 1;
        }
        else{
            return n*recFactorial(n-1);
        }
    }

    static int cycleFactorial(int n){
        int tmp = 1;
        for (int i=1; i<=n; i++) {
            tmp *= i;
        }
        return tmp;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(recFactorial(19));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Recur factorial time:\t" + estimatedTime);

        startTime = System.nanoTime();
        System.out.println(cycleFactorial(19));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Cycle factorial time:\t" + estimatedTime);
    }
}
