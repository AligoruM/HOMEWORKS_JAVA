package MyLinkedList;

public interface  ILinkedList <E> extends Iterable<E> {
    public void add(E elem);
    public void add(int index, E elem);
    public void clear();
    public E get(int index);
    public int indexOf(E elem);
    public void remove(int index);
    public E set(int index, E elem);
    public int size();
    public E[] toArray();
    public String toString();
}
