import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列实现栈
 */
class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size-1; i++) {
            queue2.add(queue.poll());
        }

        for (int i = 0; i < queue.size()-1; i++) {
            queue.poll();
        }

        Integer poll = queue.poll();

        queue = queue2;

        queue2 = new LinkedList<>();

        return poll;
    }
    
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size-1; i++) {
            queue2.add(queue.poll());
        }

        Integer poll = queue.poll();
        queue2.add(poll);

        queue = queue2;

        queue2 = new LinkedList<>();

        return poll;
    }
    
    public boolean empty() {
        if (queue.size() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        int top = myStack.top();
        System.out.println(top);
        int pop = myStack.pop();
        System.out.println(pop);
        System.out.println(myStack.empty());
    }
}