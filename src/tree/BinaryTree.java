package tree;


/**
 * Created by dengshaoxiang on 2019/12/30 11:19
 * description: 二叉树不带泛型的
 */
public class BinaryTree {
    private TreeNode root ;


    public boolean add(int data){

        TreeNode parent = root;
        while (parent != null){
            if (data<parent.data){
                if (parent.left == null){
                    parent.left = new TreeNode(data);
                    return true;
                }
                parent = parent.left; // 指针左移
            }else{
                if (parent.right == null){
                    parent.right = new TreeNode(data);
                    return true;
                }
                parent = parent.right; // 指针右移
            }
        }
        root =new TreeNode(data); // 程序走到这, root为空
        return true;
    }

    public TreeNode getNode(int data){
        TreeNode parent = root;
        while (parent != null){
            if (parent.data<data){
                parent = parent.right;
            }else if (parent.data == data){
                return parent;
            }else {
                parent = parent.right;
            }
        }
        return null;
    }

    /**
     * @description:
     * @param data
     * @date: 2019/12/31 13:51
     * @author: dengshaoxiang
     */
    public boolean deleteNode(int data){

        //记录当前节点
        TreeNode current = root;
        // 记录当前节点的父节点
        TreeNode currentParent = null;

        while (current!=null){
            if (current.data>data){
                currentParent = current;
                current = current.left;
            }else if (current.data<data){
                currentParent = current;
                current = current.right;
            }else { // 相等 ,那么当前节点就是要删除的节点
                break; // 退出循环
            }
        }
        if (current == null){  // 如果要要删除的元素不存在, 则current == null
            return false;
        }
        // 程序走到这,current 为要删除的节点
        // currentParent 为删除节点的父节点

        // 如果current有两个叶子节点,将 current右子树的最小值(二叉树的左节点是最小的)替换current,同时删除该最小值节点
        if (current.left != null && current.right !=null){
            TreeNode rTree= current.right; //
            TreeNode rTreePar=current;
            while (rTree.left != null){ // 循环找到最小
                rTreePar = rTree;
                rTree = rTree.left;  // 右子树的左节点是最小的
            }
            // 程序走到这,r_tree是最小的节点,将r_tree的值替换当前要删除节点的值
            current.data = rTree.data;
            //r_tree是最小的节点赋值给当前要删的节点
            current = rTree;
            //当前要删的节点的父节 = 最小节点的父节点
            currentParent = rTreePar;
        }

        // 程序走到这,current为要删除的节点
        // 定一个子节点,记录当前要删除的节点的子几点
        TreeNode child = null;

        if (current.right !=null){
            child =current.right;
        }else if (current.left !=null){
            child =current.left;
        }

        // 执行删除
        if (currentParent == null){
            root = child;
        }else if (currentParent.left == current){
            currentParent.left = child;
        }else {
            currentParent.right = child;
        }
        return true;
    }

    /**
     * 前序遍历 根左右
     * @param treeNode
     */
    private void preOrder(TreeNode treeNode){
        if ( treeNode != null){
            System.out.print(treeNode.data + "\t");
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历 左根右
     * @param treeNode
     */
    private void inOrder(TreeNode treeNode){
        if ( treeNode != null){
            inOrder(treeNode.left);
            System.out.print(treeNode.data + "\t");
            inOrder(treeNode.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    /**
     * 后序遍历 左右根
     * @param treeNode
     */
    private void postOrder(TreeNode treeNode){
        if ( treeNode != null){
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            System.out.print(treeNode.data + "\t");
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private TreeNode getRoot(){
        return this.root;
    }

    /**
     * 计算当前二叉树的左子树的高度
     * @return
     */
    public int getLeftTreeHeight(){
        if (root == null) return 0;
        if (root.left == null ) return 0;
        return root.left.getHeight();
    }
    /**
     * 计算当前二叉树的右子树的高度
     * @return
     */
    public int getRightTreeHeight(){
        if (root == null) return 0;
        if (root.right == null ) return 0;
        return root.right.getHeight();
    }

    /**
     * 计算二叉树的高度
     * @return
     */
    public int getHeight(){
        return root == null ? 0 : root.getHeight();
    }

    private class TreeNode{
        protected int data;
        protected TreeNode left;
        protected TreeNode right;

        public TreeNode(){}
        public TreeNode(int data){
            this.data = data;
        }
        public TreeNode(TreeNode left,int data,TreeNode right){
            this.data = data;
            this.right = right;
            this.left = left;
        }
        public TreeNode(TreeNode left,int data){
            this.data = data;
            this.left = left;
        }
        public TreeNode(int data,TreeNode right){
            this.data = data;
            this.right = right;
        }

        /**
         *  计算当前节点的高度
         * @return
         */
        public int getHeight(){
            return Math.max(this.left == null?0:this.left.getHeight(),this.right == null?0:this.right.getHeight())+1;
        }

        /**
         * 计算当前节点的左子树的高度
         * @return
         */
        public int getLeftHeight(){
            if (left == null) return 0;
            return left.getHeight();
        }
        /**
         * 计算当前节点的右子树的高度
         * @return
         */
        public int getRightHeight(){
            if (right == null) return 0;
            return right.getHeight();
        }
    }

}
