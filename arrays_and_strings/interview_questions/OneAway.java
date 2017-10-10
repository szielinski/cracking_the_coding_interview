import java.lang.*;

class OneAway {
    public static boolean isDiffByAtMostOneChar(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;
        int equalStartIndex = 0;
        while(equalStartIndex < s1.length()  && equalStartIndex < s2.length() && s1.charAt(equalStartIndex) == s2.charAt(equalStartIndex))
            equalStartIndex++;
        if(equalStartIndex == s1.length() && equalStartIndex == s2.length())
            return true;
        int equalEndIndex = 0;
        while(s1.length() - equalEndIndex > 0 && s2.length() - equalEndIndex > 0 && s1.charAt(s1.length()-1-equalEndIndex) == s2.charAt(s2.length()-1-equalEndIndex))
            equalEndIndex++;
        equalEndIndex = Math.max(s1.length(), s2.length()) - equalEndIndex;
        return Math.abs(equalEndIndex - equalStartIndex) <= 1;
    }

    public static void main(String[] args){
        String s1 = "test string";
        System.out.println(isDiffByAtMostOneChar(s1, "tesxt string"));
        System.out.println(isDiffByAtMostOneChar(s1, "teststring"));
        System.out.println(isDiffByAtMostOneChar(s1, "test String"));
        System.out.println(isDiffByAtMostOneChar("", "t"));
        System.out.println(isDiffByAtMostOneChar("t", ""));
        System.out.println(isDiffByAtMostOneChar("", ""));
        System.out.println(isDiffByAtMostOneChar("at", "t"));
        System.out.println(isDiffByAtMostOneChar("t", "ta"));

        System.out.println(isDiffByAtMostOneChar(s1, "test SString"));
        System.out.println(isDiffByAtMostOneChar(s1, "test Strixng"));
        System.out.println(isDiffByAtMostOneChar(s1, "testtring"));
        System.out.println(isDiffByAtMostOneChar("att", "t"));
    }
}
