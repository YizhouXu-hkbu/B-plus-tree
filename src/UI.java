//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Scanner;

public class UI {
    public BTree bTree = new BTree(System.getProperty("user.dir") + "\\B+Tree\\db.db");
    public boolean isReady = false;

    public UI() {
    }

    public void runOnce() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.print("> ");
                String[] input = scanner.nextLine().split(" ");
                if (!this.isReady) {
                    if ("btree".equals(input[0])) {
                        if ("-help".equals(input[1])) {
                            System.out.println("Usage: btree [fname]\n   fname: the name of the data file storing the search key values");
                        } else {
                            this.bTree = new BTree(input[1]);
                            this.isReady = true;
                        }
                    } else {
                        System.out.println("Cannot recognize the command. Please input valid command.");
                    }
                } else {
                    String var3 = input[0];
                    byte var4 = -1;
                    switch(var3.hashCode()) {
                        case -1335458389:
                            if (var3.equals("delete")) {
                                var4 = 1;
                            }
                            break;
                        case -1183792455:
                            if (var3.equals("insert")) {
                                var4 = 0;
                            }
                            break;
                        case 3482191:
                            if (var3.equals("quit")) {
                                var4 = 4;
                            }
                            break;
                        case 106934957:
                            if (var3.equals("print")) {
                                var4 = 2;
                            }
                            break;
                        case 109757599:
                            if (var3.equals("stats")) {
                                var4 = 3;
                            }
                    }

                    switch(var4) {
                        case 0:
                            try {
                                this.bTree.insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                            } catch (Exception var7) {
                                System.out.println("Please input valid numbers!");
                            }
                            break;
                        case 1:
                            try {
                                this.bTree.delete(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                            } catch (Exception var6) {
                                System.out.println("Please input valid numbers!");
                            }
                            break;
                        case 2:
                            this.bTree.print();
                            break;
                        case 3:
                            this.bTree.printStats();
                            break;
                        case 4:
                            System.out.println("Thanks!Byebye\uf04a");
                            System.exit(0);
                        default:
                            System.out.println("Cannot recognize the command. Please input valid command.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("This is used to test if the push is ok.");
        UI ui = new UI();
        ui.runOnce();
    }
}
