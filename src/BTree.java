import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BTree {
    Node root=null;

    public BTree(String path) {
        File db = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(db));
            String line;
            while((line = br.readLine()) != null) {
                this.insert(Integer.parseInt(line));
            }
            System.out.println("Building an initial B+-Tree... \nLaunching B+-Tree test program...\nWaiting for your commands: ");
        } catch (Exception e) {
            System.out.println("The error is \"" + e.getMessage() + "\"");
            System.out.println("Cannot find the data file. Please check the name.");
            System.exit(1);  //terminate the progress with error
        }
    }

    public void insert(int low, int high, int num) {
        System.out.println(num + " data entries with keys randomly chosen between [" + low + ", " + high + "] are inserted!");
    }

    //common insert. After finding the location, insert it. If it is full, then entry the function of insert(node N, int k).
    public void insert(int k){
        if(root==null){
            root=new Node(k);
        }
        else{
            Node n=root;

            while(!n.isLeaf()){
                n=n.findPosition(k);
            }
            if(n.isFull()){
                insert(n,k);
            }
            else{
                n.insert(k);
            }
        }

    }

    private void insert(Node n, int k){

        if(n.isLeaf()){
           if(findParent(n)==null){
               

           }
        }







        /*
            if(findParent(n) == null){
                if(n.isLeaf()){

                }

                Node left=new Node();

                System.out.println("We copy up here");


            }
        System.out.println("we push up here");
          */










    }


    private Node findParent(Node n){
        if(n==null || n.isRoot()){
            return null;
        }
        Node parent=null;
        Node m=root;
        int p=n.getKey(0);

        while(!m.equals(n)){
            parent=m;
            m=m.findPosition(p);
        }
        return parent;
    }


    //Find the entry we want via an integer, this returns the result of integer
    public int find(int k){
        Node n=root;

        if(n==null){
            System.out.println("This is an empty tree!");
            return 0;
        }
        else{
            while(!n.isLeaf()){
                n=n.findPosition(k);
            }
            if(n.findKey(k)!=-1){
                return k;
            }
            System.out.println("Key is not found!");
            return -1;
        }
    }

    //Find the entry we want via an integer, this returns the result of Entry
    public Entry findEntry(int k){
        Node n=root;

        if(n==null){
            System.out.println("This is an empty tree!");
            return null;
        }
        else{
            while(!n.isLeaf()){
                n=n.findPosition(k);
            }
            if(n.findEntry(k)!=null){
                return n.findEntry(k);
            }
            System.out.println("Entry is not found!");
            return null;
        }
    }


    public void copyUp(){

    }




    public void delete(int low, int high) {
        System.out.println("The data entries for values in [" + low + ", " + high + "] are deleted");
    }

    public void print() {
    }

    public void printStats() {
        System.out.println("Statistics of the B+-tree: ");
        System.out.println("    Total number of nodes: ");
        System.out.println("    Total number of data entries: ");
        System.out.println("    Total number of data entries: ");
        System.out.println("    Average fill factor: ");
        System.out.println("    Height of tree: ");
    }
}
