import java.util.*;
public class Palindrome{
    public static boolean isPalindrome(LinkedList<? extends Object> list){
        int count = 0;
        LinkedList<Object> halfReversed = new LinkedList<>();
        Iterator<? extends Object> listIterator = list.iterator();
        while(count < list.size()/2){
            Object o = listIterator.next();
            halfReversed.addFirst(o);
            count++;
        } 
        if(list.size() % 2 == 1){
            listIterator.next();
            count++;
        }
        Iterator<? extends Object> halfReversedIterator = halfReversed.iterator();
        while(count < list.size()){
            if(!listIterator.next().equals(halfReversedIterator.next()))
                return false;
            count++;
        }
        return true;
    }

    public static void main(String[] args){
        String racecar = "racecar";
        String raceecar = "raceecar";
        String nonpalindrome = "racecaR";

        LinkedList<Character> l1 = new LinkedList<>();
        LinkedList<Character> l2 = new LinkedList<>();
        LinkedList<Character> l3 = new LinkedList<>();

        for(int i=0; i<racecar.length(); i++){
            l1.add(racecar.charAt(i));
        }
        for(int i=0; i<raceecar.length(); i++){
            l2.add(raceecar.charAt(i));
        }
        for(int i=0; i<nonpalindrome.length(); i++){
            l3.add(nonpalindrome.charAt(i));
        }

        System.out.println(isPalindrome(l1));
        System.out.println(isPalindrome(l2));
        System.out.println(isPalindrome(l3));
    }
}
