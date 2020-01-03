package graph;

import java.util.ArrayList;
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
     * @param sourceElement
     * @param targetElement
     */
    public void buildRelation(E sourceElement,E targetElement){
        // 元素在集合arraylist中的索引
        int sourceIndex = items.indexOf(sourceElement);
        int targetIndex = items.indexOf(targetElement);
        //无向图 建立双向关系
        vertexLink[sourceIndex].add(targetElement);
        vertexLink[targetIndex].add(sourceElement);
    }
}
