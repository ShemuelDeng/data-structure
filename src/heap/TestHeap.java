package heap;


/**
 * 测试大顶堆
 */
public class TestHeap {
    public static void main(String[] args) {
//        TopHeap bigTopHeap = new TopHeap(20);
//        bigTopHeap.add(9);
//        bigTopHeap.add(5);
//        bigTopHeap.add(6);
//        bigTopHeap.add(17);
//        bigTopHeap.add(21);
//        bigTopHeap.add(16);
//        bigTopHeap.add(33);
//        bigTopHeap.add(13);
//        bigTopHeap.add(15);
//        bigTopHeap.add(7);
//        bigTopHeap.add(8);
//        bigTopHeap.add(1);
//        bigTopHeap.add(2);
//        bigTopHeap.add(22);
//        bigTopHeap.showHeap();

        BigTopHeap<User> bigTopHeap = new BigTopHeap<>(20);
        bigTopHeap.add(new User(1,"zc"));
        bigTopHeap.add(new User(2,"dsx"));
        bigTopHeap.add(new User(3,"yf"));
        bigTopHeap.add(new User(4,"hwh"));
        bigTopHeap.showHeap();
    }
}
