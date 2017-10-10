import java.util.*;

class AdjacencyMatrix {
    private boolean[][] connections;

    AdjacencyMatrix(int size){
        connections = new boolean[size][];
        for(int i=0; i<size; i++){
            connections[i] = new boolean[size];
        }
    }

    public void addConnection(int i, int j){
        connections[i][j] = true;
    }

    public void addConnections(int i, int[] j){
        for(int index =0; index<j.length; index++)
            this.addConnection(i, j[index]);
    }

    public List<Integer> getConnections(int i){
        List<Integer> relations = new ArrayList<Integer>();
        for(int j=0; j<connections[i].length; j++)
            if(connections[i][j]) relations.add(j);
        return relations;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<connections.length; i++){
            sb.append(i).append(": ");
            for(int j=0; j<connections[i].length; j++){
                if(connections[i][j])                    
                    sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Integer depthFirstSearch(int currentPos, int nodeToFind){
        Set<Integer> alreadySeen = new HashSet<>();
        return depthFirstSearch(alreadySeen, currentPos, nodeToFind);
    }
    
    public Integer depthFirstSearch(Set<Integer> alreadySeen, int currentPos, int nodeToFind){
        if(currentPos == nodeToFind) return currentPos;
        System.out.println(currentPos);
        alreadySeen.add(currentPos);
        for(int i=0; i<connections[currentPos].length; i++){
            if(connections[currentPos][i] && !alreadySeen.contains(i)){
                Integer possiblyFound = depthFirstSearch(alreadySeen, i, nodeToFind);
                if(possiblyFound != null) return possiblyFound;
            }
        }
        return null;
    }

    public Integer breadthFirstSearch(int currentPos, Integer nodeToFind){
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> alreadySeen = new HashSet<>();

        queue.add(0);

        while(!queue.isEmpty()){
            Integer current = queue.remove();
            System.out.println(current);
            alreadySeen.add(current);
            if(current == nodeToFind) return current;
            for(int i=0; i<connections[current].length; i++){
                if(connections[current][i] && !alreadySeen.contains(i)){
                    queue.add(i);
                    alreadySeen.add(i);
                }
            }
        }

        return null;
    }

    public static void main(String[] args){
        AdjacencyMatrix graph = new AdjacencyMatrix(7);
        graph.addConnections(0,new int[]{1, 3});
        graph.addConnections(1,new int[]{2});
        graph.addConnections(2,new int[]{0, 3});
        graph.addConnections(3,new int[]{2, 4, 6});
        graph.addConnections(4,new int[]{6});
        graph.addConnections(5,new int[]{4});
        graph.addConnections(6,new int[]{5});
        System.out.print(graph);

        System.out.println("DFS for number 4");
        System.out.println(graph.depthFirstSearch(0, 4));
        System.out.println("DFS for number 8");
        System.out.println(graph.depthFirstSearch(0, 8));

        System.out.println("BFS for number 4");
        System.out.println(graph.breadthFirstSearch(0, 4));
        System.out.println("BFS for number 8");
        System.out.println(graph.breadthFirstSearch(0, 8));
    }
}
