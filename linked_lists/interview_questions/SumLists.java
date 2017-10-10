import java.util.*;
public class SumLists {
    public static LinkedList<Integer> sumLists(LinkedList<Integer> first, LinkedList<Integer> second){
        LinkedList<Integer> summedList = new LinkedList<>();

        int carryOver = 0;
        Iterator<Integer> firstIterator = first.iterator();
        Iterator<Integer> secondIterator = second.iterator();
        while(firstIterator.hasNext() || secondIterator.hasNext() || carryOver > 0){
            int firstNumber = firstIterator.hasNext() ? firstIterator.next() : 0;
            int secondNumber = secondIterator.hasNext() ? secondIterator.next() : 0;
            int sum = firstNumber + secondNumber + carryOver;
            carryOver = sum / 10;
            summedList.add(sum % 10);
        }

        return summedList;
    }

    public static LinkedList<Integer> sumListsForwardOrder(LinkedList<Integer> first, LinkedList<Integer> second){
        int firstNumber = getNumber(first);
        int secondNumber = getNumber(second);

        return numberAsList(firstNumber + secondNumber);
    }

    public static int getNumber(LinkedList<Integer> list){
        int number = 0;
        for(Integer i : list){
            number *= 10;
            number += i;
        }
        return number;
    }

    public static LinkedList<Integer> numberAsList(int number){
        LinkedList<Integer> list = new LinkedList<>();
        while(number > 0){
            list.addFirst(number % 10);
            number /= 10;
        }
        return list;
    }

    public static void main(String[] args){
        LinkedList<Integer> first = new LinkedList<>();
        first.add(7);
        first.add(1);
        first.add(6);

        LinkedList<Integer> second = new LinkedList<>();
        second.add(5);
        second.add(9);
        second.add(2);
        
        System.out.println(sumLists(first, second));
        System.out.println(sumListsForwardOrder(first, second));

        LinkedList<Integer> third = new LinkedList<>();
        third.add(9);
        third.add(9);
        third.add(9);

        LinkedList<Integer> fourth = new LinkedList<>();
        fourth.add(9);
        fourth.add(9);
        fourth.add(9);


        System.out.println(sumLists(third, fourth));
        System.out.println(sumListsForwardOrder(third, fourth));
    }
}
