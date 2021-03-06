import java.util.Scanner;
public class UI {
    /**
     * btree is the b +tree to be built
     */
    public BTree bTree = new BTree(System.getProperty("user.dir") + "\\db.db");
    /**
     * isReady is used to figure out if the B+ Tree is built.
     */
    public boolean isReady = false;

    public void runOnce() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ");
            if (!isReady) {
                if ("btree".equals(input[0])) {
                    if ("-help".equals(input[1])) {
                        System.out.println("Usage: btree [fname]\n   fname: the name of the data file storing the search key values");
                    } else {
                        bTree = new BTree(input[1]);
                    }
                } else {
                    System.out.println("Cannot recognize the command. Please input valid command.");
                }
            } else {
                switch (input[0]) {
                    case "insert":
                        bTree.insert(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                        break;
                    case "delete":
                        bTree.delete(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                        break;
                    case "print":
                        bTree.print();
                        break;
                    case "stats":
                        bTree.printStats();
                        break;
                    case "quit":
                        System.out.println("Thanks!Byebye");
                        System.exit(0);
                    default:
                        System.out.println("Cannot recognize the command. Please input valid command.");
                }
            }
        }
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.runOnce();
    }
}
