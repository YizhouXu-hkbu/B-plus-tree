public class Node {
    /**
     * key is values stored in this B+ Tree
     */
    private Entry[] EntryList;
    /**
     * child is the child node in the leaf page
     */
    private Node[] child;
    /**
     * leaf is used to figure out if the node has child node
     */
    //private Node sibling;
    /**
     * sibling is the sibling node
     */

    //This can be changed to another value if necessary
    private int T=2;
    private boolean leaf;
    private boolean root;

    //initialization part
    public Node() {
        this.EntryList = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf=true;
        this.root=true;
    }

    /*
    public Node(int k) {
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;

        key[0]=new Entry(k);
    }

    public Node(Entry k) {
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;

        key[0]=k;
    }

    public Node(int k,int m) {
        int T=2;
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;

        key[0]=new Entry(k);
        key[1]=new Entry(m);
    }*/




    //get and set function part
    public int childNumCount(){
        return child.length;
    }


    public int childCount(){
        if(child[0]==null){
            return 0;
        }
        int count=0;
        while(count<this.childNumCount()){
            if(child[count]!=null){
                count++;
            }
            else{
            return count;
            }
        }
        return this.childNumCount();
    }

    public int EntryNumCount(){
        return EntryList.length;
    }

    public boolean isLeaf(){
        return leaf;
    }

    public boolean isRoot(){
        return root;
    }

    public void setLeaf(boolean leaf){
        this.leaf = leaf;
    }

    public void setRoot(boolean root){
        this.root=root;
    }

    public void setEntry(int position, int value) {
        this.EntryList[position].setEntryKey(value);
    }

    public void setChild(int position, Node n) {
        this.child[position]=n;
    }

    public Node getChild(int position) {
        return this.child[position];
    }

    public Entry getEntry(int position){
        return this.EntryList[position];
    }


    //function part
    public void print(){
        System.out.print("This leaf node includes the following numbers:");
        for(Entry i:EntryList){
            System.out.print(" "+ i );
        }
        System.out.println(".");
    }

    public Node findChildWithNumber(int k){
        if(child[0]==null){
            System.out.println("This node has no child!");
            return null;
        }

        if(k<this.getEntry(0).getEntryKey()){
            return this.child[0];
        }
        else if(this.childCount()<2){
            return this.child[1];
        }

        int i=0;
        int j=1;
        while(this.getEntry(j)!=null) {
            if (k > this.getEntry(i).getEntryKey() && k < this.getEntry(j).getEntryKey()) {
                return this.child[j];
            }
            i++;j++;
        }

        return this.child[EntryNumCount()];
    }



/*
    public int GetKeyNumber() {
        int count = 0;
        for (Entry k : key) {
            if (k != null)
                count++;
        }
        return count;
    }

    public int getKey(int position) {
        return this.key[position].getEntryKey();
    }

    //This function is used to find a value in a node. If not found, it will return -1
    public int findKey(int k){
        for(int i=0;i<this.GetKeyNumber();i++){
            if(k==this.key[i].getEntryKey()){
                return k;
            }
        }
        return -1;
    }

    //This function is used to find an entry in a node. If not found, it will return null
    public Entry findEntry(int k){
        for(int i=0;i<this.GetKeyNumber();i++){
            if(k==this.key[i].getEntryKey()){
                return this.key[i];
            }
        }
        return null;
    }

    public void PrintKey() {
        for (Entry k : key) {
            System.out.println(k.getEntryKey());
        }
    }

    public boolean isFull(){
        return this.GetKeyNumber()>=4;
    }




    //insert a number via its value.
    public void insert(int k){
        int location=1;
        while(true){
            if(k>this.key[location-1].getEntryKey()){
                if(this.key[location]==null || k<this.key[location].getEntryKey()){
                    break;
                }
            }
            location++;
        }

        //move the back part one position back, and insert the number into the corresponding position
        //e.g. [2][5][8][] insert 1, [2][2][5][8] first, then [1][2][5][8]
        for(int i=this.GetKeyNumber();i>location;i--){
            this.key[i]=this.key[i-1];
        }

        this.key[location]=new Entry(k);
    }



    public boolean insert(int value) {
        for(int i = 0; i < this.key.length; i++) {
            if (this.key[i] == null) {
                Entry entry=new Entry();
                entry.setEntryKey(value);
                this.key[i]=entry;
                return true;
            }
        }
        return false;
    }

    public Node findPosition(int k){
        int location=0;
        for(int i=0;i<this.GetKeyNumber();i++){
            if(k>this.getKey(i)){
                location++;
            }
        }
        return child[location];
    }


    public void print(){
        System.out.print("This leaf node includes the following numbers:");
        for(int i=0;i<GetKeyNumber();i++){
            System.out.print(" "+this.getKey(i));
        }
        System.out.println(".");
    }*/


}
