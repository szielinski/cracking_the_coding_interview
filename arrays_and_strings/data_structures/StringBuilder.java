public class StringBuilder{
    private char[] characters;
    private int size;

    public StringBuilder(){
        characters = new char[10];
    }

    public void append(String s){
        for(int i=0; i<s.length(); i++){
            addCharacter(s.charAt(i));
        }
    }

    private void addCharacter(char c){
        if(size == characters.length)
            resize();
        characters[size] = c;
        size++;
    }

    public String toString(){
        return new String(characters);
    }
    
    private void resize(){
        char[] extendedArray = new char[characters.length * 2];
        for(int i=0; i<characters.length; i++)
            extendedArray[i] = characters[i];
        characters = extendedArray;
    }

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<100; i++){
            sb.append("test"+i + " ");
        }
        System.out.println(sb);
    }
}

