import java.lang.Math;
import java.util.*;

class ZeroMatrix {

    private static Set<Integer> rows = new HashSet<Integer>();
    private static Set<Integer> cols = new HashSet<Integer>();

    public static void zeroRow(int i, int[][] matrix){
        for(int j=0; j<matrix[i].length; j++){
            matrix[i][j] = 0;
        }
    }

    public static void zeroColumn(int j, int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            matrix[i][j] = 0;
        }
    }

    public static void zeroMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i : rows)
            zeroRow(i, matrix);
        for(int j : cols)
            zeroColumn(j, matrix);
    }

    public static void display(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(i+""+j+":"+ matrix[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[5][5];
        int count = 1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(Math.random() < .1d){
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = count++;
                }
            }
        }
        System.out.println("Before:");
        display(matrix);
        zeroMatrix(matrix);
        System.out.println("After:");
        display(matrix);
    }
}
