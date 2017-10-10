import java.util.*;

class RouteBetweenNodes {
    public static class Node {
        String data;
        Node[] relations;

        Node(String data){
            this.data = data;
            relations = new Node[5];
        }

        //use DFS
        public boolean hasRoute(Node destination){
            Set<Node> alreadyVisited = new HashSet<>();

            return hasRoute(alreadyVisited, destination);
        }

        private boolean hasRoute(Set<Node> alreadyVisited, Node destination){
            if(this == destination) return true;
            alreadyVisited.add(this);

            for(Node relation : relations){
                if(relation != null && !alreadyVisited.contains(relation)){
                    if(relation.hasRoute(alreadyVisited, destination))
                        return true;
                }
            }
            return false;
        }
    }

    Node[] nodes;

    RouteBetweenNodes(int size){
        nodes = new Node[size];
        for(int i=0; i<size; i++)
            nodes[i] = new Node(""+i);
    }

    public void addConnection(int rootNode, int[] connections){
        for(int i =0; i<connections.length; i++){
            nodes[rootNode].relations[i] = nodes[connections[i]];
        }
    }

    public static void main(String[] args){
        RouteBetweenNodes graph = new RouteBetweenNodes(7);
        graph.addConnection(0,new int[]{3});
        graph.addConnection(1,new int[]{2});
        graph.addConnection(2,new int[]{0, 3});
        graph.addConnection(3,new int[]{2, 4, 6});
        graph.addConnection(4,new int[]{6});
        graph.addConnection(5,new int[]{4});
        graph.addConnection(6,new int[]{5});

        System.out.println(graph.nodes[0].hasRoute(graph.nodes[6]));
        System.out.println(graph.nodes[6].hasRoute(graph.nodes[0]));
        System.out.println(graph.nodes[0].hasRoute(graph.nodes[1]));
    }
}