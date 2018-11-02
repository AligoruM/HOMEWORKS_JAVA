package Shapes;

import java.util.Objects;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        this.x=0;
        this.y=0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y){
        setX(x);                    //Есть ли смысл делать так, или дублирование кода сэттеров не так критично?
        setY(y);
    }

    public double[] getXY(){
        double[] tmp = {x,y};          //Тот же вопрос к get методам, как я понял их совсем не обязательно использовать
        return tmp;                 //внутри класса
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    public double distance(double x2, double y2){
        double result = Math.sqrt((x2-x)*(x2-x) + (y2-y)*(y2-y));
        return result;
    }

    public double distance(MyPoint point){
        double result = distance(point.getX(), point.getY());
        return result;
    }
    public double distance(){
        double result = distance(0,0);
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPoint p = (MyPoint)o;
        return this.x==p.x && this.y==p.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + (int)(Double.doubleToLongBits(x)^(Double.doubleToLongBits(x)>>>32));
        result = 31*result + (int)(Double.doubleToLongBits(y)^(Double.doubleToLongBits(y)>>>32));
        return result;
    }
}
