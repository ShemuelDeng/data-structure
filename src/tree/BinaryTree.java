package tree;


/**
 * Created by dengshaoxiang on 2019/12/30 11:19
 * description: 二叉树
 */
public class BinaryTree {
    private  TreeNode root ;

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
    public void deleteNode(int data){

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
        if (current == null){
            return;
        }
        // 程序走到这,current 为要删除的节点
        // currentParent 为删除节点的父节点

        // 如果current有两个叶子节点,将 current右子树的最小值(二叉树的左节点是最小的)替换current,同时删除该最小值节点
        if (current.left != null && current.right !=null){
            TreeNode r_tree= current.right; //
            TreeNode r_tree_p=current;
            while (r_tree.left != null){ // 循环找到最小
                r_tree_p = r_tree;
                r_tree = r_tree.left;  // 右子树的左节点是最小的
            }
            // 程序走到这,r_tree是最小的节点,将r_tree的值替换当前要删除节点的值
            current.data = r_tree.data;
            //r_tree是最小的节点赋值给当前要删的节点
            current = r_tree;
            //当前要删的节点的父节 = 最小节点的父节点
            currentParent = r_tree_p;
        }

        // 判断current是否只有一个叶子节点
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
    }

    protected class TreeNode{
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
    }

}
