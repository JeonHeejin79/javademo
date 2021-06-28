package algorithm.datastructure;

import java.util.Stack;

/**
 * 스택 Stack
 * - Last In First Out
 * - ArrayList 로 구현하는게 좋음
 *   > Stack은 ArrayList의 구버전이라고 할 수 있는
 *     Vector 클래스를 상속받아서 만들어졌다.
 *
 * - method
 *  empty(), peek(), pop(), push(obj), search(obj)
 */
public class STACK {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(2);

        stack.pop();

        stack.peek();
    }
}
