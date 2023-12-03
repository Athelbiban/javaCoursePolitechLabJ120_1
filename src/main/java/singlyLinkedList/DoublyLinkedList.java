package singlyLinkedList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList<T> implements CustomList<T> {
    private Node head;
    private Node tail;

    @Override
    public void insert(T data) {
        Node temp = new Node(data, head, null);
        if (!listEmpty()) {
            head = tail = temp;
        }
        else {
            head = temp;
        }
    }

    @Override
    public void add(T data) {
        Node temp = new Node(data, null, tail);
        if (listEmpty()) {
            head = tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    @Override
    public void remove(T data) {
        if (!listEmpty()) {
            Node tempHead = head;
            while (head != null) {
                if (head.data.equals(data)) {
                    if (head == tempHead) {
                        tempHead = head.next;
                        tempHead.previous = null;
                    }
                    else if (head != tail) {
                        head.previous.next = head.next;
                        head.next.previous = head.previous;
                    }
                    else {
                        tail = tail.previous;
                        tail.next = null;
                    }
                }
                head = head.next;
            }
            head = tempHead;
        }
    }

    @Override
    public T getLast() { return tail.data; }

    @Override
    public T getFirst() { return head.data; }

    @Override
    public T getFirstAndDel() {
        if (!listEmpty()) {
            T result = head.data;
            head = head.next;
            head.previous = null;
            return result;
        }
        return null;
    }

    @Override
    public T getLastAndDel() {
        if (!listEmpty()) {
            T result = tail.data;
            tail = tail.previous;
            tail.next = null;
            return result;
        }
        return null;
    }

    @Override
    public Boolean isExist(T data) {
        if (!listEmpty()) {
            Node tempHead = head;
            while (head != null) {
                if (head.data.equals(data)) {
                    head = tempHead;
                    return true;
                }
                head = head.next;
            }
            head = tempHead;
        }
        return false;
    }

    @Override
    public Boolean listEmpty() { return head == null; }

    @Override
    public void print() { System.out.println(this); }

    @Override
    public void forEach(Consumer<? super T> action, T data) {

    }

    @Override
    public void forEach(T fromValue, Consumer<? super T> action) {

    }

    // всё содержимое списка от последнего элемента к первому
    public void forEachReverse(Consumer<? super T> action) {
        Node tempTail = tail;
        while (tempTail != null) {
            action.accept(tempTail.data);
            tempTail = tempTail.previous;
        }
    }

    // всё содержимое списка от головного узла до заданного значения
    public void forEachTo(Consumer<? super T> action, T toValue) {
        if (action != null) {
            for (T t : this) {
                action.accept(t);
                if (t.equals(toValue)) {
                    break;
                }
            }
        }
    }

    // всё содержимое от хвостового узла до заданного значения
    public void forEachReverseTo(Consumer<? super T> action, T toValue) {
        if (action != null) {
            this.forEachReverse(action);
        }
    }

    // добавление всех значений заданного массива в начало списка
    public void insertArray(DoublyLinkedList list, T[] data) {
        if (data != null) {
            for (int i = 0; i < data.length / 2; i++) {
                T temp = data[i];
                data[i] = data[data.length - i - 1];
                data[data.length - i - 1] = temp;
            }
            for (T i : data) {
                list.insert(i);
            }
        }
    }

    // добавление всех значений заданной коллекции в начало списка
    public void insertCollection(DoublyLinkedList list, Iterable<T> collection) {
        if (list != null && collection != null) {
            Collections.reverse((List<T>) collection);
            for (T i : collection) {
                list.insert(i);
            }
            Collections.reverse((List<T>) collection);
        }
    }

    // добавление всех значений заданного массива/коллекции в конец списка
    public void addArray(DoublyLinkedList list, T[] data) {
        if (data != null) {
            for (T i : data) {
                list.add(i);
            }
        }
    }

    public void addCollection(DoublyLinkedList list, Iterable<T> collection) {
        if (collection != null) {
            for (T i : collection) {
                list.add(i);
            }
        }
    }

    // поглощение одного списка другим с добавлением второго в начало/конец и очисткой второго
    public void takeoverAndInsert(DoublyLinkedList list, List<T> data) {
        if (data != null) {
            Collections.reverse(data);
            for (T i : data) {
                list.insert(i);
            }
            data.clear();
        }
    }

    public void takeoverAndAdd(DoublyLinkedList list, List<T> data) {
        if (data != null) {
            for (T i : data) {
                list.add(i);
            }
            data.clear();
        }
    }

    // печать всех значений списка в прямом/обратном порядке
    public static void printInDirectOrder(DoublyLinkedList list) { list.print(); }

    public void printInReverseOrder() {
        if (head != null) {
            Node tempHead = head;
            DoublyLinkedList copyList = new DoublyLinkedList();
            while (tempHead != null) {
                copyList.insert(tempHead.data);
                tempHead = tempHead.next;
            }
            copyList.print();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node tempHead = head;
        while (tempHead != null) {
            sb.append(tempHead.data);
            sb.append(tempHead.next != null ? ", " : "");
            tempHead = tempHead.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(head);
    }

    private class Node {
        T data;
        Node next;
        Node previous;

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private class MyIterator implements Iterator<T> {
        Node head;
        Node current;

        public MyIterator(Node head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            current = current == null ? head : current.next;
            return current != null;
        }

        @Override
        public T next() {
            return current != null ? current.data : null;
        }
    }
}
