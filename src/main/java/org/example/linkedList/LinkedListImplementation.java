package org.example.linkedList;

import MyExceptions.CustomException;

public class LinkedListImplementation<T> {
    private int size;
    private Node<T> head;

    public LinkedListImplementation() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) throws CustomException {
        if (isEmpty()) {
            throw new CustomException("array is empty");
        }
        if (index < 0) {
            throw new CustomException("negative index");
        }
        if (index > size()) {
            throw new CustomException("index more than array size");
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public T pop() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("array is empty");
        }
        Node<T> current = this.head;
        T popValue;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        popValue = current.getNext().getData();
        current.setNext(null);
        return popValue;
    }

    public void print() {
        if (isEmpty()) {
            System.err.println("list is empty");
        }
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void set(int index, T value) throws CustomException {
        if (index == 0 && isEmpty()) {
            this.head = new Node<T>(value);
        } else if (index > size()) {
            throw new CustomException("index more than array size");
        } else if (index < 0) {
            throw new CustomException("negative index");
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setData(value);
        }
    }
}
