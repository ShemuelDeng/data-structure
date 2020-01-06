package tree;

import java.math.BigInteger;

/**
 * Created by dengshaoxiang on 2019/12/31 11:20
 * description:
 */
public class TestTree {
    public static void main(String[] args) {
        AVLTree binaryTree = new AVLTree();
        binaryTree.add(10);
        binaryTree.add(11);
        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.inOrder();
        System.out.println();
        System.out.println(binaryTree.getLeftTreeHeight());
        System.out.println(binaryTree.getRightTreeHeight());
        binaryTree.inOrder();
    }
}
