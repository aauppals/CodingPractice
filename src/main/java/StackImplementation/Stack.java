package StackImplementation;

public class Stack {
    int length;
    int[] stack;
    int top = 0;

    public Stack(int length) {
        stack = new int[length];
    }

    public void push(int data) {
        stack[top] = data;
        top++;
    }

    public int pop() {
        int data = stack[top];
        stack[top] = 0;
        top--;
        return data;
    }

    public int peek() {
        int data = stack[top-1];
        return data;
    }

    public void show() {
        for (int num : stack)
            System.out.println(num);
    }
}
