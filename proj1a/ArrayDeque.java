import java.util.Random;
public class ArrayDeque<T> {
    int numOfItems;
    int capacity;
    int nextFirst;
    int nextLast;

    T[] items;
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();

        int counter = 0;
        Random r = new Random();
        for (int i=0;i<10;i++) {
            int front = r.nextInt(10);
            int end = r.nextInt(10);
            for (int j=0;j<front;j++) {
                a.addFirst(counter);
                a.printDeque();
                counter++;
            }
            for (int j=0;j<end;j++) {
                a.addLast(counter);
                a.printDeque();
                counter++;
            }



        }

    }
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


        } else if (numOfItems > capacity * 0.6) {
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
        for(T a: items) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    /*
    public T removeFirst() {

    }
    public T removeLast() {

    }
    public T get(int index) {

    }
    public T getRecursive(int index) {

    }*/
}
