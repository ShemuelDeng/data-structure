package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树，
 * 树的节点带权值，
 * 带权路径值=节点的权值*该节点到很节点的边数（也可以说是树的深度-1，或者树的层数-1）
 * 当一棵树的所有节点的带权路径值的和 最小时，则称这棵树为哈夫曼树
 * 也叫作最优二叉树
 */
public class HuffManTree {


    private static int[] array = {1,2,3,4,5,6};



    public static Node createHuffmanTree(){
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            nodes.add(new Node(array[i]));
        }

        while (nodes.size() > 1){
            Collections.sort(nodes);
            // 需要先将节点排序好
            // 然后取的最小的两个节点，构造成一颗树，树的父节点的权值即为两个最小节点之和
            Node node = nodes.get(0);
            Node node1 = nodes.get(1);
            Node parent = new Node(node.value+node1.value);
            parent.left = node;
            parent.right = node1;
            // 然后将两个最小的节点移除
            // 再将父节点 加入到该集合中，之后重复整个步骤，
            // 当集合中只剩一个节点的时候，则整颗赫夫曼树构建完成
            // 最后一个节点即为赫夫曼树的根节点
            nodes.remove(node);
            nodes.remove(node1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        Node huffmanTree = createHuffmanTree();
        huffmanTree.preOrder();
    }

    private static class Node implements Comparable<Node>{
        int value; // 节点的权值
        protected Node left; // 左节点
        protected Node right; // 右节点
        public Node(int value){
            this.value = value;
        }

        protected void preOrder(){
            System.out.print(this.value + "\t");
            if (this.left != null){
                this.left.preOrder();
            }
            if (this.right != null){
                this.right.preOrder();
            }
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
