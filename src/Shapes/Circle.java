package Shapes;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this.radius = 1;
        this.color = "red";
    }

    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
    }

    public Circle (double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle radius=" + radius + ", color=" + color;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle c = (Circle)o;
        return this.radius == c.radius && this.color.equals(c.color);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + (int)(Double.doubleToLongBits(radius)^(Double.doubleToLongBits(radius)>>>32));
        result = 31*result + color.hashCode();
        return result;
    }
}
