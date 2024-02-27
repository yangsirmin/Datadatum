package org.example.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RealizeStack {
    /**
     * 实现 MyStack 类：
     * 1.void push(int x) 将元素 x 压入栈顶。
     * 2.int pop() 移除并返回栈顶元素。
     * 3.int top() 返回栈顶元素。
     * 4.boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     */
    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        //void push(int x) 将元素 x 压入栈顶。
        public void push(int x) {
            queue.offer(x);
            int size = queue.size() - 1;
            //确保第一个出队列的元素为最后一个插入的
            while(size-- > 0){
                //把队列取出来重新放入
                queue.offer(queue.poll());
            }

        }

        //int pop() 移除并返回栈顶元素。
        public int pop() {
            return queue.poll();
        }

        //int top() 返回栈顶元素。
        public int top() {
            return queue.peek();
        }

        //boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
