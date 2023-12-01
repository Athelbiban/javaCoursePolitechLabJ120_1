package singlyLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        CustomList<Integer> list = new SinglyLinkedList<>();
        CustomList<Integer> list1 = new SinglyLinkedList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);

        list.print(); // вывод на печать заполненной коллекции
        list1.print(); // вывод на печать пустой коллекции
        System.out.println();

//        list.print();
//        Iterator<Integer> iterator = list.iterator();
//        System.out.println("===============цикл while==============");
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        System.out.println("===============цикл forEach==============");
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//        System.out.println("===============метод forEach==============");
//        list.forEach(System.out::println);
//        System.out.println("===============метод forEach2=============");
//        list.forEach(System.out::println, 4);
//        System.out.println("===============метод forEach3=============");
//        list.forEach(4, System.out::println);

        CustomList<Integer> doublyList1 = new DoublyLinkedList<>();
        doublyList1.add(1);
        doublyList1.add(3);
        doublyList1.add(5);
        doublyList1.add(7);
        doublyList1.print();

        Iterator<Integer> iter = doublyList1.iterator();
        System.out.println("++++++++++цикл while+++++++++++");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
