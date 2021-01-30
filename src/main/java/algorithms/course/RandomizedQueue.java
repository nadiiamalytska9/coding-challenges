package algorithms.course;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 1;

    private Item[] array;
    private int n;

    public RandomizedQueue() {
        array = (Item[]) new Object[INIT_CAPACITY];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (n == array.length) {
            resize(array.length * 2);
        }
        array[n++] = item;
    }

    private int randomIndex() {
        return StdRandom.uniform(0, n);
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIndex = randomIndex();
        Item removedItem = array[randomIndex];
        array[randomIndex] = null;
        if (n > 0 && n == array.length / 4) {
            resize(array.length / 2);
        }
        n--;
        return removedItem;
    }

    public Item sample() {
        if (this.isEmpty()) throw new NoSuchElementException();
        return array[randomIndex()];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] copyArray;
        private int index;

        public RandomizedQueueIterator() {
            copyArray = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                copyArray[i] = array[i];
            }
            StdRandom.shuffle(copyArray);
        }

        public boolean hasNext() {
            return index < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copyArray[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        StdOut.print("Is randomized queue empty: " + randomizedQueue.isEmpty() + "\n");
        while (!StdIn.isEmpty()) {
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                randomizedQueue.enqueue(item);
            }
            int size = randomizedQueue.size();
            StdOut.print("\nIs randomized queue empty: " + randomizedQueue.isEmpty());
            StdOut.print("\nSize of randomized queue: " + size);
            StdOut.print("\nget random item from queue: " + randomizedQueue.sample());

            StdOut.print("\nFirst iterator works: ");
            Iterator<String> firstIterator = randomizedQueue.iterator();
            while (firstIterator.hasNext()) {
                StdOut.print(firstIterator.next() + " ");
            }

            StdOut.print("\nSecond iterator works: ");
            for (String item :
                    randomizedQueue) {
                StdOut.print(item);
            }

            StdOut.print("\nRemove random item: ");
            StdOut.print(randomizedQueue.dequeue() + " ");

            StdOut.print(
                    "\nMultiple iterators are used simultaneously and operate independently of one another:\n");
            int n = 5;
            RandomizedQueue<Integer> intRandomQueue = new RandomizedQueue<>();
            for (int i = 0; i < n; i++) {
                intRandomQueue.enqueue(i);
            }
            for (int a : intRandomQueue) {
                for (int b : intRandomQueue)
                    StdOut.print(a + "-" + b + " ");
                StdOut.println();
            }
        }
    }
}
