package link;

import java.util.*;

public class DoubleLink<E> implements List<E> {

    private Node head = new Node(); // a head node with node data

    private Node tail = new Node(); // a tail node with node data

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        // binary search
        return indexOf(o)>=0;
    }


    @Override
    public boolean add(E element) {

        Node newNode = new Node(element);

        if (size == 0 ){
            head.next = newNode;
            newNode.pre = head;

            tail.pre = newNode;
            newNode.next = tail;
        }else{
            // the last node
            Node last = tail.pre;
            tail.pre = newNode;
            newNode.next = tail;

            newNode.pre = last;
            last.next = newNode;

        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0){
            return false;
        }

        Node current = head;

        while (current.next !=null){
            current = current.next;
            if (Objects.equals(current.data,o)){
                current.pre.next = current.next;
                size--;
                return true;
            }
        }

        return false;
    }



    @Override
    public void clear() {
        size = 0;
        head.next = null;
        tail.pre = null;
    }

    // binary search
    @Override
    public E get(int index) {

        checkIndex(index);

        int times = index+1;
        Node current;
        // find from tail
        if (index+1 > size/2){
            times = size-index;
             current = tail;
            while (times-->0){
                current = current.pre;
            }
        }else{ // find from head
             current = head;
            while (times-->0){
                current = current.next;
            }
        }
        return (E)current.data;
    }

    @Override
    public int indexOf(Object o) {
        if (head == null){
            return -1;
        }

        int count = size;

        Node current = head;

        for (int i = 0; i < count; i++){
            current = current.next;
            if ( Objects.equals(o,current.data)){
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int index){
        if (index<0 || index >=size){
            throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
        }
    }

    // to display the element in the link
    @Override
    public String toString(){
        Node current = head;
        if (size == 0) return "[]";

        StringBuilder result = new StringBuilder("[");

        for (int i = 0;i<size;i++){
            current = current.next;
            result.append(current.data);
            if (i != size-1){
                result.append(",");
            }
        }
        result.append("]");
        return  result.toString();
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //  inner class
    private class Node<E>{
        public E data; // data
        public Node pre; //  next node
        public Node next; //  next node
        public Node(){
        }
        public Node(E data){
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
