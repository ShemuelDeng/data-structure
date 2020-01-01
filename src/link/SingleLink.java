package link;

import java.util.*;

public class SingleLink<E> implements List<E> {

    private Node<E> head; // head node with no data

    private int size; // the size of the link

    @Override
    public int size() {
        return this.size ;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        return indexOf(o)>=0;
    }


    @Override
    public boolean add(E element) {

        Node newNode = new Node(element);

        if (head == null){
            head = newNode;
            size++;
            return true;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (head == null){
            return false;
        }

        if (Objects.equals(head.data,o)){
            head = head.next;
            size--;
            return  true;
        }

        Node current = head;
        while(current.next != null){
            if (Objects.equals(current.next.data,o)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        Node current = head;
        while (index-->0){
            current = current.next;
        }

        return (E)current.data;
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);

        Node newNode = new Node(element);

        if (index == 0){
            if (head != null){
                newNode.next = head.next;
                head = newNode;
            }else{
                head=newNode;
            }
            return element;
        }

        Node current = head;
        Node pre = current;
        while (index-->0){
            pre = current;
            current = current.next;
        }

        pre.next = newNode;
        newNode.next = current.next;
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        Node newNode = new Node(element);
        if (index == 0){
            if (head != null){
                newNode.next = head;
                head = newNode;
            }else{
                head=newNode;
            }
            size++;
            return;
        }

        Node current = head;
        Node pre = current;
        while (index-->0){
            pre = current;
            current = current.next;
        }
        pre.next = newNode;
        newNode.next = current;
        size++;
    }

    @Override
    public E remove(int index) {

        checkIndex(index);

        if (index == 0){
            Object removeValue = head.data;
            head = head.next;
            size--;
            return (E)removeValue;
        }

        Node current = head;
        Node pre = current;
        while (index-->0){
            pre = current;
            current = current.next;
        }
        pre.next = current.next;
        size--;
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
            if (Objects.equals(current.data,o)){
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    // to display the element in the link
    @Override
    public String toString(){
        Node current = head;
        if (head == null) return "[]";

        StringBuilder result = new StringBuilder("[");

        while (current.next != null){
            result.append(current.data).append(",");
            current = current.next;
        }
        result.append(current.data);
        result.append("]");
        return  result.toString();
    }

    private void checkIndex(int index){
        if (index<0 || index >=size){
            throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
        }
    }
    private void checkIndexForAdd(int index){
        if (index<0 || index >size){
            throw new IndexOutOfBoundsException("size:"+size+", index:"+index);
        }
    }


    public void reverse(){

    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    //  inner class
    private class Node<E>{
        public E data; // data
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
