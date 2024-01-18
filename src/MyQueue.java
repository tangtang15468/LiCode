import java.util.Stack;

/**
 * 栈实现队列
 */
class MyQueue {

    Stack<Integer> integers1;
    Stack<Integer> integers2;


    public MyQueue() {
        integers1 = new Stack();
        integers2 = new Stack();

    }
    
    public void push(int x) {
        integers1.push(x);
    }
    
    public int pop() {
        int size = integers1.size();

        for (int i = 0; i < size-1; i++) {
            integers2.push(integers1.pop());
        }

        Integer pop = integers1.pop();

        for (int i = 0; i < size-1; i++) {
            integers1.push(integers2.pop());
        }

        return pop;
    }
    
    public int peek() {
        int size = integers1.size();

        for (int i = 0; i < size-1; i++) {
            integers2.push(integers1.pop());
        }

        Integer pop = integers1.pop();
        integers2.push(pop);


        for (int i = 0; i < size; i++) {
            integers1.push(integers2.pop());
        }

        integers2 = new Stack();

        return pop;
    }
    
    public boolean empty() {
        if (integers1.size() ==0) return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}