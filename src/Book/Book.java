package Book;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this(name, authors, price);
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book {" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public String getAuthorsNames(){
        StringBuilder buf = new StringBuilder();
        for (Author tmp:authors) {
            buf.append(tmp.getName()).append(", ");
        }
        return buf.substring(0, buf.length() - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return  price == book.price && qty == book.qty &&
                name.equals(book.name) &&
                Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + (int)(Double.doubleToLongBits(price)^(Double.doubleToLongBits(price)>>>32));
        result = 31*result + qty;
        result = 31*result + name.hashCode();
        result = 31*result + Arrays.hashCode(authors);
        return result;
    }
}
