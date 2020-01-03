package tree;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by dengshaoxiang on 2019/12/31 11:20
 * description:
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        add(10);
        add(5);
        add(4);
        add(18);
        add(11);
        add(14);
        add(15);
        deleteNode(18);
        inOrder();

        BSTree<User> bsTree = new BSTree<>();
        bsTree.add(new User(10,"1"));
        bsTree.add(new User(5,"5"));
        bsTree.add(new User(4,"4"));
        User user = new User(18, "18");
        bsTree.add(user);
        bsTree.add(new User(11,"11"));
        bsTree.add(new User(14,"14"));
        bsTree.add(new User(15,"15"));
        bsTree.remove(user);
        System.out.println(user);
    }
}
