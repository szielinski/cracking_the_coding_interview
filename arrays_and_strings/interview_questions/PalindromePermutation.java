import java.util.*;
class PalindromePermutation {
    public static Map<Character, Integer> countCharacters(String s){
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character c = Character.toLowerCase(s.charAt(i));
            if(c == ' ')
                continue;
            if(charCount.containsKey(c))
                charCount.put(c, charCount.get(c)+1);
            else
                charCount.put(c, 1);
        }
        return charCount;
    }

    public static boolean isPalindromePermutation(String s){
        Map<Character, Integer> charCount = countCharacters(s);
        boolean foundOddCount = false;
        for(Character c : charCount.keySet()){
            if(charCount.get(c) % 2 == 1)
                if(foundOddCount)
                    return false;
                else
                    foundOddCount = true;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindromePermutation("Tact coa"));
        System.out.println(isPalindromePermutation("race car"));
        System.out.println(isPalindromePermutation("rar"));
        System.out.println(isPalindromePermutation("a"));

        System.out.println(isPalindromePermutation("car"));
        System.out.println(isPalindromePermutation("Tact coat"));
        System.out.println(isPalindromePermutation("ar"));
    }
}
