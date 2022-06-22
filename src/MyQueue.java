import java.util.Stack;

public class MyQueue {
    Stack<Integer> firstStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        firstStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        firstStack.push(x);
    }

    public int pop() {
        turnStack(firstStack, tempStack);
        int res = tempStack.pop();
        turnStack(tempStack, firstStack);
        return res;
    }

    public int peek() {
        turnStack(firstStack, tempStack);
        int res = tempStack.peek();
        turnStack(tempStack, firstStack);
        return res;
    }

    public boolean empty() {
        return firstStack.empty();
    }

    public void turnStack (Stack<Integer> stack, Stack<Integer> temp) {
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
    }
}
