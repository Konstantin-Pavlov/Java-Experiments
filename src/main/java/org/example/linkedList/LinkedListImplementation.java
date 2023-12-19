package org.example.linkedList;

import MyExceptions.CustomException;

public class LinkedListImplementation<T> {
    private int listSize;
    private Node<T> head;

    public LinkedListImplementation() {
        this.head = null;
        this.listSize = 0;
    }

    public int size() {
        return this.listSize;
    }

    // find(value) ->  должен возвращать индекс объекта  или -1
    public int find(T value) {
        try {
            nullCheck(value);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        Node<T> current = this.head;
        for (int i = 0; i < size(); i++) {
            if (current.getData() == value) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public T get(int index) {
        try {
            checkIndex(index);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }


    public void add(T value) {
        try {
            nullCheck(value);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

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
        this.listSize++;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insert(int index, T value) {
        try {
            checkIndex(index);
            nullCheck(value);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.listSize++;
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

    public T pop() {
        try {
            checkIfEmpty();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return null;
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
        this.listSize--;
        return popValue;
    }

    public void set(int index, T value) {
        try {
            checkForNegativeIndex(index);
            checkIfIndexMoreThanSize(index);
            nullCheck(value);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (isEmpty()) {
            this.head = new Node<>(value);
            this.listSize++;
        }
        // если вставка на место после последнего элемента
        else if (index == size()) {
            this.listSize++;
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

    public void remove(int index) {
        try {
            checkIndex(index);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (index == size()) {
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
        this.listSize--;
    }

    private String getValues() {
        if (isEmpty()) {
            System.err.println("list is empty");
            return "list is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            sb.append(String.format("%-3s ", current.getData()));
            current = current.getNext();
        }
        return sb.toString();
    }

    private void checkIndex(int index) throws CustomException {
        checkIfEmpty();
        checkForNegativeIndex(index);
        checkIfIndexMoreThanSize(index);
    }

    private void checkIfIndexMoreThanSize(int index) throws CustomException {
        if (index > size()) {
            throw new CustomException("index more than array size");
        }
    }

    private static <T> void nullCheck(T value) throws CustomException {
        if (value == null) {
            throw new CustomException("illegal value - null");
        }
    }


    private static void checkForNegativeIndex(int index) throws CustomException {
        if (index < 0) {
            throw new CustomException("negative index");
        }
    }

    private void checkIfEmpty() throws CustomException {
        if (isEmpty()) {
            throw new CustomException("array is empty");
        }
    }

    @Override
    public String toString() {
        return "size = " + size() + "\n" +
                "values: " + getValues() + "\n";
    }
}


