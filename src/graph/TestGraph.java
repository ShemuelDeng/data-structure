package graph;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User dsx = new User("dsx");
        User hwh = new User("hwh");
        User zc = new User("zc");
        User yf = new User("yf");
        users.add(dsx);
        users.add(hwh);
        users.add(zc);
        users.add(yf);
        AdjacencyLinkGraph<User> graph = new AdjacencyLinkGraph(4,users);
        graph.buildRelation(dsx,hwh);
        graph.buildRelation(dsx,zc);
        graph.buildRelation(dsx,yf);
        graph.buildRelation(zc,yf);
        System.out.println("success");
    }
}
