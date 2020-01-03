---
typora-root-url: src\images
---

# data-structure数据结构
data-structure implements by java language

数据结构java语言实现

##### 链表

- [单向链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/SingleLink.java)
- [双向链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/DoubleLink.java)
- 单向循环链表
- 双向循环链表

##### 栈

- [基于数组的栈](https://github.com/ShemuelDeng/data-structure/blob/master/src/stack/ArrayStack.java)
- 基于链表的栈

##### 队列

- [基于数组的队列](https://github.com/ShemuelDeng/data-structure/blob/master/src/queue/ArrayQueue.java)
- 基于链表的队列

##### 树

- [查找二叉树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/BinaryTree.java)
- [哈夫曼树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/HuffManTree.java)
- [AVL树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/avltree.md)

##### 图

- 无向图

  图的存储方式；

  1. 邻接矩阵

     ![Adjacencymatrix](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/Adjacencymatrix.png)

  2. 邻接链表

     ![AdjacencyLink](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/AdjacencyLink.png)

  **二者的区别**：总共n个顶点，邻接矩阵会为每个顶点分配n个空间，用来存储和剩下的顶点的关系，会存在大量空间浪费，邻接链表不会存在浪费

- 有向图

- 带权图

##### 查找算法

- [线性查找](https://github.com/ShemuelDeng/data-structure/blob/master/src/search/SeqSearch.java)

  线性查找即从头到尾依次遍历

- [二分查找(折半查找)](https://github.com/ShemuelDeng/data-structure/blob/master/src/search/BinarySearch.java)

  二分查找需要被查找的集合有序,然后以集合中间元素向左或向右递归查找

- [插值查找](https://github.com/ShemuelDeng/data-structure/blob/master/src/search/InsertionSearch.java)

  插值查找是二分查找的改进版,改进了mid的位置,使得被查找的元素离mid更近,从而

  减少了查找次数

##### 常见算法题

- [八皇后问题](https://github.com/ShemuelDeng/data-structure/blob/master/src/%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E9%A2%98/EightQueen.java)