class URLify {
    public static void urlify(char[] input){
        int nextFreeIndex = input.length-1;
        int i=input.length-1;
        int numberOfSpaces = 0;
        while(input[i] == ' '){
            i--;
            numberOfSpaces++;
        }
        numberOfSpaces/=2;
        while(i>=0){
            if(input[i] == ' '){
                numberOfSpaces--;
                int index = i+2*numberOfSpaces;
                input[index] = '%';
                input[index+1] = '2';
                input[index+2] = '0';
                nextFreeIndex-=3;
            } else if (numberOfSpaces>0) {
               input[nextFreeIndex] = input[i];
               nextFreeIndex--;
            }
            i--;
        }
    }

    public static void main(String[] args){
        char[] c = {'M','r', ' ', 'J', 'o','h','n',' ','S','m','i','t','h',' ', ' ', ' ', ' '};
        urlify(c);
        System.out.println(c);
    }
}


