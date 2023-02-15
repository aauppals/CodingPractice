package implementLinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node; //insert before last node
            last = node;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) first = last = node;
        else {
            node.next = first; //prepend to first node
            first = node;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        // [10 -> 20 -> 30]
        // first -> 10
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        Node nextNode = first.next;
        first = nextNode;
        first.next = null;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }
        //[10 -> 20 -> 30]
        //previous -> 20
        //change last from 30 to 20
        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(40);
        System.out.println(list.indexOf(40));
        System.out.println(list.contains(40));
        list.removeFirst();
        System.out.println(list.contains(10));


    }
}
