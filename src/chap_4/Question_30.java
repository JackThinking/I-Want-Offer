package chap_4;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.Stack;

/**
 * Created by Citrix on 2019-01-10.
 */
public class Question_30 {

    public Stack<Integer> dataStack = new Stack<>();
    public Stack<Integer> minStack = new Stack<>();

    /*
    * 用辅助队列进行判断的方法
    * */
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node <= minStack.peek()) {//或的顺序又搞错了
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
