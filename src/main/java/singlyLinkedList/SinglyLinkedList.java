package singlyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements CustomList<T> {
    private Node head;
    private Node tail;

    // добавление значения в начало списка
    @Override
    public void insert(T data) {
        Node temp = new Node(data, head);
        if (head == null) {
            head = tail = temp;
        }
        else {
            head = temp;
        }
    }

    // извлечение значения из начала списка без его удаления
    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    // извлечение значения из начала списка с удалением
    @Override
    public T getFirstAndDel() {
        if (head != null) {
            T temp = head.data;
            head = head.next;
            return temp;
        }
        else {
            return null;
        }
    }

    // добавление значения в конец списка
    @Override
    public void add(T data) {
        Node temp = new Node(data, null);
        if (!listEmpty()) {
            tail.next = temp;
            tail = temp;
        }
        else {
            head = tail = temp;
        }
    }

    // извлечение значения из конца списка без его удаления
    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    // извлечение значения из конца списка с удалением
    @Override
    public T getLastAndDel() {
        if (tail != null) {
            T tempTailData = tail.data;

            if (head == tail) {
                head = null;
                tail = null;
                return tempTailData;
            }

            Node tempHead = head;
            while (head.next != tail) {
                head = head.next;
            }

            tail = head;
            tail.next = null;
            head = tempHead;
            return tempTailData;
        }
        else {
            return null;
        }
    }

    // определение, содержит ли заданное значение
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

    // определение, является ли пустым
    @Override
    public Boolean listEmpty() { return head == null; }
    // печать всех значений списка
    @Override
    public void print() {
        System.out.println(this);
    }

    // *удаление заданного значения из списка
    @Override
    public void remove(T data) {
        if (!listEmpty()) {
            Node tempHead = head;
            Node previousNode = null;
            while (head != null) {
                if (head.data.equals(data)) {
                    if (head == tempHead) {
                        tempHead = head.next;
                    }
                    else {
                        previousNode.next = head.next;
                    }
                }
                previousNode = head;
                head = head.next;
            }
            head = tempHead;
        }
    }

    // *выполнение действия, заданного в параметре метода
//    public static void callCommand(Command command) {
//        command.execute();
//    }

//    public void incrementAll(T value) {
//        if (!listEmpty()) {
//            Node tempHead = head;
//            while (head != null) {
//                head.data += value;
//                head = head.next;
//            }
//            head = tempHead;
//        }
//    }

     // переопределенный toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            sb.append(temp.next != null ? ", " : "");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator(head);
    }

    public void forEach(Consumer<? super T> action, T toValue) {
        if (action != null) {
            for (T t : this) {
                action.accept(t);
                if (t.equals(toValue)) {
                    break;
                }
            }
        }
    }

    public void forEach(T fromValue, Consumer<? super T> action) {
        if (action != null) {
            boolean flag = false;
            for (T t : this) {
                if (t.equals(fromValue) || flag) {
                    action.accept(t);
                    flag = true;
                }
            }
        }
    }

    private class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
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
