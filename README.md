# data-structure数据结构
data-structure implements by java language

数据结构java语言实现

##### 链表

- [单向链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/SingleLink.java)
- [双向链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/DoubleLink.java)
- [单向循环链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/SingleCircleLink.java)
- [双向循环链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/link/DoubleCircleLink.java)

##### 栈

- [基于数组的栈](https://github.com/ShemuelDeng/data-structure/blob/master/src/stack/ArrayStack.java)
- [基于链表的栈](https://github.com/ShemuelDeng/data-structure/blob/master/src/stack/LinkStack.java)

##### 队列

- [基于数组的队列](https://github.com/ShemuelDeng/data-structure/blob/master/src/queue/ArrayQueue.java)
- [基于链表的队列](https://github.com/ShemuelDeng/data-structure/blob/master/src/stack/LinkQueue.java)

##### 树

- [查找二叉树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/BinaryTree.java)
- [哈夫曼树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/HuffManTree.java)
- [AVL树](https://github.com/ShemuelDeng/data-structure/blob/master/src/tree/avltree.md)

##### 图

###### 图的种类

- [无向图](https://github.com/ShemuelDeng/data-structure/blob/master/src/graph/AdjacencyLinkGraph.java)

  图的存储方式；

  1. 邻接矩阵

     ![Adjacencymatrix](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/Adjacencymatrix.png)

  2. [邻接链表](https://github.com/ShemuelDeng/data-structure/blob/master/src/graph/AdjacencyLinkGraph.java)

     ![AdjacencyLink](https://github.com/ShemuelDeng/data-structure/blob/master/src/images/AdjacencyLink.png)

  3. 十字链表法

  **二者的区别**：总共n个顶点，邻接矩阵会为每个顶点分配n个空间，用来存储和剩下的顶点的关系，会存在大量空间浪费，邻接链表不会存在浪费

- 有向图

- 带权图

###### 图的遍历方式

1. 深度优先遍历

   使用栈实现,递归调用本身是栈的调用过程

   ```java
       /**
        * 深度优先遍历
        * @param start
        */
       public void doDepthFirstPrint(E start,boolean[] visited){
           int startIndex = items.indexOf(start);
           // 设置已经访问
           visited[startIndex] = true;
           System.out.println(start);
           for (E e : vertexLink[startIndex]) {
               if (!visited[items.indexOf(e)]){
                   doDepthFirstPrint(e,visited);
               }
           }
       }
   
       public  void depthFirstPrint(E start){
           boolean[] visited = new boolean[vertexNumber];
           doDepthFirstPrint(start,visited);
       }
   ```

   

2. 广度优先遍历

   使用队列实现,需要创建一个队列辅助实现遍历

   ```java
   /**
        * 广度优先遍历
        * @param start 从哪个位置开始遍历
        */
       public void breadFirstPrint(E start){
           //用来记录节点是否被访问
           boolean[] visited = new boolean[this.vertexNumber];
           // 队列，用来记录已经访问的节点，但是该节点还有可达节点未访问
           ArrayQueue<E> queue = new ArrayQueue<>();
   
           // 找到start元素在集合中的索引
           int startIndex = items.indexOf(start);
           // 设置为已经访问
           visited[startIndex] = true;
           queue.add(start);
   
           while(!queue.isEmpty()){
               // 取出队列中的第一个元素
               E current = queue.poll();
               System.out.print(current+"\t");
               int index = items.indexOf(current);
               for (int i = 0; i < vertexLink[index].size(); i++) {
                   // 取出相邻的点
                   E son = vertexLink[index].get(i);
                   int sonIndex = items.indexOf(son);
                   // 没有被访问过
                   if (!visited[sonIndex]){
                       // 设置已经被访问
                       visited[sonIndex]= true;
                       queue.add(son);
                   }
               }
   
           }
       }
   ```

   

##### 动态规划

- 斐波那契数列
- 传纸条问题
- 背包算法

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

- 字符串匹配算法

- [汉诺塔问题](https://github.com/ShemuelDeng/data-structure/blob/master/src/%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E9%A2%98/HanoiTower.java)

- 贪心算法

- [迷宫问题](https://github.com/ShemuelDeng/data-structure/blob/master/src/%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E9%A2%98/Mase.java)

- 约瑟夫问题

  