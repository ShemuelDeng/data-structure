package stack;

/**
 * Created by dengshaoxiang on 2019/12/30 12:38
 * description:
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.empty());
    }
}
