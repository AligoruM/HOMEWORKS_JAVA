package Cycles;

public class Cycles {

    public void printRectangle(int n, int m){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m; j++){
                System.out.print('#');
            }
            System.out.println();
        }
    }

    public void printO(){
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

    public void printZ(){
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

    public void printSome(){
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
        Cycles cycles = new Cycles();

        cycles.printRectangle(10,10);// #3.a
        System.out.println();
        cycles.printO();//3.b
        System.out.println();
        cycles.printZ();//3.b
        System.out.println();
        cycles.printSome();//3.b
    }
}
