package tree;

/**
 * Created by dengshaoxiang on 2019/12/31 11:20
 * description:
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(5);
        binaryTree.add(9);
        binaryTree.add(8);
        binaryTree.add(15);
        binaryTree.add(14);
        binaryTree.add(16);
        binaryTree.deleteNode(9);
        binaryTree.add(9);

    }
}
