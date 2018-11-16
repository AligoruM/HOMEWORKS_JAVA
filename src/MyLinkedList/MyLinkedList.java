package MyLinkedList;

import java.util.Iterator;


public class  MyLinkedList <E> implements ILinkedList<E> {


    private int size = 0;

    private transient Node<E> first;
    private transient Node<E> last; //т.к в конец листа часто приходится что-то добавлять, будет полезно иметь это поле

    public MyLinkedList(){

    }

    private void linkFirst(E elem){
        Node<E> prevFirst = first;
        Node<E> newFirst = new Node(elem, prevFirst);
        first = newFirst;
        if(prevFirst == null){
            last = newFirst;
        }
        size++;
    }

    private void linkLast(E elem){
        Node<E> prevLast = last;
        Node<E> newLast = new Node(elem, null);
        last = newLast;
        if(prevLast == null){
            first = newLast;
        }else {
            prevLast.next = newLast;
        }
        size++;
    }

    private void linkBefore(E elem, int index){
        if(index==0){
            linkFirst(elem);
        }else {
            Node<E> newNode = new Node<>(elem, node(index));
            node(index - 1).next = newNode;
            size++;
        }
    }

    private Node<E> node(int index){
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
    }

    private void unlinkFirst(Node<E> node){
        Node<E> newFirst = node.next;
        node.next = null;
        node.item = null;
        first = newFirst;
        if(newFirst == null){
            last=null;
        }
        size--;
    }

    private void unlink(int index){
        if(index == 0){
            unlinkFirst(node(0));
        } else{
            Node<E> x = node(index);
            node(index - 1).next = x.next;
            x.item = null;
            x.next = null;
            size--;
        }
    }

    @Override
    public void add(E elem) {
        linkLast(elem);
    }

    @Override
    public void add(int index, E elem) {
        checkPositionIndex(index);
        if(index == size ){
            linkLast(elem);
        }else {
            linkBefore(elem, index);
        }
    }

    @Override
    public void clear() {
        for(Node<E> x = first; x!=null;){
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        size=0;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public int indexOf(E elem) {
        int i = 0;
        if (elem == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return i;
                i++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (elem.equals(x.item))
                    return i;
                i++;
            }
        }

        return -1;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        unlink(index);
    }

    @Override
    public E set(int index, E elem) {
        checkElementIndex(index);
        E tmp = node(index).item;
        node(index).item = elem;
        return tmp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] arr = (E[]) new Object[size];
        Node<E> x = first;
        for(int i=0; i<size;i++){
            arr[i]=x.item;
            x = x.next;
        }
        return arr;
    }
    @Override
    public String toString(){
        Iterator<E> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<E>{
        private Node<E> cursor = first;
        @Override
        public boolean hasNext() {
            return !(cursor==null);
        }

        @Override
        public E next() {
            Node<E> tmp = cursor;
            cursor=cursor.next;
            return tmp.item;
        }
    }
}
