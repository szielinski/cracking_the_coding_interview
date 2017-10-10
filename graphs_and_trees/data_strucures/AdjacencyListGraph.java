import java.util.*;

public class AdjacencyListGraph {
    public Node[] nodes;

    static class Node {
        public String name;
        public Node[] children;

        Node(String i){
            name = i;
            children = new Node[5];
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(": ");
            for(int i=0; i<children.length; i++){
                if(children[i] == null)
                    break;
                sb.append(children[i].name).append(" ");
            }
            return sb.toString();
        }
    }

    AdjacencyListGraph(int size){
        nodes = new Node[size];
        for(Integer i=0; i<size; i++){
            nodes[i] = new Node(i.toString());
        }
    }

    public void addConnection(int source, int[] destinations){
        for(int i=0; i<destinations.length; i++){
            nodes[source].children[i] = nodes[destinations[i]];
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nodes.length; i++){
            sb.append(nodes[i]).append("\n");
        }
        return sb.toString();
    }

    public static Node depthFirstSearch(Node root, String itemToFind){
        Set<Node> alreadyVisited = new HashSet<Node>();
        return depthFirstSearch(root, itemToFind, alreadyVisited);
    }
    public static Node depthFirstSearch(Node root, String itemToFind, Set<Node> alreadyVisited){
        if(root == null) return null;
        System.out.println(root.name);
        alreadyVisited.add(root);
        if(root.name.equals(itemToFind)) return root;
        for(int i=0; i<root.children.length; i++){
            if(!alreadyVisited.contains(root.children[i])){
                Node ret = depthFirstSearch(root.children[i], itemToFind, alreadyVisited);
                if(ret != null) return ret;
            }
        }
        return null;
    }

    public static Node breadthFirstSearch(Node root, String itemToFind){
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> alreadyVisited = new HashSet<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node n = queue.remove();
            System.out.println(n.name);
            if(n.name.equals(itemToFind)) return n;
            alreadyVisited.add(n);
            for(Node relation : n.children){
                if(relation != null && !alreadyVisited.contains(relation)){
                    //System.out.println("Adding " + relation.name);
                    queue.add(relation);
                    alreadyVisited.add(relation);
                }
            }
        }

        return null;
    }

    public static void main(String[] args){
        AdjacencyListGraph graph = new AdjacencyListGraph(7);
        graph.addConnection(0,new int[]{1, 3});
        graph.addConnection(1,new int[]{2});
        graph.addConnection(2,new int[]{0, 3});
        graph.addConnection(3,new int[]{2, 4, 6});
        graph.addConnection(4,new int[]{6});
        graph.addConnection(5,new int[]{4});
        graph.addConnection(6,new int[]{5});
        System.out.print(graph);

        System.out.println("DFS for number 4");
        System.out.println(depthFirstSearch(graph.nodes[0], "4"));
        System.out.println("DFS for number 8");
        System.out.println(depthFirstSearch(graph.nodes[0], "8"));

        System.out.println("BFS for number 4");
        System.out.println(breadthFirstSearch(graph.nodes[0], "4"));
        System.out.println("BFS for number 8");
        System.out.println(breadthFirstSearch(graph.nodes[0], "8"));
    }
}
