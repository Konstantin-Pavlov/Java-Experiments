package org.example.stack;

// разобрать
class Task {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack);
        stack.push(10);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(12);
        System.out.println(stack);
        stack.push(-1);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.getMax());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        stack.push(-1);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.pop();


    }
}

class Stack {

    private Node top;
    private int stackSize;
    private int maxItem;
    private int minItem;

    public Stack() {
    }

    public void push(int value) {
        top = new Node(value);
        stackSize++;
    }

    public int pop() {
        try {
            int valueOfTop = top.destroy();
            stackSize--;
            return valueOfTop;
        } catch (IOStackException | NullPointerException stackEx) {
            System.out.println("Стек пуст");
            return 0;
        }
    }

    public int getMin() {
        return minItem;
    }

    public int getMax() {
        return maxItem;
    }

    public int size() {
        return stackSize;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public String toString() {
        return ("Стек длинной: " + stackSize +
                ", MAX = " + maxItem +
                ", MIN = " + minItem);
    }


    private class Node {
        private int storeValue;
        private final Node prevNode;

        public Node(int value) {
            prevNode = top;
            top = this;
            top.storeValue = value;
            evalMaxMin(top.storeValue);
        }

        public int destroy() throws IOStackException {
            int value;
            if (top != null) {
                value = top.storeValue;
                if (top.prevNode != null) {
                    evalMaxMin(top.prevNode.storeValue);
                } else {
                    maxItem = 0;
                    minItem = 0;
                }
                top = top.prevNode;
            } else {
                throw new IOStackException();
            }
            return value;
        }

        private void evalMaxMin(int initCompare) {
            Stack.Node tempNode = top.prevNode;
            maxItem = initCompare;
            minItem = initCompare;
            while (tempNode!= null) {
                if (maxItem < tempNode.storeValue) {
                    maxItem = tempNode.storeValue;
                }
                if (minItem > tempNode.storeValue) {
                    minItem = tempNode.storeValue;
                }
                tempNode = tempNode.prevNode;
            }
        }

    }
}

class IOStackException  extends Exception {

}
