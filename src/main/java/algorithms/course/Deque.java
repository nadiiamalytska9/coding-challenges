package algorithms.course;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> previous;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.previous = null;
        first.next = oldFirst;

        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.previous = first;
        }
        n++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        last.previous = oldLast;

        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item removedItem = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        else {
            first.previous = null;
        }
        return removedItem;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item removedItem = last.item;
        last = last.previous;
        n--;
        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return removedItem;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> currentNode = first;

            public boolean hasNext() {
                return currentNode != null;
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Deque<String> firstDeque = new Deque<>();
        Deque<String> secondDeque = new Deque<>();

        StdOut.print("Is first deque empty: " + firstDeque.isEmpty() + "\n");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            firstDeque.addFirst(item);
            secondDeque.addLast(item);
        }
        int firstSize = firstDeque.size();
        int secondSize = secondDeque.size();
        StdOut.print("\nIs second deque empty: " + firstDeque.isEmpty());
        StdOut.print("\nSize of first deque: " + firstSize);

        StdOut.print("\nIterator works for the first deque: ");
        Iterator<String> iterator = firstDeque.iterator();
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }

        StdOut.print("\nIterator works for the second deque: ");
        for (String item : secondDeque) {
            StdOut.print(item + " ");
        }

        StdOut.print("\nRemove last item: ");
        for (int i = 0; i < firstSize; i++) {
            StdOut.print(firstDeque.removeLast() + " ");
        }

        StdOut.print("\nRemove first item: ");
        for (int i = 0; i < secondSize; i++) {
            StdOut.print(secondDeque.removeFirst() + " ");
        }
    }
}
