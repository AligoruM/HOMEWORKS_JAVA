package Shapes;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
        this.v3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1 +
                ",v2=" + v2 +
                ",v3=" + v3 +
                '}';
    }

    public double getPerimeter(){
        double result = v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
        return result;
    }
    //Точность - 4 знака после запятой
    public String getType(){
        double l1 = Math.round(v1.distance(v2)*10000.0)/10000.0;
        double l2 = Math.round(v2.distance(v3)*10000.0)/10000.0;
        double l3 = Math.round(v3.distance(v1)*10000.0)/10000.0;
        if (l1 == l2 && l2==l3 && l3==l1){
            return "Equilateral";
        }else if (l1==l2 || l2==l3 || l3==l1)
            return "Isosceles";
        return "Scalene";
    }
    /*
    В моем понимании равенства треугольников в 4 часа ночи, это соответствие координат их вершин, а не длин сторон,
    т.е. не только стороны равны, но и положения на плоскости этих треугольников. Тут, конечно, можно поспорить,
    как лучше переопределить этот метод...
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle tr = (MyTriangle) o;
        boolean result = false;
        if (v1.equals(tr.v1) && v2.equals(tr.v2) && v3.equals(tr.v3)){
            result = true;
        }
        if (v1.equals(tr.v2) && v2.equals(tr.v3) && v3.equals(tr.v1)){
            result = true;
        }
        if (v1.equals(tr.v3) && v2.equals(tr.v2) && v3.equals(tr.v1)){
            result = true;
        }
        if (v1.equals(tr.v1) && v2.equals(tr.v3) && v3.equals(tr.v2)){
            result = true;
        }
        if (v1.equals(tr.v2) && v2.equals(tr.v1) && v3.equals(tr.v3)){
            result = true;
        }
        if (v1.equals(tr.v3) && v2.equals(tr.v1) && v3.equals(tr.v2)){
            result = true;
        }
        //понимаю, что это полная хрень, но ничего красивого не придумал
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17 + 31*v1.hashCode() + 31*v2.hashCode() + 31*v3.hashCode();
        /*Как я понимаю, все треугольники созданные из набора одних и тех же точек, переданных в разном порядке,
        являются одинаковыми, поэтому не использую умножение на число, т.к это даст такой результат, что хэшкод будет
        зависеть от порядка, в котором были переданы точки.*/
        return result;
    }
}
