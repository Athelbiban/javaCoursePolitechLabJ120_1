package singlyLinkedList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        CustomList<Integer> list = new SinglyLinkedList<>();
        CustomList<Integer> list1 = new SinglyLinkedList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);

//        list.print(); // вывод на печать заполненной коллекции
//        list1.print(); // вывод на печать пустой коллекции
//        System.out.println();

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
//        System.out.println("===============метод forEach с головы до значения=============");
//        list.forEach(System.out::println, ForEachMode.HEAD_TARGET, 4);
//        System.out.println("===============метод forEach3 от значения до хвоста=============");
//        list.forEach(System.out::println, ForEachMode.TARGET_TAIL, 4);

        CustomList<Integer> doublyList1 = new DoublyLinkedList<>();
        doublyList1.add(1);
        doublyList1.add(3);
        doublyList1.add(5);
        doublyList1.add(7);

        Iterator<Integer> iter = doublyList1.iterator();
        System.out.println("++++++++++цикл while+++++++++++");
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("++++++++++цикл forEach (всё содержимое)+++++++++++");
        for (Integer t : doublyList1) {
            System.out.println(t);
        }
        System.out.println("++++++++++цикл forEach (всё содержимое от последнего элемента к первому)+++++++++++");
        doublyList1.forEach(System.out::println, ForEachMode.TAIL_HEAD, null);
        System.out.println("++++++++++цикл forEach (всё содержимое от головного до заданного)+++++++++++");
        doublyList1.forEach(System.out::println, ForEachMode.HEAD_TARGET, 5);
        System.out.println("++++++++++цикл forEach (всё содержимое от хвостового до заданного)+++++++++++");
        doublyList1.forEach(System.out::println, ForEachMode.TAIL_TARGET, 5);
    }
}
