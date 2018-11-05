package Cycles;

public class Cycles {

    static void printRectangle(int n, int m){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m; j++){
                System.out.print('#');
            }
            System.out.println();
        }
    }

    static void printO(){
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(i == 0 || i == 6 || j == 0 || j == 6)
                    System.out.print('#');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    static void printZ(){
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(i == 0 || i == 6 || i + j == 6)
                    System.out.print('#');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    static void printSome(){
        for(int i = 0; i<7; i++){
            for(int j = 0; j<7; j++){
                if(i == 0 || i == 6 || i + j == 6 || i == j || j == 0 || j == 6)
                    System.out.print('#');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printRectangle(10,10);// #3.a
        System.out.println();
        printO();//3.b
        System.out.println();
        printZ();//3.b
        System.out.println();
        printSome();//3.b
    }
}
