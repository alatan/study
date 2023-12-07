package javaBase.container.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Client {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        System.out.println(arrayList.get(0));
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.addFirst("b");
        System.out.println(linkedList.getFirst());
    }
}
