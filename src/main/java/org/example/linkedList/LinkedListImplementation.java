package org.example.linkedList;

import MyExceptions.CustomException;

// todo find(value) ->  индекс объекта должен возвращать или -1

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

    public void insert(int index, T value) throws CustomException {
        if (index > size()) { // если больше на 1, то вызвать add?
            throw new CustomException("index more than array size");
        } else if (index < 0) {
            throw new CustomException("negative index");
        } else if (isEmpty()) { // создать первую ноду?
            throw new CustomException("array is empty");
        }
        this.size++;
        Node<T> current = this.head;
        if (index == size()) {

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<>(value));
        }
//        else if (index == 0) {
//            this.head = this.head.getNext();
//        }
        else {
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> insertion = new Node<>(value);
            insertion.setNext(current.getNext());
            current.setNext(insertion);


        }
    }

    public T pop() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("array is empty");
        }
        Node<T> current = this.head;
        T popValue;
        if (current.getNext() == null) {
            popValue = current.getData();
            this.head = null;
        } else {
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            popValue = current.getNext().getData();
            current.setNext(null);
        }
        this.size--;
        return popValue;
    }

    public void set(int index, T value) throws CustomException {
        if (index > size()) {
            throw new CustomException("index more than array size");
        } else if (index < 0) {
            throw new CustomException("negative index");
        } else if (isEmpty()) {
            this.head = new Node<>(value);
            this.size++;
        }
        // если вставка на место после последнего элемента
        else if (index == size()) {
            this.size++;
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<>(value));
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setData(value);
        }
    }

    public void remove(int index) throws CustomException {
        if (index > size()) {
            throw new CustomException("index more than array size");
        } else if (index < 0) {
            throw new CustomException("negative index");
        } else if (isEmpty()) {
            throw new CustomException("array is empty");
        } else if (index == size()) {
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(null);
        } else if (index == 0) {
            this.head = this.head.getNext();
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        this.size--;
    }

    private String getValues() {
        if (isEmpty()) {
            System.err.println("list is empty");
        }
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            sb.append(String.format("%-3s ", current.getData()));
            current = current.getNext();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "size = " + size + "\n" +
                "values: " + getValues() + "\n";
    }
}


