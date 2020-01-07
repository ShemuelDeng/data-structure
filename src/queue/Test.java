package queue;

/**
 * Created by dengshaoxiang on 2020/1/7 15:35
 * description: 测试队列
 */
public class Test {
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.add(1);
        linkQueue.add(2);
        linkQueue.add(3);
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.size());
    }
}
