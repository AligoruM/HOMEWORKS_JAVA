package Ball;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float deltaX;
    private float deltaY;

    public Ball(float x, float y, int radius, int speed, int direction){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.deltaX = speed*(float)Math.cos(direction);
        this.deltaY = -speed*(float)Math.sin(direction);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(float deltaX) {
        this.deltaX = deltaX;
    }

    public float getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(float deltaY) {
        this.deltaY = deltaY;
    }

    public void move(){
        this.x+=deltaX;
        this.y+=deltaY;
    }

    public void reflectHorizontal(){
        this.deltaX=-this.deltaX;
    }

    public void reflectVertical(){
        this.deltaY=-this.deltaY;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "(" + x +
                "," + y +
                "), speed(" + deltaX +
                "," + deltaY +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return x == ball.x && y == ball.y && radius == ball.radius &&
                deltaX == ball.deltaX && deltaY == ball.deltaY;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + Float.floatToIntBits(x);
        result = 31*result + Float.floatToIntBits(y);
        result = 31*result + Float.floatToIntBits(deltaX);
        result = 31*result + Float.floatToIntBits(deltaY);
        result = 31*result + radius;
        return result;
    }
}
