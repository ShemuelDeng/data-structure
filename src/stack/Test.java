package stack;

/**
 * Created by dengshaoxiang on 2019/12/30 12:38
 * description:
 */
public class Test {
    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(2);
//        arrayStack.push(1);
//        arrayStack.push(2);
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
//        arrayStack.push(1);
//        arrayStack.push(2);
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.empty());

        LinkStack arrayStack = new LinkStack();
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.isEmpty());
    }
}
