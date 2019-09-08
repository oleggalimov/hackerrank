package org.oleggalimov;

import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque <Integer>deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max, counter;
        List <Integer> maxValues= new ArrayList<>();
        Set <Integer> temp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Integer num = in.nextInt();
            deque.add(num);
            temp.add(num);
            if (temp.size()==m) {
                maxValues.add(temp.size());
                temp.clear();
            }
        }
        Iterator<Integer> iterator;
        temp.clear();
        do {
            counter=0;
            deque.removeFirst();
            iterator = deque.iterator();
            while (iterator.hasNext()) {
                if (counter==m) {
                    maxValues.add(temp.size());
                    temp.clear();
                    break;
                } else {
                    temp.add(iterator.next());
                    counter++;
                }

            }
        } while (deque.size()>=m);
        System.out.println(Collections.max(maxValues));
    }
}
