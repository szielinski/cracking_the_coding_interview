import java.util.LinkedList;
public class BinaryTree {
    public static class Node {
        public int val;
        public Node[] children;

        public Node(int val){
            this.val = val;
            children = new Node[2];
        }

        public void add(int val){
            if(val == this.val)
                return;
            if(val < this.val){
               if(children[0] != null){
                   children[0].add(val);
               }else{
                    children[0] = new Node(val);
                    return;
               }
            } else {
                if(children[1] != null){
                    children[1].add(val);
                }else{
                    children[1] = new Node(val);
                    return;
                }
            }
        }

        public void toSstring(){
            LinkedList<Node> nodesToVisit = new LinkedList<Node>();
            print(this, nodesToVisit);
        }

        private void print(Node n, LinkedList<Node> nodesToVisit){
            System.out.println(n.val);
            for(Node child : n.children){
                if(child == null)
                    continue;
                nodesToVisit.add(child);
            }
            while(!nodesToVisit.isEmpty())
                print(nodesToVisit.remove(), nodesToVisit);
        }

        // left, root, right
        private static void inOrderTraversal(Node n){
            if(n.children[0] != null) inOrderTraversal(n.children[0]);
            System.out.println(n.val);
            if(n.children[1] != null) inOrderTraversal(n.children[1]);
        }

        // root, left, right
        private static void preOrderTraversal(Node n){
            System.out.println(n.val);
            if(n.children[0] != null) preOrderTraversal(n.children[0]);
            if(n.children[1] != null) preOrderTraversal(n.children[1]);
        }

        // left, right, root
        private static void postOrderTraversal(Node n){
            if(n.children[0] != null) postOrderTraversal(n.children[0]);
            if(n.children[1] != null) postOrderTraversal(n.children[1]);
            System.out.println(n.val);
        }
    }

    public static void main(String[] args){
        Node tree = new Node(5);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(10);
        tree.add(8);
        tree.add(12);
        tree.add(5);
        tree.toSstring();

        System.out.println("in order traversal");
        Node.inOrderTraversal(tree);

        System.out.println("pre order traversal");
        Node.preOrderTraversal(tree);

        System.out.println("post order traversal");
        Node.postOrderTraversal(tree);
    }
}
