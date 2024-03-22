package binarytree;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             BINARY TREE
                             1. Insert
                             2. Search
                             3. InOrder
                             4. PreOrder
                             5. PostOrder
                             6. Exit""");
            switch (Validation.enterInteger("Option: ")){
                case 1:
                    data = Validation.enterInteger("Enter a integer: ");
                    tree.insert(data);
                    break;
                case 2:
                    data = Validation.enterInteger("Enter a integer: ");
                    System.out.println("Search is: " + tree.search(data));
                    break;
                case 3:
                    tree.printInOrder();
                    break;
                case 4:
                    tree.printPreOrder();
                    break;
                case 5:
                    tree.printPostOrder();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    break;
            }
        } while (!finish);
    }

}
