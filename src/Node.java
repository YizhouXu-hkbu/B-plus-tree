public class Node {
    /**
     * key is values stored in this B+ Tree
     */
    private Entry[] key;
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

    private boolean leaf;
    private boolean root;

    public Node() {
        int T=2;
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf=true;
        this.root=true;
    }

    public Node(int k) {
        int T=2;
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;

        key[0]=new Entry(k);
    }

    public Node(Entry k) {
        int T=2;
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

    public void setKey(int position, int value) {
        this.key[position].setEntryKey(value);
    }

    public void setChild(int position, Node n) {
        this.child[position]=n;
    }

    public Node getChild(int position) {
        return this.child[position];
    }

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


    /*
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
    }*/

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
    }
}
