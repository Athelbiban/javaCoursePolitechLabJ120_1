package linkedList;

import java.util.function.Consumer;

public interface CustomList<T> extends Iterable<T> {

    void add(T data);
    void insert(T data);
    void remove(T data);
    T getLast();
    T getFirst();
    T getFirstAndDel();
    T getLastAndDel();
    Boolean isExist(T data);
    Boolean listEmpty();
    void print();
    void forEach(Consumer<? super T> action, ForEachMode mode, T targetValue);

}
