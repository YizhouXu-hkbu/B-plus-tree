//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Node {
    private int[] key;
    private Node[] child;
    private boolean leaf;

    public Node(int T) {
        this.key = new int[2 * T];
        this.child = new Node[2 * T + 1];
        this.leaf = true;
    }

    public void setKey(int position, int value) {
        this.key[position] = value;
    }

    public int getKey(int position) {
        return this.key[position];
    }

    public boolean isEmpty() {
        return this.key[0] == 0;
    }

    public boolean isFull() {
        return this.key[this.key.length - 1] != 0;
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
