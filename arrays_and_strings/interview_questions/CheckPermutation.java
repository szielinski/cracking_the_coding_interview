import java.util.*;

public class CheckPermutation {
    public static boolean isPermutation(String first, String second){
        if(first.length() != second.length())
            return false;

        Map<Character, Integer> firstCharCount = countCharacters(first);
        Map<Character, Integer> secondCharCount = countCharacters(second);

        for(Character c : firstCharCount.keySet()){
            if(!secondCharCount.containsKey(c) || firstCharCount.get(c) != secondCharCount.get(c))
                return false;
        }
        return true;
    }

    public static Map<Character, Integer> countCharacters(String s){
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(charMap.containsKey(c))
                charMap.put(c, charMap.get(c)+1);
            else
                charMap.put(c, 1);
        }
        return charMap;
    }

    public static void assertPermutation(String s1, String s2){
        if(isPermutation(s1,s2))
            System.out.println(s1 + " is a permutation of " + s2);
        else
            System.out.println(s1 + " is not a permutation of " + s2);
    }

    public static void main(String[] args){
        String one = "testString";
        String two = "Stringtest";
        
        assertPermutation(one, two);
        assertPermutation(one, one);

        String three = "testStrings";
        assertPermutation(one, three);
        String four = "somethingElse";
        assertPermutation(one, four);
        String five = "";
        assertPermutation(one, five);
        assertPermutation(five, one);
        assertPermutation(five, five);
        String six = "testString1";
        assertPermutation(one, six);
        String seven = "teststring";
        assertPermutation(one, seven);
    }
}

