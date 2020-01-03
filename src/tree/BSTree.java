package tree;

import java.util.Objects;

/**
 * Created by dengshaoxiang on 2020/1/3 14:04
 * description: BinarySearchTree 二叉搜索树,二叉排序树
 * 带泛型的 ,泛型类必须实现comparable接口
 */
public class BSTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    /**
     * @description: 添加节点方法
     * @param data
     * @date: 2020/1/3 14:29
     * @author: dengshaoxiang
     */
    public boolean add(E data){
        TreeNode<E> newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeNode temp = root;
        while (temp != null){
            if (temp.item.compareTo(data)>0){
                if (temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else {
                if (temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
        return  false;
    }

    public E remove(E target){
        TreeNode current = root;
        TreeNode parent = null;
        while(current != null){
            if (Objects.equals(current.item,target)){
                break;
            }else if(current.item.compareTo(target)>0){
                parent = current;
                current = current.left;
            }else{
                parent = current;
                current = current.right;
            }
        }
        if (current == null){
            // 未找到要删除的节点
            return null;
        }

        // 如果当前要删的节点包含左右节点,则找到右子树的最小值,替换当前节点的值,并将该最小值删掉
        if (current.right != null && current.right != null){
            TreeNode rTree = current.right;
            TreeNode rTreePar = current;
            while (rTree.left != null){
                rTreePar = rTree;
                rTree = rTree.left;
            }
            current.item = rTree.item; // 右子树的最小值替换当前要删除的节点
            current = rTree; // 将右子树的最小值变成要删除的节点
            parent = rTreePar;
        }

        TreeNode child = null; // 记录要删除的节点的子节点
        if (current.left != null){
            child = current.left;
        }else if (current.right != null){
            child = current.right;
        }

        if (parent.left ==current){
            parent.left = child;

        }else  if (parent.right == current){
            parent.right = child;
        }

        return (E)current.item;
    }

    private class TreeNode<E extends Comparable<E>> {

        private E item;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(E data){
            this.item = data;
        }

    }
}
