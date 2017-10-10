import java.util.*;

class Trie{
    private static final Character TERMINATOR = '$';

    static class Node {
        Map<Character, Node> children = new HashMap<>();
    }

    private Node trie = new Node();

    public void addWord(String s){
        Node n = trie;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!n.children.containsKey(c))
                n.children.put(c, new Node());
            n = n.children.get(c);
        }
        n.children.put(TERMINATOR, null);
    }

    public boolean isWord(String s){
        Node n = trie;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!n.children.containsKey(c))
                return false;
            n = n.children.get(c);
        }
        return n.children.containsKey(TERMINATOR);
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.addWord("ring");
        trie.addWord("test");
        trie.addWord("fire");
        System.out.println(trie.isWord("ring"));
        System.out.println(trie.isWord("test"));
        System.out.println(trie.isWord("fire"));
        System.out.println(trie.isWord("fir"));
        System.out.println(trie.isWord("amazon"));
    }
}
