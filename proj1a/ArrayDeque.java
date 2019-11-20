import java.util.Random;
public class ArrayDeque<T> {
    int numOfItems;
    int capacity;
    int nextFirst;
    int nextLast;

    T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        numOfItems = 0;
        capacity = 8;
        nextFirst = 4;
        nextLast = 5;
    }
    private void resize() {
        if (numOfItems < capacity * 0.3 && capacity > 15) {
            //downsizing
            int first = nextFirst;
            int last = nextLast;
            T[] newItems = (T[]) new Object[capacity / 2];
            int counter = 0;

            if (first != capacity - 1) {
                first += 1;
            } else {
                first =0;
            }

            while (first != last) {


                System.out.print(items[first] + " ");
                newItems[counter] = items[first];

                counter += 1;
                if (first != capacity - 1) {
                    first += 1;
                } else {
                    first =0;
                }
            }
            capacity /= 2;
            nextFirst = capacity - 1;
            nextLast = counter;
            items = newItems;


        } else if (numOfItems > capacity * 0.8) {
            //upsizing
            int first = nextFirst;
            int last = nextLast;
            T[] newItems = (T[]) new Object[capacity * 2];
            int counter = 0;

            if (first != capacity - 1) {
                first += 1;
            } else {
                first =0;
            }

            while (first != last) {


                System.out.print(items[first] + " ");
                newItems[counter] = items[first];

                counter += 1;
                if (first != capacity - 1) {
                    first += 1;
                } else {
                    first =0;
                }
            }
            capacity *= 2;
            nextFirst = capacity - 1;
            nextLast = counter;
            items = newItems;
        }
    }

    public void addFirst(T item) {

        numOfItems += 1;
        items[nextFirst] = item;
        if (nextFirst != 0) {
            nextFirst -= 1;
        } else {
            nextFirst = capacity - 1;
        }
        resize();
    }
    public void addLast(T item) {
        numOfItems += 1;
        items[nextLast] = item;
        if (nextLast != capacity - 1) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        resize();
    }
    public boolean isEmpty() {
        return numOfItems == 0;
    }
    public int size() {
        return numOfItems;
    }
    public void printDeque() {
        /*
        for(T a: items) {
            System.out.print(a + ", ");
        }
        */

        System.out.println("items, " + numOfItems + " capacity, " + capacity);

    }

    public T removeFirst() {
        int first = nextFirst;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first = first + 1;
        }
        T toremove = items[first];
        items[first] = null;
        numOfItems -= 1;
        nextFirst = first;
        resize();
        return toremove;
    }
    public T removeLast() {
        int last = nextLast;
        if (last == 0) {
            last = capacity - 1;
        } else {
            last = last - 1;
        }
        T toremove = items[last];
        items[last] = null;
        numOfItems -= 1;
        nextLast = last;
        resize();
        return toremove;

    }
    public T get(int index) {
        int first = nextFirst;
        int last = nextLast;

        int counter = 0;

        if (first != capacity - 1) {
            first += 1;
        } else {
            first =0;
        }

        while (counter < index) {


            counter += 1;
            if (first != capacity - 1) {
                first += 1;
            } else {
                first =0;
            }
        }
        return items[first];
    }
    public T getRecursive(int index) {
        return get(index);
    }
}
