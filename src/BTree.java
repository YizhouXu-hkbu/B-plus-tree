//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BTree {
    boolean isReady = false;
    int T = 2;
    Node root;

    public BTree(String path) {
        this.root = new Node(this.T);
        File db = new File(path);

        try {
            BufferedReader br = new BufferedReader(new FileReader(db));

            String line;
            while((line = br.readLine()) != null) {
                this.insert(Integer.parseInt(line));
            }

            System.out.println("Building an initial B+-Tree... \nLaunching B+-Tree test program...\nWaiting for your commands: ");
        } catch (Exception var5) {
            System.out.println("The error is \"" + var5.getMessage() + "\"");
            System.out.println("Cannot find the data file. Please check the name.");
            System.exit(1);
        }

    }

    public void insert(int low, int high, int num) {
        System.out.println(num + " data entries with keys randomly chosen between [" + low + ", " + high + "] are inserted!");
    }

    public void insert(int num) {
        System.out.println(this.root.insert(num));
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
