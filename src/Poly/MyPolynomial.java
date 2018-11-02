package Poly;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coef;

    public MyPolynomial(double... coef) {
        this.coef = coef;
    }

    public int getDegree(){
        return coef.length-1;
    }

    public double evaluate(double x)
    {
        double eval = 0;
        for (int i = 0; i < this.coef.length; i++)
        {
            eval += coef[i] * Math.pow(x, i);
        }
        return eval;
    }
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (int i = this.coef.length - 1; i > 1; i--)
        {
            str.append(coef[i] + "x^" + i + "+");
        }
        str.append(coef[1] + "x" + "+" + coef[0]);
        return str.toString();
    }

    public MyPolynomial multiply(MyPolynomial another)
    {
        MyPolynomial poly;
        double[] coeffs = new double[(this.coef.length - 1) + (another.coef.length - 1) + 1];
        for (int i = 0; i < this.coef.length; i++)
        {
            for (int j = 0; j < another.coef.length; j++)
            {
                coeffs[i + j] += this.coef[i] * another.coef[j];
            }
        }
        poly = new MyPolynomial(coeffs);
        return poly;
    }

    public MyPolynomial add(MyPolynomial another)
    {
        MyPolynomial poly;
        double[] coeffs = new double[Math.max(this.coef.length, another.coef.length)];
        for (int i = 0; i < Math.max(this.coef.length, another.coef.length); i++)
        {
            try
            {
                coeffs[i] += this.coef[i];
            }
            catch (ArrayIndexOutOfBoundsException e)
            {

            }
            try
            {
                coeffs[i] += another.coef[i];
            }
            catch (ArrayIndexOutOfBoundsException e)
            {

            }
        }
        poly = new MyPolynomial(coeffs);
        return poly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coef, that.coef);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coef);
    }
}
