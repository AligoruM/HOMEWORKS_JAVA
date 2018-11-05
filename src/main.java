import Employee.*;
import Shapes.*;
import Book.*;

public class main {
    void printArr(){

    }
    public static void main(String[] args) {
        /*Circle circle = new Circle(10, "blue");

        System.out.println(circle);
        System.out.println(circle.getArea());

        Rectangle rectangle = new Rectangle(10.2f,4.3f);
        System.out.println(rectangle);
        System.out.println("Area = " + rectangle.getArea());
        System.out.println("Perimeter = " + rectangle.getPerimeter());

        Employee emp = new Employee(1, "Sergey", "Lool", 2000);
        System.out.println(emp);
        System.out.println("Old salary = " + emp.getSalary() + " Annual salary = " + emp.getAnnualSalary());
        System.out.println("New salary = " + emp.raiseSalary(30) + " Annual salary = " + emp.getAnnualSalary());

        Author[] authors = new Author[3];
        authors[0]= new Author("first", "firstEmail", 'f');
        authors[1]= new Author("second", "secondEmail", 'm');
        authors[2]= new Author("third", "thirdEmail", 'f');
        Book book = new Book("Harry - you are wizard", authors, 100, 2);
        System.out.println(book);
        System.out.println(book.getAuthorsNames());*/
        MyPoint[] arrP = new MyPoint[3];
        arrP[0] = new MyPoint(0,0);
        arrP[1] = new MyPoint(1,1);
        arrP[2] = new MyPoint(1,0);
        for (int i =0;i<3;i++) {
            for (int j =0; j<3; j++) {
                for (int k=0; k<3;k++) {
                    if(i!=j && j!=k) {
                        MyTriangle tri1 = new MyTriangle(arrP[i], arrP[j], arrP[k]);
                        MyTriangle tri2 = new MyTriangle(arrP[k], arrP[i], arrP[j]);
                    /*System.out.println(tri1);
                    System.out.println(tri2);
                    System.out.println(tri2.equals(tri1));*/
                        System.out.println(tri1.hashCode() == tri2.hashCode());
                    }
                }
            }
        }
    }
}
