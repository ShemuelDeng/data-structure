package graph;

import queue.ArrayQueue;
import stack.ArrayStack;

import java.util.LinkedList;
import java.util.List;

/**
 * 邻接链表的方式存储图E
 */
public class AdjacencyLinkGraph<E> {

    private int vertexNumber; //顶点数

    private List<E>[] vertexLink; // 每个顶点对应的链表

    private List<E> items ; // 所有顶点元素

    public AdjacencyLinkGraph(int size,List items){
        vertexLink = new LinkedList[size];
        if (items == null || items.size() != size)
            throw new RuntimeException("参数有误");
        this.vertexNumber = size;
        for (int i = 0; i < vertexNumber; i++) {
            vertexLink[i] = new LinkedList();
        }
        this.items = items;
    }


    /**
     * 建立sourceElement与targetElement的关系
     * 建立关系后则二者在图上 可达
     * @param sourceElement
     * @param targetElement
     */
    public void buildRelation(E sourceElement,E targetElement){
        // 元素在集合arraylist中的索引
        int sourceIndex = items.indexOf(sourceElement);
        int targetIndex = items.indexOf(targetElement);
        //无向图 建立双向关系
        if (!vertexLink[sourceIndex].contains(targetElement)){
            vertexLink[sourceIndex].add(targetElement);
        }
        if (!vertexLink[targetIndex].contains(sourceElement)){
            vertexLink[targetIndex].add(sourceElement);
        }
    }

    /**
     * 广度优先搜索
     * 使用辅助数据结构 队列来实现遍历
     * @param start 从哪个元素开始找
     * @param end 找哪个元素
     */
    public void BFS(E start,E end){

        //收尾相等 则已经找到
        if (start.equals(end)){
            return;
        }

        //用来记录节点是否被访问
        boolean[] visited = new boolean[this.vertexNumber];
        // 队列，用来记录已经访问的节点，但是该节点还有可达节点未访问
        ArrayQueue<E> queue = new ArrayQueue<>();

        // 用来记录访问的路线，从哪个元素到哪个元素的轨迹
        Object[] ways = new Object[this.vertexNumber];

        for (int i = 0; i < ways.length; i++) {
            ways[i] = -1;
        }


        // 找到start元素在集合中的索引
        int startIndex = items.indexOf(start);
        // 设置为已经访问
        visited[startIndex] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            // 取出队列中的第一个元素
            E current = queue.poll();
            int index = items.indexOf(current);
            for (int i = 0; i < vertexLink[index].size(); i++) {

                // 取出相邻的点
                E son = vertexLink[index].get(i);
                int sonIndex = items.indexOf(son);
                // 没有被访问过
                if (!visited[sonIndex]){
                    // 记录路径
                    ways[sonIndex] = current;
                    if (son.equals(end)){
                        printWays(ways,start,end);
                        return;
                    }
                    // 设置已经被访问
                    visited[sonIndex]= true;
                    queue.add(son);
                }
            }

        }
    }

    /**
     *  打印搜索到目标的路径打印
     * @param ways
     * @param start
     * @param end
     */
    private void printWays(Object[] ways,E start,E end){

        int endIndex = items.indexOf(end);
        if ( !ways[endIndex].equals(-1)  && !start.equals(end)){
            printWays(ways,start,(E)ways[endIndex]);
        }
        System.out.print(end+"\t");
    }

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
}
