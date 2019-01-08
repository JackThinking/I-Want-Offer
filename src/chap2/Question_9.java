package chap2;

import java.util.Stack;

/**
 * Created by Citrix on 2019-01-08.
 */
public class Question_9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (stack1.peek()==null) {
                stack2.push(stack1.pop());//stack加入应该是add的，我还以为
            }
        }
        /*
         * 别忘记写个异常处理呀
         * */
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }
        return stack2.pop();
    }
}
