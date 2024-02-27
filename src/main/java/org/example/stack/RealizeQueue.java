package org.example.stack;

import java.util.Stack;

public class RealizeQueue {
    /**
     * 实现 MyQueue 类：
     * 1.void push(int x) 将元素 x 推到队列的末尾
     * 2.int pop() 从队列的开头移除并返回元素
     * 3.int peek() 返回队列开头的元素
     * 4.boolean empty() 如果队列为空，返回 true ；否则，返回 false
     */
    class MyQueue {
        Stack<Integer> stackIn;//负责进栈
        Stack<Integer> stackOut;//负责出栈

        public MyQueue() {
                stackIn = new Stack<>();
                stackOut = new Stack<>();
        }

        //void push(int x) 将元素 x 推到队列的末尾
        public void push(int x) {
            stackIn.push(x);
        }

        //int pop() 从队列的开头移除并返回元素
        public int pop() {
            dumpStackIn();
            return stackOut.pop();
        }

        //int peek() 返回队列开头的元素
        public int peek() {
            dumpStackIn();
            return stackOut.peek();
        }

        //boolean empty() 如果队列为空，返回 true ；否则，返回 false
        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        private void dumpStackIn(){
            if (!stackOut.isEmpty()){
                return;
            }
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
