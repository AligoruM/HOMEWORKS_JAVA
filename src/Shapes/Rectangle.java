package Shapes;

public class Rectangle {

    private float length;
    private float width;

    public Rectangle() {
        this.length = 1.0f;
        this.width = 1.0f;
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle length=" + length + ", width=" + width;
    }

    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return length*2 + width*2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return this.length==rectangle.length && this.width==rectangle.width;
    }

    @Override
    public int hashCode() {
        int result =17;
        result= 31*result + Float.floatToIntBits(length);
        result= 31*result + Float.floatToIntBits(width);
        return result;
    }
}
