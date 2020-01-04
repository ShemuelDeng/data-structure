package graph;

import queue.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User z0 = new User("0");
        User z1 = new User("1");
        User z2 = new User("2");
        User z3 = new User("3");
        User z4 = new User("4");
        User z5 = new User("5");
        User z6 = new User("6");
        User z7 = new User("7");
        users.add(z0);
        users.add(z1);
        users.add(z2);
        users.add(z3);
        users.add(z4);
        users.add(z5);
        users.add(z6);
        users.add(z7);
        AdjacencyLinkGraph<User> graph = new AdjacencyLinkGraph(users.size(),users);
        graph.buildRelation(z0,z1);
        graph.buildRelation(z0,z3);
        graph.buildRelation(z1,z2);
        graph.buildRelation(z1,z4);
        graph.buildRelation(z2,z5);
        graph.buildRelation(z3,z4);
        graph.buildRelation(z4,z5);
        graph.buildRelation(z4,z6);
        graph.buildRelation(z6,z7);
        graph.buildRelation(z7,z5);
        graph.breadFirstPrint(z0);
        System.out.println("success");
        graph.depthFirstPrint(z0);

//        List<User> users = new ArrayList<>();
//        User z0 = new User("0");
//        User z1 = new User("1");
//        User z2 = new User("2");
//        User z3 = new User("3");
//        User z4 = new User("4");
//        User z5 = new User("5");
//
//        users.add(z0);
//        users.add(z1);
//        users.add(z2);
//        users.add(z3);
//        users.add(z4);
//        users.add(z5);
//        AdjacencyLinkGraph<User> graph = new AdjacencyLinkGraph<>(users.size(),users);
//        graph.buildRelation(z0,z1);
//        graph.buildRelation(z0,z3);
//        graph.buildRelation(z0,z4);
//        graph.buildRelation(z0,z5);
//        graph.buildRelation(z1,z2);
//        graph.buildRelation(z1,z4);
//        graph.buildRelation(z3,z4);
//        graph.depthFirstPrint(z0);

    }
}
