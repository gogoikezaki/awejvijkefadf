import java.util.Random;

public class LinkedListDeque<T> {
    private node sentinel;
    private int size;
    private class node {


        public T item;
        public node next;
        public node prev;
        public node(T i, node nxt, node pv) {
            item = i;
            next = nxt;
            prev = pv;
        }
        public node() {
            item = null;
            next = this;
            prev = this;
        }
    }





    public LinkedListDeque() {
        sentinel = new node();
    }
    public void addFirst(T item) {
        size = size + 1;
        sentinel.next = new node(item, sentinel.next, sentinel);
        if (size == 1) {
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next.next.prev = sentinel.next;
        }

    }
    public void addLast(T item) {
        size = size + 1;
        sentinel.prev = new node(item, sentinel, sentinel.prev);
        if (size == 1) {
            sentinel.next = sentinel.prev;
        } else {
            sentinel.prev.prev.next = sentinel.prev;
        }

    }
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        node pointer = sentinel.next;
        while (pointer!= sentinel) {
            System.out.print(" " + pointer.item);
            pointer = pointer.next;
        }
        System.out.println();
    }
    public T removeFirst() {
        if (size > 0) {
            size = size - 1;
            T res = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            if (size<2) {
                sentinel.prev = sentinel.next;
            }

            return res;
        }
        return null;
    }
    public T removeLast() {
        if (size > 0) {
            size = size - 1;
            T res = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            if (size<2) {
                sentinel.next = sentinel.prev;
            }
            return res;
        }
        return null;
    }
    public T get(int index) {
        if (index < size && index >= 0) {
            node ptr = sentinel;
            for (int i=0; i<index+1; i++) {
                ptr = ptr.next;
            }
            return ptr.item;
        }
        return null;
    }
    public T getRecursive(int index) {
        return get(index);
    }

}
