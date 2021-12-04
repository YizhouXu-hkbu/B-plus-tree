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
    private Node sibling;
    /**
     * sibling is the sibling node
     */

    private boolean leaf;

    public Node(int T) {
        this.key = new Entry[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;
    }

    public boolean isLeaf(){
        return leaf;
    }

    public void SetLeaf(boolean leaf){
        this.leaf = leaf;
    }

    public void setKey(int position, int value) {
        this.key[position].setEntryKey(value);
    }

    public int GetKeyNumber() {
        int count = 0;
        for (Entry k : key) {
            if (k.getEntryKey() != 0)
                count++;
        }
        return count;
    }

    public int getKey(int position) {
        return this.key[position].getEntryKey();
    }

    public void PrintKey() {
        for (Entry k : key) {
            System.out.println(k.getEntryKey());
        }
    }

    public boolean insert(int value) {
        for(int i = 0; i < this.key.length; i++) {

            System.out.println(this.key[i]);
            System.out.println(this.key[i].getEntryKey());

            if (this.key[i].getEntryKey() == 0) {
                this.key[i].setEntryKey(value);
                return true;
            }
        }
        return false;
    }
}
