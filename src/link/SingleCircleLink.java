package link;

import java.util.*;

/**
 * Created by dengshaoxiang on 2020/1/3 15:26
 * description:单向循环链表
 */
public class SingleCircleLink<E> implements List<E>{
    private Node<E> head; 
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
        return indexOf(o)>-1;
    }

    @Override
    public int indexOf(Object o) {

        if (head == null) return -1;

        Node current = head;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.item,o)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        size = 0;
    }

    
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * @description: 尾插法,遍历链表 找到next指向 head的节点,即为最后一个节点
     * @param e
     * @date: 2020/1/6 11:26
     * @author: dengshaoxiang
     */
    private void linkLast(E e){
        Node<E> newNode = new Node<>(e,head);
        if (head == null){
            head = newNode;
        }else{
            Node<E> current = head;
            while (Objects.equals(current.next,head)){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    @Override
    public boolean remove(Object o) {
        // 链表为空
        if (head == null) throw new NoSuchElementException();

        // 删除头节点
        if (Objects.equals(head.item,o)){
            // 且链表只用头节点
            if (Objects.equals(head.next, head)) {
                head.next = null;
                size--;
                return true;
            }
            // 删除头节点 且链表中有n个节点,找到最后一个节点,将其next指向head.next
            Node current = head;
            while (!Objects.equals(current.next,head)){
                current = current.next;
            }
            current.next = head.next;
            head = head.next; // 头指针后移
            size--;
            return true;
        }

        // 删除中间元素
        Node current = head;
        // 遍历到最后一个节点
        while (!Objects.equals(current.next,head)){
            if (Objects.equals(current.next.item,o)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;

        }
        return false;
    }
    
    @Override
    public E get(int index) {
        if (index < 0 || index>= size) throw new IndexOutOfBoundsException("索引越界");
        Node current = head;
        while (index-- > 0){
            current = current.next;
        }

        return (E)current.item;
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

    private static class Node<E>{
        E item;
        Node<E> next;
        public Node(E item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}
