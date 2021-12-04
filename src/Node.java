public class Node {
    /**
     * key is values stored in this B+ Tree
     */
    private int[] key;
    /**
     * child is the child node in the leaf page
     */
    private Node[] child;
    /**
     * leaf is used to figure out if the node has child node
     */
    private boolean leaf;

    public Node(int T) {
        this.key = new int[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = false;
    }

    public boolean isLeaf(){
        return leaf;
    }

    public void SetLeaf(boolean leaf){
        this.leaf = leaf;
    }

    public void setKey(int position, int value) {
        this.key[position] = value;
    }

    public int GetKeyNumber() {
        int count = 0;
        for (int k : key) {
            if (k != 0)
                count++;
        }
        return count;
    }

    public int getKey(int position) {
        return this.key[position];
    }

    public void PrintKey() {
        for (int k : key) {
            System.out.println(k);
        }
    }

    public boolean insert(int value) {
        for(int i = 0; i < this.key.length; ++i) {
            if (this.key[i] == 0) {
                this.key[i] = value;
                return true;
            }
        }
        return false;
    }
}
