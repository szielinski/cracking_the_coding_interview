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

    public List<Integer> getConnections(int i){
        List<Integer> relations = new ArrayList<Integer>();
        for(int j=0; j<connections[i].length; j++)
            if(connections[i][j]) relations.add(j);
        return relations;
    }

    public static void main(String[] args){
        AdjacencyMatrix m = new AdjacencyMatrix(10);
        m.addConnection(1, 4);
        m.addConnection(1, 2);
        m.addConnection(1, 8);
        m.addConnection(1, 5);

        m.addConnection(9, 1);

        System.out.println(m.getConnections(1));
        System.out.println(m.getConnections(2));
        System.out.println(m.getConnections(9));
    }
}
