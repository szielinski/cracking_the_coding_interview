class StringCompression {
    public static String compress(String s){
        char[] compressed = new char[s.length()];
        int nextIndex = 0;

        Character character = null;
        Integer count = null;
        for(int i=0; i<s.length(); i++){
            //does not handle counts > 10 at end of array
            if(nextIndex+1>compressed.length)
                return s;
            System.out.println(compressed);
            if(character == null){
                character = s.charAt(i);
                count = 1;
            } else if (character != s.charAt(i)){
                compressed[nextIndex++] = character;
                //reduce the number of toString calls
                for(int j=0; j<count.toString().length(); j++){
                    compressed[nextIndex++] = count.toString().charAt(j);
                }
                character = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        if(character != null){
            compressed[nextIndex++] = character;
            //reduce the number of toString calls
            for(int j=0; j<count.toString().length(); j++){
                compressed[nextIndex++] = count.toString().charAt(j);
            }
        }
        return new String(compressed);
    }

    public static void main(String[] args){
        System.out.println(compress("aabcccccaaa"));
    }
}


