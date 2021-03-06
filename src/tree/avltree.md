# AVL树（平衡二叉树）

#### [代码实现](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/AVLTree.java)

  > AVL树是一种高度平衡的平衡二叉树，树中的任意节点的左右子树的高度之差不超过1。

  	当构建一颗排序二叉树时，如果插入一个节点后，二叉树的左右子树的差大于1，则需要手动维护使之达到平衡。

  **情况一：**当右子树的高度-左子树的高度差>1时，就需要进行**左旋转**

  > *注意：*左旋转之后能保证平衡的前提是，比较高的那颗子树的左右子树要满足右子树比左子树高，否则就涉及*到第三种情况*

![nobalance](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/nobalance.png)

  **左旋转步骤：**

    1. 以当前根节点为节点创建一个新的节点
    2. 新的节点的左子树设置为当前根节点的左子树
    3. 新的节点的右子树设置为当前根节点的右子树的左子树
    4. 把当前节点值设置为当前节点的右子树的值
    5. 把当前节点的右子树设置为，右子树的右子树，root.right= root.right.right
    6. 把当前节点的左子树设置为新的节点

  **旋转后：**

  ![balanced](<https://github.com/ShemuelDeng/data-structure/blob/master/src/images/balanced.png>)

  **情况二：**当左子树的高度-右子树的高度>1时，就需要进行**右旋转**,步骤与左旋转相反。

  > 注意：右旋转之后能保证平衡的前提是，比较高的那颗子树的左右子树要满足左子树比右子树高，否则就涉及到第三种情况

  **情况三：**当左右子树的高度差大于1时，且整棵树的左右子树高度之比>1,较高的子树的左右之比<1， 则需要**双旋转**，如下图

![doubleRotate](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/doubleRotate.png)

  **双旋转步骤：**

  1.棵树的**左右**子树高度之比>1,较高的子树的**左右**之比<1，先将子树**左**旋转，再将整棵树 **右**旋转。

  2.棵树的**右左**子树高度之比>1,较高的子树的**右左**之比<1，先将子树**右**旋转，再将整棵树 **左**旋转。

  ```java
    // 检测是否需要右旋转
      private void rightRotateIfNeccessary(){
          // 左子树高度-右子树高度>1
          if (getLeftTreeHeight()-getRightTreeHeight()>1){
              // 左子树的右子树高度>左子树的左子树高度
              if (root.left != null && 	root.left.getRightHeight()>root.left.getLeftHeight()){
                  root.left.leftRotate();
              }
              root.rightRotate();
          }
      }
  ```