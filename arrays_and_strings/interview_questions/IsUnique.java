public class IsUnique{
    public static boolean isUnique(char[] s){
        s = inPlaceSort(s);
        Character previousChar = s[0];
        for(int i=1; i<s.length; i++){
            if(previousChar.equals(s[i]))
                return false;
            previousChar = s[i];
        }
        return true;
    }

    public static char[] inPlaceSort(char[] s){
       for(int i=0; i<s.length; i++){
           int index = i;
           for(int j=i+1; j<s.length; j++){
               if(s[j] < s[index])
                   index= j;
           }
           char tmp = s[i];
           s[i] = s[index];
           s[index] = tmp;
       }
       System.out.println(s);
       return s;
    }

    public static void main(String[] args){

        System.out.println(IsUnique.isUnique(new String("Test string 1").toCharArray()));
        System.out.println(IsUnique.isUnique(new String("yunfdewxp").toCharArray()));
        System.out.println(IsUnique.isUnique(new String("ypunfdewxp").toCharArray()));
    }
}

