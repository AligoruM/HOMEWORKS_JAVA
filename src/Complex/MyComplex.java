package Complex;

import java.util.Objects;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public MyComplex() {
        this.real=0;
        this.real=0;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real=real;
        this.imag=imag;
    }

    @Override
    public String toString() {
        return "(" + real + (imag >= 0 ? '+': "") + imag + "i)";
    }

    public boolean isReal(){
        if (real!=0)
            return true;
        else return false;
    }

    public boolean isImaginary(){
        /*if (imag!=0)
            return true;
        else return false;*/
        return imag!=0;             //Тут попробовал так, но мне кажется что так менее читаемо...
    }

    public boolean equals(double real, double imag){
        if(this.real == real && this.imag==imag)
            return true;
        else return false;
    }

    public boolean equals(MyComplex another){
        if(this.real == another.getReal() && this.imag==another.getImag())
            return true;
        else return false;
    }

    public double magnitude(){
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument() {
        if (real > 0) {
            return Math.atan(imag / real);
        } else if (real < 0 && imag >= 0) {
            return Math.PI + Math.atan(imag / real);
        } else if (real < 0 && imag < 0) {
            return -Math.PI + Math.atan(imag / real);
        } else if (real == 0 && imag > 0) {
            return Math.PI / 2;
        } else {
            return -Math.PI / 2;
        }
    }

    public MyComplex add(MyComplex right){
        this.real+=right.getReal();
        this.imag+=right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right){
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }

    public MyComplex subtract(MyComplex right){
        this.real-=right.getReal();
        this.imag-=right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        return new MyComplex(this.real - right.real, this.imag - right.imag);
    }

    public MyComplex multiply(MyComplex right){
        double b_real = this.real*right.real - this.imag*right.imag;
        this.imag = this.real*right.imag + this.imag*right.real;
        this.real=b_real;
        return this;
    }

    public MyComplex divide(MyComplex right){
        double b_real = (this.real*right.real + this.imag*right.imag) / (right.real*right.real + right.imag*right.imag);
        this.imag = (right.real*this.imag - this.real*right.imag) / (right.real*right.real + right.imag*right.imag);
        this.real=b_real;
        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(this.real, -this.imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return myComplex.real == real && myComplex.imag == imag;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + (int)(Double.doubleToLongBits(real)^(Double.doubleToLongBits(real)>>>32));
        result = 31*result + (int)(Double.doubleToLongBits(imag)^(Double.doubleToLongBits(imag)>>>32));
        return result;
    }
}
