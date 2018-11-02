package Book;

import java.util.Objects;

public class Author {
    private String name;
    private String email;
    private char sex;

    public Author(String name, String email, char sex) {
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return sex == author.sex && name.equals(author.name) && email.equals(author.email);
        //Вопрос, если разные почты, можно ли считать, что автор не один и тот же?
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + sex;
        result = 31*result + name.hashCode();
        result = 31*result + email.hashCode();
        return result;
    }
}
