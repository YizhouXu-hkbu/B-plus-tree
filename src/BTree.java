import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BTree {
    Node root=null;
    private int T=2;

    public BTree(String path) {
        File db = new File(path);
        try {

            BufferedReader br = new BufferedReader(new FileReader(db));
            String line;
            while((line = br.readLine()) != null) {
                this.insert(Integer.parseInt(line));
            }

            PrintTree();

            System.out.println("Building an initial B+-Tree... \nLaunching B+-Tree test program...\nWaiting for your commands: ");
        } catch (Exception e) {
            System.out.println("The error is \"" + e.getMessage() + "\"");
            System.out.println("Cannot find the data file. Please check the name.");
            System.exit(1);  //terminate the progress with error
        }
    }


    private void insert(int key){

    }

    public void PrintTree(){
        PrintTree(root);
    }



    private void PrintTree(Node n){
        if(n.isLeaf()){
            n.print();
        }

        for(int i=0;i<n.childNumCount();i++){
            if(n.getChild(i)!=null){
                PrintTree(n.getChild(i));
            }
        }
    }





/*
    private Node findParent(Node n){
        if(n==null || n.isRoot()){
            return null;
        }
        Node parent=null;
        Node m=root;

        int p=n.getEntry(0);

        while(!m.equals(n)){
            parent=m;
            m=m.findPosition(p);
        }
        return parent;
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
            //Situation A:bare root
           if(findParent(n)==null){

               Node left=new Node(n.getKey(0),n.getKey(1));
               Node Middle=new Node(new Entry());
               Node Right=new Node(n.getKey(2),n.getKey(3));

               Middle.setChild(0,left);
               Middle.setChild(1,Right);
               Middle.setLeaf(false);
               root=Middle;
               insert(k);

           }
           //situation B:leaf
           else{


           }
        }
*/






        /*
            if(findParent(n) == null){
                if(n.isLeaf()){

                }

                Node left=new Node();

                System.out.println("We copy up here");


            }
        System.out.println("we push up here");
          */










   // }


/*
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


*/

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
